package org.sevenpay.platform.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.gyzb.platform.web.Constants;
import org.gyzb.platform.web.admin.function.bean.Function;
import org.gyzb.platform.web.admin.login.LoginPath;
import org.gyzb.platform.web.admin.user.bean.User;
import org.gyzb.platform.web.admin.utils.PrivilegeUtils;
import org.gyzb.platform.web.admin.utils.WebUtils;
import org.sevenpay.platform.utils.CommonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sevenpay.bms.meeting.luckdraw.LuckDrawPath;
import com.sevenpay.bms.meeting.winShow.controller.WinShowPath;
import com.sevenpay.bms.task.TaskPath;

/**
 * 权限验证过滤器
 * 
 * @project sevenpay-bms-web
 * @fileName PrivilegeFilter.java
 * @author huiquan.ma
 * @date 2015年5月12日
 * @memo
 */
public class PrivilegeFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(PrivilegeFilter.class);

	private String excludedPages;
	private String[] excludedPageArray;

	public void destroy() {
		logger.info("PrivilegeFilter销毁");
	}

	/**
	 * 过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String requestURI = httpServletRequest.getRequestURI();

		// 清除头部上下文根
		requestURI = requestURI.replaceFirst("^" + httpServletRequest.getContextPath(), "");

		// 清除尾部jsessionid标志
		requestURI = requestURI.replaceAll(";jsessionid.*$", "");
		
		// 
		boolean isExcludedPage = false;
		for (String page : excludedPageArray) {
			if (requestURI.equals(page)) {
				isExcludedPage = true;
				break;
			}
		}

		boolean skip = false;

		CommonData commonData = new CommonData();
		String skipIP = commonData.getConfigMessage().get("SKIP_FILTER_IP");
		logger.debug("**********SKIP_FILTER_IP****" + skipIP);
		if (isExcludedPage) {
			skip = true;
		} else if (requestURI.startsWith("/assets")) {
			skip = true;
		} else if (requestURI.startsWith("/static")) {
			skip = true;
		} else if (requestURI.equals(LoginPath.INDEX)) {
			skip = true;
		} else if (requestURI.equals(LoginPath.LOGIN)) {
			skip = true;
		} else if (requestURI.equals(LoginPath.MAIN)) {
			skip = true;
		} else if (requestURI.equals(LoginPath.TOUPDATEPWD)) {
			skip = true;
		} else if (requestURI.startsWith(WinShowPath.BASE)) {
			skip = true;
		} else if (requestURI.equals(LoginPath.UPDATEPWD)) {
			skip = true;
		} else if (requestURI.endsWith(".ico")) {
			skip = true;
		} else if (requestURI.equals("/")) {
			skip = true;
		} else if (requestURI.equals("")) {
			skip = true;
		} else if (requestURI.matches(LoginPath.LOGOUT)) {
			skip = true;
		} else if (requestURI.startsWith(TaskPath.BASE) && skipIP.indexOf(httpServletRequest.getRemoteAddr()) != -1) {
			skip = true;
		} else if (requestURI.startsWith(LuckDrawPath.BASE)) {
			skip = true;
		}

		// 如果不跳转,那么要进行权限验证
		if (!skip) {
			// 获取登录对象
			User user = WebUtils.getUserInfo();

			if (user == null) {
				logger.error("权限拦截器检查该URI{}请求没有登录", requestURI);
				if (request.getParameter(Constants.Platform.AJAX) != null) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("result", "failure");
					jsonObject.put("message", "当前用户未登录系统!");
					response.setContentType("text/json");
					response.setCharacterEncoding("UTF-8");
					httpServletResponse.getWriter().print(jsonObject.toString());
				} else {
					// 应该返回一个页面,提示会话已失效,用户点击确认后自动跳转到首页
					RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/views/sessionTimeout.jsp");
					dispatcher.forward(httpServletRequest, httpServletResponse);
				}
				return;
			}

			Function func = new Function();
			func.setFunctionUrl(requestURI);

			if (!PrivilegeUtils.hasFunc(user, func)) {
				logger.error("权限拦截器检查该URI请求没有权限,用户ID={}, 请求URI={}", user.getUserId(), requestURI);

				if (request.getParameter(Constants.Platform.AJAX) != null) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("result", "failure");
					jsonObject.put("message", "当前用户没有该操作的权限!");
					response.setContentType("text/json");
					response.setCharacterEncoding("UTF-8");
					httpServletResponse.getWriter().print(jsonObject.toString());
				} else {
					httpServletRequest.setAttribute(Constants.Platform.EXCEPTION_KEY, new Exception(
							"非法请求: 您当前无此权限进行该操作:" + requestURI));
					RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/views/error.jsp");
					dispatcher.forward(httpServletRequest, httpServletResponse);
				}
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

		excludedPages = fConfig.getInitParameter("excludedPages");
		if (StringUtils.isNotEmpty(excludedPages)) {
			excludedPageArray = excludedPages.split(",");
		}
		logger.info("PrivilegeFilter初始化");
	}

}
