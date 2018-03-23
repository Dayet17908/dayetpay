<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/template.jsp"%>
<%@page import="com.sevenpay.bms.basemanager.merchant.StoreManagePath" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>门店列表</title>
<link rel="stylesheet" href="<c:url value='/static/css/combo.select.css' />" />
<meta name="keywords" content="七分钱后台管理系统" />
<meta name="description" content="七分钱后台管理" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style type="text/css">
	table tr td{word-wrap:break-word;word-break:break-all;}
</style>
</head>
<script src='<c:url value="/static/My97DatePicker/WdatePicker.js"/>'></script>
<script src='<c:url value="/static/js/jquery-ui.min.js"/>'></script>
<script src="<c:url value='/static/js/jquery.combo.select.js'/>"></script>
<script type="text/javascript">
/* function loadQueryBean(){
	$("#mchId").val($("#mchIdHidden").val()); 
 	$("#storeForm").find(".combo-input").val($("#mchId option:selected").text());
 	
} */
$(document).ready(function(){
	/* $("#mchId").comboSelect(); */ 
	$("#merchantCodeAdd").comboSelect();
	var storeManageInfoLists = ${storeManageInfoList};
	var storeManageInfoList = $("tr.store");

		
	 $.each(storeManageInfoLists,function(i,value){
	 	$.data(storeManageInfoList[i],"store",value);
	 }); 

	 $('.clearStoreManageInControClr').click(function(){			
			$(".page-content #mchId").val("");
			$(".page-content #custName").val("");
			$(".page-content #shopNo").val("");
			$(".page-content #shopName").val("");
			
		}) 
		
	// 添加商户新门店 
	$(".addStoreManageBtn").click(function(){
		var mchId = $("#addStoreManageModal #merchantCodeAdd").val().trim();
		
		if(kong.test(mchId)) {
			$.gyzbadmin.alertFailure("商户编号不可为空");
			$("#addStoreManageModal #mchId").focus();
			return;
		}
		
		var validate =false ;
		$.ajax({
			async:false,
			dataType:"json",
			url:window.Constants.ContextPath +'<%=StoreManagePath.BASE+StoreManagePath.VALIDATE%>',
	        data:{'merchantCode':mchId},
	        success:function(data){
	        	if(data.result=="success"){
					validate = true;
				}else{
					$.gyzbadmin.alertFailure("添加失败！"+data.message);
					validate = false;
				}
				 }});
		if(!validate){
			return false;
		}

		
		var shopNo = $("#addStoreManageModal #shopNo").val().trim();
		if(kong.test(shopNo)) {
			$.gyzbadmin.alertFailure("门店编号不能为空");
			$("#addStoreManageModal #shopNo").focus();
			return;
		}
		var validate =false ;
		$.ajax({
			async:false,
			dataType:"json",
			url:window.Constants.ContextPath +'<%=StoreManagePath.BASE+StoreManagePath.REPEAT%>',
	        data:{'mchId':mchId,
	        	  'shopNo':shopNo},
	        success:function(data){
	        	if(data.result=="success"){
					validate = true;
				}else{
					$.gyzbadmin.alertFailure("添加失败！"+data.message);
					validate = false;
				}
				 }});
		if(!validate){
			return false;
		}
		
		
		var shopName = $("#addStoreManageModal #shopName").val().trim();
		if(kong.test(shopName)) {
			$.gyzbadmin.alertFailure("门店名称不可为空");
			$("#addStoreManageModal #shopName").focus();
			return;
		}
		
		var addr = $("#addStoreManageModal #addr").val().trim();
	    if(kong.test(addr)) {
			$.gyzbadmin.alertFailure("门店地址不可为空");
			$("#addStoreManageModal #addr").focus();
			return;
		} 
		
		var contact = $("#addStoreManageModal #contact").val().trim();
		if(kong.test(contact)) {
			$.gyzbadmin.alertFailure("门店联系方式不可为空");
			$("#addStoreManageModal #contact").focus();
			return;
		}
	
		var status = $("#addStoreManageModal input[type='radio']:checked").val().trim();
			
		if(kong.test(status)) {
			$.gyzbadmin.alertFailure("请选择状态");
			return;
		}
	
		
		$.blockUI();
		 $.ajax({
			type:"POST",
			dataType:"json",
			url:window.Constants.ContextPath +'<%=StoreManagePath.BASE + StoreManagePath.ADD %>',
			data:
			{
				"mchId" 		: mchId,
				"shopNo" 		: shopNo,
				"shopName" 		: shopName,
				"addr" 			: addr,
				"contact"		: contact,
				"status" 		: status
			},
			success:function(data){
				$.unblockUI();
				if(data.result=="success"){
					$.gyzbadmin.alertSuccess("添加成功！",function(){
						$("#addStoreManageModal").modal("hide");
					},function(){
						window.location.reload();
					});
				}else{
					$.gyzbadmin.alertFailure("添加失败！"+data.message);
				}
			}
		});
	});


	//添加门店
		$(".addStoreManageLink").click(function(){

			 var store = $.data($(this).parent().parent()[0],"store");
			 
			 $('#addStoreManageModalS').on('show.bs.modal', function () {

					$("#addStoreManageModalS #mchId").val(store.mchId);
				    $("#addStoreManageModalS #custName").val(store.custName);
			 });
			  /* $('#addStoreManageModalS').on('hide.bs.modal', function () {
				  	$("#addStoreManageModalS #mchId").val('');
		 	    	$("#addStoreManageModalS #custName").val('');
			  });  */
		}); 
		
		$(".addStoreManageBtns").click(function(){
	
				var mchId = $("#addStoreManageModalS #mchId").val().trim();
				if(kong.test(mchId)) {
					$.gyzbadmin.alertFailure("商户编号不可为空");
					$("#addStoreManageModalS #mchId").focus();
					return;
				}
				/* var shopId = $("#addStoreManageModalS #shopId").val().trim();
				if(kong.test(shopId)) {
					$.gyzbadmin.alertFailure("门店Id不可为空");
					$("#addStoreManageModalS #shopId").focus();
					return;
				}
			 */
				var custName = $("#addStoreManageModalS #custName").val().trim();
				if(kong.test(custName)) {
					$.gyzbadmin.alertFailure("商户不可为空");
					$("#addStoreManageModalS #custName").focus();
					return;
				}
				
				var shopNo = $("#addStoreManageModalS #shopNo").val().trim();
				if(kong.test(shopNo)) {
					$.gyzbadmin.alertFailure("门店编号不能为空");
					$("#addStoreManageModalS #shopNo").focus();
					return;
				}
				
				var shopName = $("#addStoreManageModalS #shopName").val().trim();
				
				if(kong.test(shopName)) {
					$.gyzbadmin.alertFailure("门店名称不可为空");
					$("#addStoreManageModalS #shopName").focus();
					return;
				}
				
				var addr = $("#addStoreManageModalS #addr").val().trim();
			    if(kong.test(addr)) {
					$.gyzbadmin.alertFailure("门店地址不可为空");
					$("#addStoreManageModalS #addr").focus();
					return;
				} 
				
				var contact = $("#addStoreManageModalS #contact").val().trim();
				if(kong.test(contact)) {
					$.gyzbadmin.alertFailure("门店联系方式不可为空");
					$("#addStoreManageModalS #contact").focus();
					return;
				}
		
				var status = $("#addStoreManageModalS input[type='radio']:checked").val().trim();
				
				if(kong.test(status)) {
					$.gyzbadmin.alertFailure("状态");
					$("#addStoreManageModalS #status").focus();
					return;
				}
				
				var validate =false ;
				$.ajax({
					async:false,
					dataType:"json",
					url:window.Constants.ContextPath +'<%=StoreManagePath.BASE+StoreManagePath.REPEAT%>',
			        data:{'merchantCode':mchId,
			        	  'shopNo':shopNo,
			        	  'shopName':shopName,
			        	  'addr':addr,
			        	  'contact':contact,
			        	  'status':status },
			        success:function(data){
			        	if(data.result=="success"){
			        		$.blockUI();
							 $.ajax({
								type:"POST",
								dataType:"json",
								url:window.Constants.ContextPath +'<%=StoreManagePath.BASE + StoreManagePath.ADD %>',
								data:
								{	
									"mchId"			: mchId,
									"custName" 		: custName,
									"shopNo" 		: shopNo,
									"shopName" 		: shopName,
									"addr" 			: addr,
									"contact"		: contact,
									"status" 		: status
								},
								success:function(data){
									$.unblockUI();
									if(data.result=="success"){
										$.gyzbadmin.alertSuccess("添加成功！",function(){
											$("#addStoreManageModalS").modal("hide");
										},function(){
											window.location.reload();
										});
									}else{
										$.gyzbadmin.alertFailure("添加失败！"+data.message);
									}
								}
							});
						}else{
							$.gyzbadmin.alertFailure("添加失败！"+data.message);
							validate = false;
						}
						 }});
				
				
				
			});
		


	 
	//编辑
	$(".updateStoreManageLink").click(function(){

		 var store = $.data($(this).parent().parent()[0],"store");
		 
		 $('#updateStoreManageModal').on('show.bs.modal', function () {

				$("#updateStoreManageModal #mchId").val(store.mchId);
				$("#updateStoreManageModal #shopId").val(store.shopId); 
			    $("#updateStoreManageModal #custName").val(store.custName);   
			 	$("#updateStoreManageModal #shopNo").val(store.shopNo);
			 	$("#updateStoreManageModal #shopName").val(store.shopName);
			 	$("#updateStoreManageModal #addr").val(store.addr);
			 	$("#updateStoreManageModal #contact").val(store.contact);
				$("input[name='status'][value='" + store.status + "']").attr("checked",true);  
		 });
		  $('#updateStoreManageModal').on('hide.bs.modal', function () {
			  	$("#updateStoreManageModal #mchId").val('');
			    $("#updateStoreManageModal #shopId").val('');
	 	    	$("#updateStoreManageModal #custName").val(''); 
				$("#updateStoreManageModal #shopNo").val('');
				$("#updateStoreManageModal #shopName").val('');
				$("#updateStoreManageModal #addr").val('');
				$("#updateStoreManageModal #contact").val('');
				$("#updateStoreManageModal input[name='status'][checked]").val('');
		  }); 
	});
	
	$(".updateStoreManageBtn").click(function(){

			var mchId = $("#updateStoreManageModal #mchId").val().trim();
			if(kong.test(mchId)) {
				$.gyzbadmin.alertFailure("商户编号不可为空");
				$("#updateStoreManageModal #mchId").focus();
				return;
			}
		
			var shopId = $("#updateStoreManageModal #shopId").val().trim();
			if(kong.test(shopId)) {
				$.gyzbadmin.alertFailure("门店名称不可为空");
				$("#updateStoreManageModal #shopId").focus();
				return;
			}
		
			var custName = $("#updateStoreManageModal #custName").val().trim();
			if(kong.test(custName)) {
				$.gyzbadmin.alertFailure("商户不可为空");
				$("#updateStoreManageModal #custName").focus();
				return;
			}
			
			var shopNo = $("#updateStoreManageModal #shopNo").val().trim();
			if(kong.test(shopNo)) {
				$.gyzbadmin.alertFailure("门店编号不能为空");
				$("#updateStoreManageModal #shopNo").focus();
				return;
			}
			var validate =false ;
			$.ajax({
				async:false,
				dataType:"json",
				url:window.Constants.ContextPath +'<%=StoreManagePath.BASE+StoreManagePath.REPEAT%>',
		        data:{'merchantCode':mchId,
		        	  'shopNo':shopNo,
		        	  'shopName':shopName,
		        	  'addr':addr,
		        	  'contact':contact,
		        	  'status':status },
		        success:function(data){
		        	if(data.result=="success"){
						validate = true;
					}else{
						$.gyzbadmin.alertFailure("添加失败！"+data.message);
						validate = false;
					}
					 }});
			if(!validate){
				return false;
			}
			var shopName = $("#updateStoreManageModal #shopName").val().trim();
			if(kong.test(shopName)) {
				$.gyzbadmin.alertFailure("门店名称不可为空");
				$("#updateStoreManageModal #shopName").focus();
				return;
			}
			
			var addr = $("#updateStoreManageModal #addr").val().trim();
		    if(kong.test(addr)) {
				$.gyzbadmin.alertFailure("门店地址不可为空");
				$("#updateMerchantModal #addr").focus();
				return;
			} 
			
			var contact = $("#updateStoreManageModal #contact").val().trim();
			if(kong.test(contact)) {
				$.gyzbadmin.alertFailure("门店联系方式不可为空");
				$("#updateStoreManageModal #contact").focus();
				return;
			}
	
			var status = $("#updateStoreManageModal input[type='radio']:checked").val().trim();
			
			if(kong.test(status)) {
				$.gyzbadmin.alertFailure("请选择状态");
				return;
			}
	
			
			$.blockUI();
			 $.ajax({
				type:"POST",
				dataType:"json",
				url:window.Constants.ContextPath +'<%=StoreManagePath.BASE + StoreManagePath.EDIT %>',
				data:
				{	
					"mchId"			: mchId,
					"shopId"        : shopId,
					"custName" 		: custName,
					"shopNo" 		: shopNo,
					"shopName" 		: shopName,
					"addr" 			: addr,
					"contact"		: contact,
					"status" 		: status
				},
				success:function(data){
					$.unblockUI();
					if(data.result=="success"){
						$.gyzbadmin.alertSuccess("修改成功！",function(){
							$("#updateStoreManageModal").modal("hide");
						},function(){
							window.location.reload();
						});
					}else{
						$.gyzbadmin.alertFailure("修改失败！"+data.message);
					}
				}
			});
		});


 	<%-- //删除
	$(".deleteStoreManageLink").click(function(){
		var store = $.data($(this).parent().parent()[0],"store");		
		$("#deleteStoreManageModal").find("input[name='shopId']").val(store.shopId);
		$("span.sureDel").text(store.shopId);
		
	});
	
	$(".deleteStoreManageBtn").click(function(){
		
		var shopId= $("#deleteStoreManageModal #shopId").val().trim();
		if(kong.test(shopId)) {
			$.gyzbadmin.alertFailure("门店名称不可为空");
			$("#deleteStoreManageModal #shopId").focus();
			return;
		}
		
		$.blockUI();
		$.ajax({
			type:"POST",
			dataType:"json",
			url:window.Constants.ContextPath +'<%=StoreManagePath.BASE + StoreManagePath.DELETE %>',
			data:"shopId="+shopId,
			success:function(data){
				$.unblockUI();
				
				if(data.result=='success'){
					
					$.gyzbadmin.alertSuccess("删除成功！",function(){
						$("#deleteStoreManageModal").modal("hide");
					},function(){
						window.location.reload();
					});
				}else{
					$.gyzbadmin.alertFailure("删除失败！"+data.message);
				}
			}
		});
	}); --%>
 
});


