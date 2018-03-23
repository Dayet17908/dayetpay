<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/template.jsp"%>
<%@page import="com.sevenpay.bms.merchant.reported.MerchantReportedPath"%>
<%@page import="com.sevenpay.bms.basemanager.merchant.TinyMerchantPath" %>

<html>
<head>
	<meta charset="utf-8" />
	<title>商户报备</title>
	<meta name="keywords" content="七分钱后台管理系统" />
	<meta name="description" content="七分钱后台管理" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<style type="text/css">
		table tr td{word-wrap:break-word;word-break:break-all;}
	</style>
</head>
<script type="text/javascript">
    	/* 校验渠道 */
     $(function(){
		$("#submitData").click(function(){
			if(isNull($("#merchantCode")[0])){
	    		$("#merchantCodeLab").text("商户编号不能为空");
	    		$("#merchantCode").focus();
	    		return false;
	    	}else{
	    		$("#merchantCodeLab").text('');
	    	}
			if(isNull($("#channlCode")[0])){
	    		$("#channlCodeLabel").text("商户渠道不能为空");
	    		return false;
	    	}else{
	    		$("#channlCodeLabel").text('');
	    	 }
			if(isNull($("#role")[0])){
	    		$("#roleCodeLabel").text("报备角色不能为空");
	    		return false;
	    	}else{
	    		$("#roleCodeLabel").text("");
	    	}
			if($("#channlCode").val() == "kftPay"){
				if(isNull($("#thirdLv")[0])){
					$("#categorykftLabel").text("行业类别不能为空");
					return false;
				}
			}
			
			if($("#channlCode").val() != "kftPay"){
				if(isNull($("#categoryId")[0])){
					$("#categoryIdLabel").text("行业类别不能为空");
					return false;
				}
			}
			
			
			var merchantCode=$("#merchantCode").val();
			var channl=$("#channlCode").val();
			var role = $("#role").val();
			//var categoryId =  $("#categoryId").val();
			var categoryId;
			if(channl == "kftPay"){
				categoryId =  $("#thirdLv").val();
			}
			if(channl != "kftPay"){
				categoryId =  $("#categoryId").val();
			}
			$.blockUI();
			$.ajax({
				type:"POST",
				dataType:"json",
				url: window.Constants.ContextPath +'<%=MerchantReportedPath.BASE + MerchantReportedPath.GOTOREPORT%>',
				data:
				{"merchantCode":merchantCode,"channl":channl,"role":role,"categoryId":categoryId},
				success:function(data){
					$.unblockUI();
					if(data.result=="SUCCESS"){
						$.gyzbadmin.alertSuccess(data.message,null,function(){
							window.location.href = window.Constants.ContextPath +'<%=MerchantReportedPath.BASE + MerchantReportedPath.BMSREPORT%>';
	    				});
					  
					  }else{
						$.gyzbadmin.alertFailure(data.message);
					 };
					
				}
			});
			
		});
		
		
     });
		
     //获取行业类目
		function getCategoryList()
		{
			var categoryType = $("#categoryTypeId").val().trim();
			var channlCode = $("#channlCode").val();
			
			$("#category").siblings().remove();

			if ("" == categoryType || categoryType.length == 0) {
				return false;
			}
			
			$.ajax({
				type:"POST",
				dataType:"json",
				url:window.Constants.ContextPath +'<%=TinyMerchantPath.BASE+ TinyMerchantPath.GETCATEGORYTYPE %>',
				data:
				{
					"categoryType" 	: categoryType,
					"channlCode"	: channlCode
				},
				success:function(data){
					if(data.result=="SUCCESS"){
						var categoryList = data.categoryList;
						for ( var category in categoryList) {
							$("#categoryId").append(
									"<option value='"+ categoryList[category].categoryId +"'>"
											+ categoryList[category].categoryName + "</option>");
						}
					}
				}
			})
		}
     	function categoryShow(){
     		
     		
     		var categoryType = $("#categoryTypeId").val().trim();
     		var channlCode = $("#channlCode").val();
     		
     		$(".categoryTypeClass").hide();
     		$(".notPresently").hide();
     		
     		
     		if(channlCode != 'kftPay'){
     			$(".categoryTypeClass").show();
     			
     			$("#category").siblings().remove();
         		
         		if ("" == categoryType || categoryType.length == 0) {
    				return false;
    			}
    			$.ajax({
    				type:"POST",
    				dataType:"json",
    				url:window.Constants.ContextPath +'<%=TinyMerchantPath.BASE+ TinyMerchantPath.GETCATEGORYTYPE %>',
    				data:
    				{
    					"categoryType" 	: categoryType,
    					"channlCode"	: channlCode
    				},
    				success:function(data){
    					if(data.result=="SUCCESS"){
    						var categoryList = data.categoryList;
    						for ( var category in categoryList) {
    							$("#categoryId").append(
    									"<option value='"+ categoryList[category].categoryId +"'>"
    											+ categoryList[category].categoryName + "</option>");
    						}
    					}
    				}
    			})
     		}else{
     			$(".notPresently").show();
     			$("#firstCategory").siblings().remove();
     			//查询一级类目
     			$.ajax({
    				type:"POST",
    				dataType:"json",
    				url:window.Constants.ContextPath +'<%=MerchantReportedPath.BASE + MerchantReportedPath.KFTCATEGORYINFO %>',
    				data:
    				{
    					"LV" 	: "firstLv"
    				
    				},
    				success:function(data){
    					if(data.result=="SUCCESS"){
    						var categoryList = data.categoryList;
    						for ( var category in categoryList) {
    							$("#firstLv").append(
    									"<option value='"+ categoryList[category].firstLvCode +"'>"
    											+ categoryList[category].firstLvName + "</option>");
    						}
    					}
    				}
    			})
     		}
     	}
     	
     	//二级类目
     	function getSecondLvList(){
     		$("#secondCategory").siblings().remove();
     		
     		$.ajax({
				type:"POST",
				dataType:"json",
				url:window.Constants.ContextPath +'<%=MerchantReportedPath.BASE + MerchantReportedPath.KFTCATEGORYINFO %>',
				data:
				{
					"LV" 	: "secondLv",
					"firstLvCode" : $("#firstLv").val()
				
				},
				success:function(data){
					if(data.result=="SUCCESS"){
						var categoryList = data.categoryList;
						for ( var category in categoryList) {
							$("#secondLv").append(
									"<option value='"+ categoryList[category].secondLvCode +"'>"
											+ categoryList[category].secondLvName + "</option>");
						}
					}
				}
			})
     	}
     	
     	function getThirdLvList(){
				$("#thirdCategory").siblings().remove();
     		
     		$.ajax({
				type:"POST",
				dataType:"json",
				url:window.Constants.ContextPath +'<%=MerchantReportedPath.BASE + MerchantReportedPath.KFTCATEGORYINFO %>',
				data:
				{
					"LV" 	: "thirdLv",
					"secondLvCode" : $("#secondLv").val()
				
				},
				success:function(data){
					if(data.result=="SUCCESS"){
						var categoryList = data.categoryList;
						for ( var category in categoryList) {
							$("#thirdLv").append(
									"<option value='"+ categoryList[category].thirdLvCode +"'>"
											+ categoryList[category].thirdLvName + "</option>");
						}
					}
				}
			})
     	}
     	
     	function getCategoryTypeInfo(){
     		var merchantId = $("#merchantCode").val().trim();
     		$.ajax({
				type:"POST",
				dataType:"json",
				url:window.Constants.ContextPath +'<%=MerchantReportedPath.BASE + MerchantReportedPath.QUERYCATEGORYINFO %>',
				data:
				{
					"merchantId" : merchantId
				},
				success:function(data){
					if(data.result=="SUCCESS"){
						var info = data.info;
						$(".nino").show();
						$(".showInfo").text(info.categoryName);
						
					}else{
						$(".nino").hide();
					}
				}
			})
     	}
