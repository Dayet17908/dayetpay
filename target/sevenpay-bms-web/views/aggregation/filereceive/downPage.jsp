<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/template.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.sevenpay.bms.bal.filereceive.controller.FileReceivePath"%>
<base target="_self">  
<script src='<c:url value="/static/js/ajaxfileupload.js"/>'></script>
<%-- <script src='<c:url value="/static/My97DatePicker/WdatePicker.js"/>'></script>
<script src='<c:url value="/static/My97DatePicker/AutoDatePicker.js"/>'></script> --%>
<html>
<head>
<meta charset="utf-8" />
<title>聚合对账</title>
<meta name="keywords" content="聚合对账系统" />
<meta name="description" content="聚合对账" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href='<c:url value="/static/css/iconfont.css"/>' />
<style type="text/css">
table tr td {
	word-wrap: break-word;
	word-break: break-all;
}
.channelIdCls{
 width:60%;
}
</style>
</head>
<script type="text/javascript">
function loadBalFile(){
	$(".search-table #status").val($(".search-table #statusTemp").val());
	$(".search-table #fileType").val($(".search-table #fileTypeTemp").val());
}
$(function() {
	var fileReceives = ${fileReceiveList};
	var fileReceiveTrList = $("tr.fileReceive");
	$.each(fileReceives, function(i, value) {
		$.data(fileReceiveTrList[i], "fileReceive", value);
	});
	
	$(".fileUploadBtn").click(function(){
		
		var workDate = $('#fileUploadModal #workDate').val();
		if(kong.test(workDate)) {
			$.gyzbadmin.alertFailure('数据日期不可为空');
			return;
		}
		
			}) 
	$("#submitData").click(function(){
		$.blockUI();
		$.ajax({
			type:"POST",
			url: window.Constants.ContextPath +'<%=FileReceivePath.BASE + FileReceivePath.DOWNFILE %>',
			success:function(data){
				$.unblockUI();
					
				}else{
					$.unblockUI();
					/* $.gyzbadmin.alertFailure(json.message); */
				} 
			}
		});
	})
});
</script>
<body onload="loadBalFile()">
	<!-- 用户信息 -->
	<%@ include file="/include/top.jsp"%>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed');
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<!-- 菜单 -->
			<%@ include file="/include/left.jsp"%>

			<div class="main-content">
				<!-- 路径 -->
				<%@ include file="/include/path.jsp"%>

				<!-- 主内容 -->
				<div class="page-content">
				 <div class="row">
						<div class="col-xs-12">
						<!-- 查询条件 -->
							<form action='<c:url value="<%=FileReceivePath.BASE + FileReceivePath.DOWNFILE %>"/>' method="post" >
							<table class="search-table">
								<tr>
									
									<td class="td-left">文件下载日期：</td>
									<td class="td-right"> 
										<span class="input-icon">
											<input type="text" id="workDate" name="workDate" readonly="readonly"  onfocus="AutoDatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" style="background:#fff url(/static/My97DatePicker/skin/datePicker.gif) no-repeat right!important; width:60%;"/>
											<i class="icon-leaf blue"></i>
										</span>
										
											<gyzbadmin:function url="<%=FileReceivePath.BASE + FileReceivePath.DOWNFILE %>">
											<button type="submit" class="btn btn-purple btn-sm" id="submitFile">
												下载
												<i class="icon-plus-sign icon-on-right bigger-110"></i>
											</button>
											</gyzbadmin:function>
											</span>
									</td>
								<tr>
									<td colspan="6" align="center">
										
											</tr>
								
							</table>
							</form><!-- /.modal -->
					</div>
				</div>
				<!-- /.page-content -->
				<!-- 底部-->
				<%@ include file="/include/bottom.jsp"%>
			</div>
			<!-- /.main-content -->
			<!-- 设置 -->
			<%@ include file="/include/setting.jsp"%>
		</div>
		<!-- /.main-container-inner -->
		<!-- 向上置顶 -->
		<%@ include file="/include/up.jsp"%>
	</div>
</body>
</html>