</script>

<!-- <body onload="loadQueryBean()"> -->
<body>
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
						<!-- 查询条件 -->
						<form  id="storeForm" action='<c:url value="<%=StoreManagePath.BASE + StoreManagePath.LIST %>"/>' method="post">
							<table class="search-table">
								<tr>
									<%--
								    <input type="hidden" id="mchIdHidden" value="${queryBean.mchId }"/>
									<td class="td-left">商户名称</td>
									<td class="td-right">
										<select id="mchId" name="mchId">
											<option value="">输入商户名查询</option>
											<c:forEach items="${merchantList }" var="bean">
												<option value="${bean.custId }">${bean.custName }</option>
											</c:forEach>
										</select>
									</td> 
									--%>	
									<td class="td-left" >商户名称:</td>
									<td class="td-right" > 
										<span class="input-icon">
											<input type="text"  name="custName" id="custName"  value="${queryBean.custName }">
											<i class="icon-leaf blue"></i>
										</span>
									</td> 	
									<td class="td-left" >商户编号：</td>
									<td class="td-right" > 
										<span class="input-icon">
											<input type="text"  name="merchantCode" id="merchantCode"  value="${queryBean.merchantCode }">
											<i class="icon-leaf blue"></i>
										</span>
									</td>						
									<td class="td-left" >门店名称：</td>
									<td class="td-right" > 
										<span class="input-icon">
											<input type="text"  name="shopName" id="shopName"  value="${queryBean.shopName }">
											<i class="icon-leaf blue"></i>
										</span>
									</td>
									<td class="td-left">门店编号：</td>
									<td class="td-right">
										<span class="input-icon">
											<input onkeyup="value=value.replace(/[^\d|^\w.//]/ig,'')" type="text" name="shopNo"   id="shopNo"  value="${queryBean.shopNo }">
											<i class="icon-leaf blue"></i>
										</span>
									</td>																					
								</tr>
								<tr>
									<td colspan="10" align="center">
										<span class="input-group-btn">
											<gyzbadmin:function url="<%=StoreManagePath.BASE + StoreManagePath.LIST %>">
												<button type="submit" class="btn btn-purple btn-sm" >
													查询
													<i class="icon-search icon-on-right bigger-110"></i>
												</button>
											</gyzbadmin:function>
											
											<button class="btn btn-purple btn-sm btn-margin clearStoreManageInControClr"  >
												清空
												<i class=" icon-move icon-on-right bigger-110"></i>
											</button>
									
											<gyzbadmin:function url="<%=StoreManagePath.BASE + StoreManagePath.ADD%>">
												<button class="btn btn-purple btn-sm " data-toggle='modal' data-target="#addStoreManageModal" >
													添加新门店
													<i class=" icon-plus-sign icon-on-right bigger-110"></i>
												</button>
											</gyzbadmin:function>
										</span>
									</td>
								</tr>
							</table>
						</form>
						
						<div class="list-table-header">门店列表</div>
						<div class="table-responsive">
								<table id="sample-table-2" class="list-table">
									<thead>
										<tr>
											<th style="display:none">门店唯一ID</th>
											<th >商户编号</th>
											<th >商户名称</th>
											<th >门店编号</th>
											<th >门店名称</th>
											<th >门店地址</th>
											<th >门店联系方式</th>
											<th >门店状态</th>
											<th >操作</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${storeManageInfoList }" var="store">
										<tr class="store">
											<td style="display:none">${store.shopId }</td>
											<td>${store.merchantCode }</td>
											<td>${store.custName }</td>
											<td>${store.shopNo }</td>
											<td>${store.shopName }</td>
											<td>${store.addr }</td>
											<td>${store.contact }</td>
											<td>
												<c:if test="${store.status=='1'}">可用</c:if>
												<c:if test="${store.status=='0'}">不可用</c:if>
											</td>
											<td>
												<gyzbadmin:function url="<%=StoreManagePath.BASE + StoreManagePath.EDIT%>">
													<a href="#updateStoreManageModal" class="tooltip-success updateStoreManageLink" data-rel="tooltip" title="Edit" data-toggle='modal'>				
														<span class="green">
															【编辑】
															<!-- <i class="icon-edit bigger-120"></i> -->			
														</span>
													</a>
												</gyzbadmin:function>
												<%-- <gyzbadmin:function url="<%=StoreManagePath.BASE + StoreManagePath.DELETE %>">
													<a href="#deleteStoreManageModal" data-toggle='modal' class="tooltip-error deleteStoreManageLink" data-rel="tooltip" title="Delete">
														<span class="red">
															【删除】
															<!-- <i class="icon-trash bigger-120"></i> -->
														</span>
													</a>
												</gyzbadmin:function>  --%>
												<gyzbadmin:function url="<%=StoreManagePath.BASE + StoreManagePath.ADD %>">
													<a href="#addStoreManageModalS"  class="tooltip-success addStoreManageLink" data-toggle='modal'  data-rel="tooltip" title="Add">
														<span class="blue">
															【添加】
															<!-- <i class="icon-trash bigger-120"></i> -->
														</span>
													</a>
												</gyzbadmin:function>
											</td>
										</tr>
									</c:forEach>
										<c:if test="${empty storeManageInfoList}">
											<tr><td colspan="15" align="center"><font style="color: red; font-weight: bold;font-size: 15px;">暂无数据</font></td></tr>
										</c:if>
									</tbody>
								</table>			
						</div>
						<!-- 分页 -->
						<c:if test="${not empty storeManageInfoList}">
							<%@ include file="/include/page.jsp"%>
						</c:if>
						</div>
					</div>
				</div><!-- /.page-content -->
				<!-- 底部-->
				<%@ include file="/include/bottom.jsp"%>
			</div><!-- /.main-content -->
			<!-- 设置 -->
			<%@ include file="/include/setting.jsp"%>
		</div><!-- /.main-container-inner -->
		<!-- 向上置顶 -->
		<%@ include file="/include/up.jsp"%>
	</div><!-- /.main-container -->	
	
	
	
	<!-- 添加商户新门店配置 -->  
	<div class="modal fade" id="addStoreManageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		            <h4 class="modal-title" id="myModalLabel">添加门店</h4>
		         </div>
		          <div class="modal-body">
		            <table class="modal-input-table">
						<tr>	
							<td class="td-left" width="30%">商户<span style="color:red">*</span></td>
							<td class="td-right" width="70%">	
								<select id="merchantCodeAdd" name="merchantCode">
									<option value="">输入商户名查询</option>
									<c:forEach items="${merchantList }" var="bean">
										<option value="${bean.custId }">${bean.custName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店编号<span style="color:red">*</span></td>
							<td class="td-right">
								<input onkeyup="value=value.replace(/[^\d|^\w.//]/ig,'')" type="text" id="shopNo" name="shopNo" clasS="width-90">
								<label id="shopNoLabel" class="label-tips"></label>
							</td>
						</tr>	
						<tr>
							<td class="td-left">门店名称<span style="color:red">*</span></td>
							<td class="td-right">
								<textarea name="shopName"  id="shopName"  rows="1" clasS="width-90"></textarea>  
								<label id="shopNameLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店地址<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="addr" name="addr" clasS="width-90" >
								<label id="addrLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店联系方式<span style="color:red">*</span></td>
							<td class="td-right">
								<textarea name="contact" id="contact" rows="1" clasS="width-90"></textarea>  
								<label id="contactLabel" class="label-tips"></label>
							</td>
						</tr>
					
						<tr>
							<td class="td-left">状态<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="status" value="1" checked="checked" />可用 
								<input type="radio" name="status" value="0" />不可用
								<label id="statusLabel" class="label-tips"></label>
							</td>
						</tr>
		            </table>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            <button type="button" class="btn btn-primary addStoreManageBtn">提交</button>
		         </div>
		      </div><!-- /.modal-content -->
		     </div>
		</div><!-- /.modal -->
	
	<!-- 修改门店配置 -->  
	<div class="modal fade" id="updateStoreManageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content" style="width: 600px;">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		            <h4 class="modal-title" id="myModalLabel">修改门店资料</h4>
		         </div>
		          <div class="modal-body">
		          	 <input type="hidden" id="mchId" name="mchId">
		         	<form action='<%=StoreManagePath.BASE + StoreManagePath.ADD %>' method="post" id="addadForm"> 
		            <table class="modal-input-table" style="width: 100%;">
		            	
						<tr>	
							<td class="td-left" width="30%">商户<span style="color:red">*</span></td>
							<td class="td-right" width="70%">
								<input type="text" id="custName" name="custName"  clasS="width-90" readonly>
								<label id="custNameLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr style="display:none">
							<td class="td-left"> <span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="shopId" name="shopId"  clasS="width-90">
								<label id="shopNoLabel" class="label-tips"></label>
							</td>
						</tr>	
						<tr>
							<td class="td-left">门店编号<span style="color:red">*</span></td>
							<td class="td-right">
								<input onkeyup="value=value.replace(/[^\d|^\w.//]/ig,'')" type="text" id="shopNo" name="shopNo"  clasS="width-90">
								<label id="shopNoLabel" class="label-tips"></label>
							</td>
						</tr>						
						<tr>
							<td class="td-left">门店名称<span style="color:red">*</span></td>
							<td class="td-right">
								<textarea name="shopName"  id="shopName"  rows="1" clasS="width-90"></textarea>  
								<label id="shopNameLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店地址<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="addr" name="addr" clasS="width-90" >
								<label id="addrLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店联系方式<span style="color:red">*</span></td>
							<td class="td-right">
								<textarea name="contact" id="contact" rows="1" clasS="width-90"></textarea>  
								<label id="contactLabel" class="label-tips"></label>
							</td>
						</tr>					
						<tr>
							<td class="td-left">状态<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="status" value="1"  />可用 
								<input type="radio" name="status" value="0" />不可用
								<label id="statusLabel" class="label-tips"></label>
							</td>
						</tr>
		            </table>
		            </form>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            <button type="button" class="btn btn-primary updateStoreManageBtn">提交</button>
		         </div>
		      </div><!-- /.modal-content -->
		     </div>
		</div><!-- /.modal -->	
		
	<!-- 添加门店配置 -->  
	<div class="modal fade" id="addStoreManageModalS" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content" style="width: 600px;">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		            <h4 class="modal-title" id="myModalLabel">添加门店资料</h4>
		         </div>
		          <div class="modal-body">
		          	 <input type="hidden" id="mchId" name="mchId"/>
		         	<form action='<%=StoreManagePath.BASE + StoreManagePath.ADD %>' method="post" id="addadForm"> 
		            <table class="modal-input-table" style="width: 100%;">
		            	
						<tr>	
							<td class="td-left" width="30%">商户<span style="color:red">*</span></td>
							<td class="td-right" width="70%">
								<input type="text" id="custName" name="custName"  clasS="width-90" readonly>
								<label id="custNameLabel" class="label-tips"></label>
							</td>
						</tr>
							
						<tr>
							<td class="td-left">门店编号<span style="color:red">*</span></td>
							<td class="td-right">
								<input onkeyup="value=value.replace(/[^\d|^\w.//]/ig,'')" type="text" id="shopNo" name="shopNo"  clasS="width-90">
								<label id="shopNoLabel" class="label-tips"></label>
							</td>
						</tr>						
						<tr>
							<td class="td-left">门店名称<span style="color:red">*</span></td>
							<td class="td-right">
								<textarea name="shopName"  id="shopName"  rows="1" clasS="width-90"></textarea>  
								<label id="shopNameLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店地址<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="addr" name="addr" clasS="width-90" >
								<label id="addrLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">门店联系方式<span style="color:red">*</span></td>
							<td class="td-right">
								<textarea name="contact" id="contact" rows="1" clasS="width-90"></textarea>  
								<label id="contactLabel" class="label-tips"></label>
							</td>
						</tr>					
						<tr>
							<td class="td-left">状态<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="status" value="1" checked="checked" />可用 
								<input type="radio" name="status" value="0" />不可用
								<label id="statusLabel" class="label-tips"></label>
							</td>
						</tr>
		            </table>
		            </form>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            <button type="button" class="btn btn-primary addStoreManageBtns">提交</button>
		         </div>
		      </div><!-- /.modal-content -->
		     </div>
		</div><!-- /.modal -->		
	 	
	<!-- 删除门店配置 -->
	<!-- <div class="modal fade" id="deleteStoreManageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content" style="width: 600px;">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times;</button>
		            <h4 class="modal-title" id="myModalLabel">删除门店配置</h4>
		         </div>
		         <div class="modal-body" align="center">
		         	<font style="color: red; font-weight: bold; font-size: 15px;">您确定要删除该商户此门店?</font>
		         </div>
		         <div class="modal-footer">
		         	<input type="hidden" name="shopId" id="shopId">
		            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		            <button type="button" class="btn btn-primary deleteStoreManageBtn">确定</button>
		         </div>
		      </div>/.modal-content
		     </div>
		</div>/.modal 
	-->	 
		
</body>
</html>