</script>

<body>
	<!-- 用户信息 -->
	<%@ include file="/include/top.jsp"%>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try{ace.settings.check('main-container' , 'fixed')}catch(e){}
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
							<div class="nino" style="display:none; text-align: center; color: #438eb9;">
								<h3 >商户行业类别信息：<span class="showInfo"></span></h3>
							</div>
						<!-- 查询条件 -->
							<form action='<c:url value="<%=MerchantReportedPath.BASE +MerchantReportedPath.BMSREPORT %>"/>' name="fileUpload" enctype="multipart/form-data" method="post" >
							<table class="search-table" style="margin: 40px 0;">
								<tr>
									<td class="td-left" >填写商户编号</td>
									<td class="td-right" colspan="3"> 
										<span class="input-icon">
											<input type="text" style="width: 300px;"  id="merchantCode" name="merchantCode" maxlength="300" onblur="getCategoryTypeInfo();"  placeholder="请填写商户编号">
											<i class="icon-leaf blue"></i>
											<label class="label-tips" id="merchantCodeLab"></label>
										</span>
									</td>
									
									
								
								<td class="td-left">报备渠道<span style="color:red">*</span></td>
								<td class="td-right">
									<select name="channlCode" id="channlCode" style="width:300px;" onchange="categoryShow()">
										<option value="">--请选择报备渠道--</option>
										 <c:if test="${not empty infoList }">
			                            <c:forEach items="${infoList }" var="info">
			                            	<option id="${info.channlId}" value="${info.channlCode}">${info.channlName}</option>
			                            </c:forEach>
		                    		  </c:if>
									</select>
									<label id="channlCodeLabel" class="label-tips"></label>
								</td>
								<td class="td-left">报备角色<span style="color:red">*</span></td>
								<td class="td-right">
									<select name="role" id="role" style="width:300px;">
										<option value="">--请选择报备角色--</option>
			                            <option value="00" selected="selected">线上线下</option>
			                            <option value="01">线上</option>
			                            <option value="02">线下</option>
									</select>
									<label id="roleCodeLabel" class="label-tips"></label>
								</td>
							</tr>
							<tr class="categoryTypeClass" style="display:none">
								<td class="td-left" colspan="4">行业类别：</td>
								<td class="td-right havePresently" colspan="4">
									<span class="input-icon">
									<select name="categoryTypeId" id="categoryTypeId" style="width:180px;" onchange="getCategoryList();" >
										<option value="">--请选择类目类别--</option>
										<option value="100">实体</option>
										<option value="200">虚拟</option>
									</select>
									<select name="categoryId" id="categoryId" style="width:300px;">
										<option value="" id="category">--请选择类目--</option>
									</select>
									<label id="categoryIdLabel" class="label-tips"></label>
									</span>
								</td>
							</tr>
							<tr class="notPresently" style="display:none">
							<td class="td-left" colspan="4">行业类别：</td>
							<td colspan="2">
								    <div class="col-xs-4 pd0" style="padding:0;">
                                    <select class="form-control" id="firstLv" onchange="getSecondLvList();">
                                         	<option value="" id="firstCategory">--请选择--</option>
                                    </select>
	                                </div>
	                                <div class="col-xs-4 pd0" style="width:31.33%;margin:0 1%;padding:0;">
	                                <select class="form-control" id="secondLv" onchange="getThirdLvList();">
	                                    <option value="" id="secondCategory">--请选择--</option>
	                                </select>
	                                </div>
	                                <div class="col-xs-4 pd0" style="padding:0;">
	                                <select class="form-control" id="thirdLv">
	                                    <option value="" id="thirdCategory">--请选择--</option>
	                                </select>
	                                	<label id="categorykftLabel" class="label-tips"></label>
	                                </div>
								</td>
							</tr>
								
								<tr>
									<td colspan="8" align="center">
										<span class="input-group-btn">
											
											
											<gyzbadmin:function url="<%=MerchantReportedPath.BASE + MerchantReportedPath.BMSREPORT %>">
											<button  class="btn btn-purple btn-sm" data-toggle='modal' id='submitData' data-target="#submitModal" style="width: 300px;margin: 20px;">
												提交报备
												<i class="icon-plus-sign icon-on-center bigger-110"></i>
											</button>
											</gyzbadmin:function>
											</span>
											</td>
											</tr>
								
							</table>
							</form>
							<div class="list-table-header">
								商户报备数据列表
							</div>
							<div class="table-responsive">
								<table id="sample-table-2" class="list-table">
									<thead>
										<tr>
											<th>商户编号</th>
											<th>商户名称</th>
											<th>商户角色</th>
											<th>报备渠道</th>
											<th>报备状态</th>
											<th>报备审核状态</th>	
											<th>进件状态</th>
											<th>进件描述</th>	
											<th>创建时间</th>
										</tr>
									</thead>
									<tbody>
									  <c:forEach items="${reportedList}" var="reported" varStatus="status">
											  <tr class="reported" id="reported">
												<td>${reported.merchantCode }</td>
											    <td>${reported.custName}</td>
											    <td>
											    <c:choose>   
								                        <c:when test="${reported.mchRole == '0' }">  									  
								                                                              线上商户  								  
								                        </c:when>  
								  						<c:when test="${reported.mchRole == '1' }">  									  
								                           	      线下商户 								  
								                        </c:when> 
			                                        </c:choose>
			                                        </td>
											    <td>
											    <c:if test="${reported.channelNo == 'iCr'}">
											    	华润银行
											    </c:if>
											       <c:if test="${reported.channelNo == 'heliPay'}">
											    	合利宝
											    </c:if>
											    </td>
											    <td>
												 	<c:choose>   
								                        <c:when test="${reported.filingStatus == '01'}">  									  
								                                                              未提交报备  								  
								                        </c:when>  
								  						<c:when test="${reported.filingStatus == '00'}">  									  
								                           	      已提交报备 								  
								                        </c:when> 
			                                        </c:choose>
												</td>
												<td>
													<c:choose>   
								                        <c:when test="${reported.auditStatus=='00' }">  									  
								                                                              成功								  
								                        </c:when>  
								  						<c:when test="${reported.auditStatus=='99' }">  									  
								                           	      失败 								  
								                        </c:when> 
								                        <c:when test="${reported.auditStatus=='01' }">  									  
								                           	      待提交审核 								  
								                        </c:when>
								                        <c:when test="${reported.auditStatus=='02' }">  									  
								                           	      提交审核中 								  
								                        </c:when> 
			                                        </c:choose>
												</td>
												
												<td>
													<c:choose>   
								                        <c:when test="${reported.merStatus=='200' }">  									  
								                                                                       成功								  
								                        </c:when>  
								                        <c:otherwise>
								                        	 失败
								                        </c:otherwise>
			                                        </c:choose>
												</td>
												 <td>
												${reported.merMsg}
												</td>
											   <td>
												${reported.createTime }
												</td>
									   </c:forEach> 
										<c:if test="${empty reportedList}">
											<tr><td colspan="8" align="center"><font style="color: red; font-weight: bold;font-size: 15px;">暂无数据</font></td></tr>
										</c:if> 
									</tbody>
								</table>
							</div>
							<!-- 分页 -->
							 <c:if test="${not empty reportedList}">
								<%@ include file="/include/page.jsp"%>
							</c:if> 
						</div>
					</div>
				</div>
				<!-- 底部-->
				<%@ include file="/include/bottom.jsp"%>
			</div><!-- /.main-content -->
			<!-- 设置 -->
			<%@ include file="/include/setting.jsp"%>
		</div><!-- /.main-container-inner -->
		<!-- 向上置顶 -->
		<%@ include file="/include/up.jsp"%>
	</div><!-- /.main-container -->
</body>
</html>

