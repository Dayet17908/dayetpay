package com.sevenpay.bms.app.ad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sevenpay.bms.app.ad.bean.AdManageBean;
import com.sevenpay.bms.app.ad.serivce.AdManageService;
import com.sevenpay.bms.basemanager.advertisement.AdPath;
import com.sevenpay.bms.common.util.PropertiesUtil;

/**
 * APP登录页广告管理控制器
 * @author hongjiagui
 *
 */
@Controller
@RequestMapping(AdManagePath.BASE)
public class AdManageController {
	@Autowired
	private AdManageService adManageService;

	/**
	 * 根据查询条件返回APP登录页广告信息列表
	 * @param queryBean
	 * @return
	 */
	@RequestMapping(AdManagePath.MANAGE)
	public ModelAndView manage(AdManageBean queryBean) {
		ModelAndView mv = new ModelAndView(AdManagePath.BASE + AdManagePath.MANAGE);
		mv.addObject("adManageList", JSONObject.toJSON(adManageService.listAdManageInfo(queryBean)));
		mv.addObject("queryBean", queryBean);
		return mv;
	}
	/**
	 * 添加APP登录广告页信息
	 */
	@RequestMapping(AdManagePath.ADD)
	@ResponseBody
	public String saveAdManageInfo(AdManageBean adManageInfo) {
		String result = adManageService.saveAdManageInfo(adManageInfo);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	/**
	 * 更新APP登录页广告信息
	 */
	@RequestMapping(AdManagePath.UPDATE)
	@ResponseBody
	public String updateAdManageInfo(AdManageBean adManageInfo){
		String result = adManageService.updateAdManageInfo(adManageInfo);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	/**
	 * 删除APP登录页广告信息
	 * @param adId
	 * @return
	 */
	@RequestMapping(AdManagePath.DELETE)
	@ResponseBody
	public String deleteAdManageInfo(String adId){
		String result = adManageService.deleteAdManageInfoByAdId(adId);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	
	/**
	 * 文件上传
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(AdManagePath.FILEUPLOAD)
	@ResponseBody
	public String fileUpload(HttpServletRequest request, HttpServletResponse response) {	
		JSONObject object = new JSONObject();
		String pathName= "";
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> list = upload.parseRequest(request);

			InputStream in = null;
			
			for (FileItem item : list) {
				String filename = null;
				if (!item.isFormField()) {
					filename = item.getName();

					String type = filename.substring(filename.lastIndexOf("."));
					String[] photoTypes = { ".jpg", ".jpeg", ".gif", ".bmp", ".png" };
					boolean isType = false;
					for (int i = 0; i < photoTypes.length; i++) {
						if (photoTypes[i].equalsIgnoreCase(type)) {
							isType = true;
							break;
						}
					}
					if (!isType) {
						object.put("result", "FAIL");
						object.put("message", "文件类型不匹配");

						return object.toJSONString();

					}
					filename = filename.substring(filename.lastIndexOf(File.separator) + 1);
					
					filename = System.currentTimeMillis() + filename;
					in = item.getInputStream();

					Properties pps = PropertiesUtil.getProperties();

					String path=  pps.getProperty("ADMANAGE_FILE_SAVE_PATH");
					pathName = path + File.separator + filename;

					File saveFile = new File(path);
					if (!saveFile.exists()) {
						saveFile.mkdirs();
					}
					FileOutputStream out = new FileOutputStream(pathName);

					byte buffer[] = new byte[1024];
					int len = 0;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
				}

			}
			
		
			object.put("result", "SUCCESS");
			object.put("message", "上传成功");
			object.put("pathName", pathName);

		} catch (Exception e) {
			
			object.put("result", "fail");
			object.put("message", e.getMessage());
		}
		return object.toJSONString();
	}
	// 读取服务器图片
	@RequestMapping(AdManagePath.IMAGE)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgPath = request.getParameter("imgPath");
		if (imgPath != null) {
			OutputStream os = response.getOutputStream();
			File file = new File(imgPath);
			FileInputStream fips = new FileInputStream(file);
			if (file.exists()) {
				byte[] btImg = readStream(fips);
				os.write(btImg);
				os.flush();
				if (null != fips) {
					fips.close();
				}
				if (null != os) {
					os.close();
				}

			}
		}
	}
	
	/**
	 * 读取管道中的流数据
	 */
	public byte[] readStream(InputStream inStream) {
		ByteArrayOutputStream bops = new ByteArrayOutputStream();
		int data = -1;
		try {
			while ((data = inStream.read()) != -1) {
				bops.write(data);
			}
			return bops.toByteArray();
		} catch (Exception e) {
			return null;
		} finally {
			if (null != bops) {
				try {
					bops.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
