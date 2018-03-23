<%@page import="com.sevenpay.bms.merchant.channel.controller.AgentMerControllerPath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/template.jsp"%>
<html>
<head>
	<meta charset="utf-8" />
	<title>商户网关维护</title>
	<meta name="keywords" content="七分钱后台管理系统" />
	<meta name="description" content="七分钱后台管理" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<style type="text/css">
		table tr td{word-wrap:break-word;word-break:break-all;}
	</style>
	<link rel="stylesheet" href="<c:url value='/static/css/combo.select.css' />" />
</head>
<%-- <script src='<c:url value="/static/My97DatePicker/WdatePicker.js"/>'></script> --%>
<script src='<c:url value="/static/js/jquery-ui.min.js"/>'></script>
<script src="<c:url value='/static/js/jquery.combo.select.js'/>"></script>
<script type="text/javascript">
$(document).ready(function(){
	//获取数据
	var agentMerInfoLists = ${allAgentMerInfolist};
	var agentMerInfoList = $("tr.result");
	
	$.each(agentMerInfoLists,function(i,value){
		$.data(agentMerInfoList[i],"result",value);
	});
	//清空搜索栏
		$('.clearAgentMerInfoControClr').click(function(){			
		$(".page-content #channelCode").val("");
		$(".page-content #merCustId").val("");
		$(".page-content #merNo").val("");
	}) 
	// 添加 
	$(".addMerchantBtn").click(function(){
		var merCustId = $("#addMerchantModal #merCustId").val();
		var channelCode = $("#addMerchantModal #channelCode").val();
		var merNo = $("#addMerchantModal #merNo").val();
		var appIdKey = $("#addMerchantModal #appIdKey").val();
		var status = $("#addMerchantModal input[name='status']:checked").val();
		var publicStatus = $("#addMerchantModal input[name='publicStatus']:checked").val();
		var reserved = $("#addMerchantModal #reserved").val();
		var appId = $("#addMerchantModal #appId").val();
		
		if(kong.test(channelCode)) {
			$.gyzbadmin.alertFailure("通道号不可为空");
			$("#addMerchantModal #channelCode").focus();
			return;
		}
		
		if(kong.test(merCustId)) {
			$.gyzbadmin.alertFailure("商户ID不可为空");
			$("#addMerchantModal #merCustId").focus();
			return;
		}

		if(kong.test(merNo)) {
			$.gyzbadmin.alertFailure("商户号不可为空");
			$("#addMerchantModal #merNo").focus();
			return;
		}

		if(kong.test(appId)) {
			$.gyzbadmin.alertFailure("APPID不可为空");
			$("#addMerchantModal #appId").focus();
			return;
		}
		
		if(kong.test(appIdKey)) {
			$.gyzbadmin.alertFailure("appIdKey不可为空");
			$("#addMerchantModal #appIdKey").focus();
			return;
		}
		
		var comment = $("#addMerchantModal #comment").val();
		$.blockUI();
		 $.ajax({
			type:"POST",
			dataType:"json",
			url:window.Constants.ContextPath +'<%=AgentMerControllerPath.BASE + AgentMerControllerPath.ADD %>',
			data:
			{
				"channelCode" 	: channelCode,
				"merCustId" 	: merCustId,
				"merNo" 		: merNo,
				"appId" 		: appId,
				"appIdKey"		: appIdKey,
				"status" 		: status,
				"publicStatus" 	: publicStatus,
				"reserved"		: reserved
			},
			success:function(data){
				$.unblockUI();
				if(data.result=="success"){
					$.gyzbadmin.alertSuccess("添加成功！",function(){
						$("#addMerchantModal").modal("hide");
					},function(){
						window.location.reload();
					});
				}else{
					$.gyzbadmin.alertFailure("添加失败！"+data.message);
				}
			}
		});
	});
	
	$(".deleteAgentMerInfoLink").click(function(){
		
		var result = $.data($(this).parent().parent()[0],"result");	
		$("#deleteAgentMerInfoModal").find("input[name='channelCode']").val(result.channelCode);
		$("#deleteAgentMerInfoModal").find("input[name='merCustId']").val(result.merCustId);
		$("#deleteAgentMerInfoModal").find("input[name='merNo']").val(result.merNo);
		$("span.dchannelCode").text(result.channelCode+"-");
		$("span.dmerCustId").text(result.merCustId+"-");
		$("span.dmerNo").text(result.merNo);
	});
	
	$(".deleteAgentMerInfoBtn").click(function(){

		var channelCode= $("#deleteAgentMerInfoModal #channelCode").val();
		var merCustId= $("#deleteAgentMerInfoModal #merCustId").val();
		var merNo= $("#deleteAgentMerInfoModal #merNo").val();
		$.blockUI();
		$.ajax({
			type:"POST",
			dataType:"json",
			url:window.Constants.ContextPath +'<%=AgentMerControllerPath.BASE + AgentMerControllerPath.DELETE %>',
			data:{
				'channelCode':channelCode,
				'merCustId':merCustId,
				'merNo':merNo
			},
			success:function(data){
				$.unblockUI();
				
				if(data.result=='success'){
					
					$.gyzbadmin.alertSuccess("删除成功！",function(){
						$("#deleteAgentMerInfoModal").modal("hide");
					},function(){
						window.location.reload();
					});
				}else{
					$.gyzbadmin.alertFailure("删除失败！"+data.message);
				}
			}
		});
	});
	//更新操作
	$(".updateAgentMerInfoLink").click(function(){
		 var result = $.data($(this).parent().parent()[0],"result");
		 var ststus = result.status;
		 var publicStatus = result.publicStatus;
		 //为弹出框赋值,数据回显。
		 $('#updateAgentMerInfoModal').on('show.bs.modal', function () {
			 	
			    $("#updateAgentMerInfoModal #channelCode").val(result.channelCode);
				$("#updateAgentMerInfoModal #merCustId").val(result.merCustId);
				$("#updateAgentMerInfoModal #merNo").val(result.merNo);
				$("#updateAgentMerInfoModal #appId").val(result.appId);
				$("#updateAgentMerInfoModal #appIdKey").val(result.appIdKey);
				$("#updateAgentMerInfoModal #reserved").val(result.reserved);
				$("#updateAgentMerInfoModal #createTime").val(result.createTime);
				
				 if(ststus == '00'){
					$("#updateAgentMerInfoModal input[name='status'][value='00']").attr("checked",true);
				 }else{
					$("#updateAgentMerInfoModal input[name='status'][value='01']").attr("checked",true);
				 }
				 if(publicStatus == '00'){
					$("#updateAgentMerInfoModal input[name='publicStatus'][value='00']").attr("checked",true);
				 }else{
					$("#updateAgentMerInfoModal input[name='publicStatus'][value='01']").attr("checked",true);
				 }
		 });
		 
	      $('#updateAgentMerInfoModal').on('hide.bs.modal', function () {
				// 清除
	    	    $("#updateAgentMerInfoModal #channelCode").val("");
				$("#updateAgentMerInfoModal #merCustId").val("");
				$("#updateAgentMerInfoModal #merNo").val("");
				$("#updateAgentMerInfoModal #appId").val("");
				$("#updateAgentMerInfoModal #appIdKey").val("");
				$("#updateAgentMerInfoModal #status input[type='radio']:checked").val("");
				$("#updateAgentMerInfoModal #publicStatus input[type='radio']:checked").val("");
				$("#updateAgentMerInfoModal #createTime").val("");
		  });
	});

	$(".updateAgentMerInfoBtn").click(function(){
		debugger;
		var channelCode = $("#updateAgentMerInfoModal #channelCode").val();
		var merCustId = $("#updateAgentMerInfoModal #merCustId").val();
		var merNo = $("#updateAgentMerInfoModal #merNo").val();
		var appId = $("#updateAgentMerInfoModal #appId").val();
		var appIdKey = $("#updateAgentMerInfoModal #appIdKey").val();
		var status = $("#updateAgentMerInfoModal input[name='status']:checked").val();
		var publicStatus = $("#updateAgentMerInfoModal input[name='publicStatus']:checked").val();
		var reserved = $("#updateAgentMerInfoModal #reserved").val();
		var createTime = $("#updateAgentMerInfoModal #createTime").val();
		if(kong.test(channelCode)) {
			$.gyzbadmin.alertFailure("通道号不可为空");
			$("#addMerchantModal #channelCode").focus();
			return;
		}
		
		if(kong.test(merCustId)) {
			$.gyzbadmin.alertFailure("商户ID不可为空");
			$("#addMerchantModal #merCustId").focus();
			return;
		}

		if(kong.test(merNo)) {
			$.gyzbadmin.alertFailure("商户号不可为空");
			$("#addMerchantModal #merNo").focus();
			return;
		}

		if(kong.test(appId)) {
			$.gyzbadmin.alertFailure("APPID不可为空");
			$("#addMerchantModal #appId").focus();
			return;
		}
		
		if(kong.test(appIdKey)) {
			$.gyzbadmin.alertFailure("appIdKey不可为空");
			$("#addMerchantModal #appIdKey").focus();
			return;
		}
		
		$.blockUI();
		 $.ajax({
			type:"POST",
			dataType:"json",
			url:window.Constants.ContextPath +'<%=AgentMerControllerPath.BASE + AgentMerControllerPath.UPDATE %>',
			data:
			{
				"channelCode"   : channelCode,
				"merCustId"     : merCustId,
				"merNo" 	    : merNo,
				"appId" 	    : appId,
				"appIdKey"	    : appIdKey,
				"status"		: status,
				"publicStatus" 	:publicStatus,
				"reserved" 		:reserved,
				"createTime"	:createTime
			},
			success:function(data){
				$.unblockUI();
				if(data.result=="success"){
					$.gyzbadmin.alertSuccess("修改成功！",function(){
						$("#updateAgentMerInfoModal").modal("hide");
					},function(){
						window.location.reload();
					});
				}else{
					$.gyzbadmin.alertFailure("修改失败！"+data.message);
				}
			}
		});
	});
});
</script>
<body>
	<!-- 商户网关维护-->
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
							<form action='<c:url value="<%=AgentMerControllerPath.BASE + AgentMerControllerPath.LIST %>"/>' method="post">
							<table class="search-table">
								<tr>
									<td class="td-left">通道号</td>
									<td class="td-right">
										<span class="input-icon">
											<input type="text"  name="channelCode" value="${agentMerInfo.channelCode}" id="channelCode">
											<i class="icon-leaf blue"></i>
										</span>
									</td>
									<td class="td-left">商户号</td>
									<td class="td-right">
										<span class="input-icon">
											<input type="text"  name="merNo" value="${agentMerInfo.merNo}" id="merNo">
											<i class="icon-leaf blue"></i>
										</span>
									</td>
									<td class="td-left">商户CUSTID</td>
									<td class="td-right">
										<span class="input-icon">
											<input type="text"  name="merCustId" value="${agentMerInfo.merCustId}" id="merCustId">
											<i class="icon-leaf blue"></i>
										</span>
									</td>
								</tr>
								<tr>
									<td colspan="6" align="center">
										<span class="input-group-btn">
											<gyzbadmin:function url="<%=AgentMerControllerPath.BASE + AgentMerControllerPath.LIST %>">
											<button type="submit" class="btn btn-purple btn-sm">
												查询
												<i class="icon-search icon-on-right bigger-110"></i>
											</button> 
											</gyzbadmin:function>
											<button class="btn btn-purple btn-sm btn-margin clearAgentMerInfoControClr"  >
												清空
												<i class=" icon-move icon-on-right bigger-110"></i>
											</button>
											
											<gyzbadmin:function url="<%=AgentMerControllerPath.BASE + AgentMerControllerPath.ADD %>">
											<button  class="btn btn-purple btn-sm" data-toggle='modal' data-target="#addMerchantModal">
												新增
												<i class="icon-plus-sign icon-on-right bigger-110"></i>
											</button>
											</gyzbadmin:function>
										</span>
									</td>
								</tr>
							</table>
							</form>
							<div class="list-table-header">
								商户网关维护
							</div>
							<div class="table-responsive">
								<table id="sample-table-2" class="list-table">
									<thead>
										<tr>
											<th>通道编号</th>
											<th>商户CUSTID</th>
											<th>商户号</th>
											<th>APPID</th>
											<th>APPID_KEY</th>
											<th>创建时间</th>
											<th>修改时间</th>
											<th>审核状态</th>											
											<th>公用开启</th>
											<th>预留字段</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${allAgentMerInfolist}" var="result">
											<tr class="result">
												<td>${result.channelCode }</td>
												<td>${result.merCustId }</td>
												<td>${result.merNo }</td>
												<td>${result.appId }</td>
												<td>${result.appIdKey }</td>
												<td>${result.createTime }</td>												
												<td>${result.modifyTime }</td>
												<td>
													<c:if test="${result.status == '00'}">可用</c:if>
													<c:if test="${result.status == '01'}">不可用</c:if>
												</td>
												<td>
													<c:if test="${result.publicStatus == '00'}">开启</c:if>
													<c:if test="${result.publicStatus == '01'}">不开启</c:if>
												</td>
												<td>${result.reserved}</td>												
												<td>
													<gyzbadmin:function url="<%=AgentMerControllerPath.BASE + AgentMerControllerPath.UPDATE %>">
														<a href="#updateAgentMerInfoModal"  data-toggle='modal' class="tooltip-success updateAgentMerInfoLink" data-rel="tooltip" title="Edit">
															<span class="green">
																<i class="icon-edit bigger-120"></i>
															</span>
														</a>
													</gyzbadmin:function>
													<gyzbadmin:function url="<%=AgentMerControllerPath.BASE + AgentMerControllerPath.DELETE %>">
														<a href="#deleteAgentMerInfoModal" data-toggle='modal' class="tooltip-error deleteAgentMerInfoLink" data-rel="tooltip" title="Delete">
															<span class="red">
																<i class="icon-trash bigger-120"></i>
															</span>
														</a>
													</gyzbadmin:function>
												</td>
											</tr>
										</c:forEach>
										<c:if test="${empty allAgentMerInfolist}">
											<tr><td colspan="15" align="center"><font style="color: red; font-weight: bold;font-size: 15px;">暂无数据</font></td></tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<!-- 分页 -->
							<c:if test="${not empty allAgentMerInfolist}">
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
	<!-- 添加商户配置 -->  
	<div class="modal fade" id="addMerchantModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		            <h4 class="modal-title" id="myModalLabel">添加商户渠道详情</h4>
		         </div>
		          <div class="modal-body">
		            <table class="modal-input-table">
						<tr>	
							<td class="td-left" width="30%">通道号<span style="color:red">*</span></td>
							<td class="td-right" width="70%">
								<input type="text" id="channelCode" name="channelCode"  clasS="width-90">
								<label id="channelCodeLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">商户CustId<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="merCustId" name="merCustId"  clasS="width-90">
								<label id="merCustIdLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">商户号<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="merNo" name="merNo"  clasS="width-90">
								<label id="merNoLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">APPID<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="appId" name="appId"  clasS="width-90">
								<label id="appIdLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">APPID_KEY<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="appIdKey" name="appIdKey"  clasS="width-90">
								<label id="appIdKeyLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">审核状态<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="status" id="status" value="00" />可用 
								<input type="radio" name="status" id="status" value="01" checked="checked" />不可用
								<label id="statusLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">公用开启<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="publicStatus" id="publicStatus" value="00" />开启 
								<input type="radio" name="publicStatus" id="publicStatus" value="01" checked="checked"/>不开启
								<label id="publicStatusLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">预留字段<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="reserved" name="reserved"  clasS="width-90">
								<label id="reservedLabel" class="label-tips"></label>
							</td>
						</tr>
		            </table>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            <button type="button" class="btn btn-primary addMerchantBtn">提交</button>
		         </div>
		      </div><!-- /.modal-content -->
		     </div>
		</div><!-- /.modal -->
		
	<!-- 修改商户渠道信息 -->  
	<div class="modal fade" id="updateAgentMerInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content" style="width: 600px;">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		            <h4 class="modal-title" id="myModalLabel">修改商户渠道配置</h4>
		         </div>
		          <div class="modal-body">
		          	<input type="hidden" id="custId" name="custId">
		         	<form action='<%=AgentMerControllerPath.BASE + AgentMerControllerPath.UPDATE %>' method="post" id="addadForm">
		            <table class="modal-input-table" style="width: 100%;">
						<tr>	
							<td class="td-left" width="30%">通道号<span style="color:red">*</span></td>
							<td class="td-right" width="70%">
								<input type="text" id="channelCode" name="channelCode"  clasS="width-90">
								<label id="channelCodeLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">商户CustId<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="merCustId" name="merCustId"  clasS="width-90">
								<label id="merCustIdLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">商户号<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="merNo" name="merNo"  clasS="width-90">
								<label id="merNoLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">APPID<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="appId" name="appId"  clasS="width-90">
								<label id="appIdLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">APPID_KEY<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="appIdKey" name="appIdKey"  clasS="width-90">
								<label id="appIdKeyLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">审核状态<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="status" id="status"  value="00" />可用 
								<input type="radio" name="status" id="status" value="01" />不可用
								<label id="statusLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">公用开启<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="radio" name="publicStatus" id="publicStatus" value="00" />开启 
								<input type="radio" name="publicStatus" id="publicStatus" value="01" />不开启
								<label id="publicStatusLabel" class="label-tips"></label>
							</td>
						</tr>
						<tr>
							<td class="td-left">预留字段<span style="color:red">*</span></td>
							<td class="td-right">
								<input type="text" id="reserved" name="reserved"  clasS="width-90">
								<input type="hidden" id="createTime" name="createTime">
								<label id="reservedLabel" class="label-tips"></label>
							</td>
		            </table>
		            </form>
		         </div>
		         <div class="modal-footer">
		            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            <button type="button" class="btn btn-primary updateAgentMerInfoBtn">提交</button>
		         </div>
		      </div><!-- /.modal-content -->
		     </div>
		</div><!-- /.modal -->
		<div class="modal fade" id="deleteAgentMerInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content" style="width: 600px;">
		         <div class="modal-header">
		            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times;</button>
		            <h4 class="modal-title" id="myModalLabel">商户渠道删除</h4>
		         </div>
		         <div class="modal-body" align="center">
		         	<font style="color: red; font-weight: bold; font-size: 15px;">您确定要删除该商户号为[<span class="dchannelCode">-</span>
		         																			      <span class="dmerCustId">-</span>
		         																			      <span class="dmerNo"></span>]的商户信息吗？</font>
		         </div>
		         <div class="modal-footer">
		         	<input type="hidden" name="channelCode" id="channelCode">
		         	<input type="hidden" name="merCustId" id="merCustId">
		         	<input type="hidden" name="merNo" id="merNo">
		            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		            <button type="button" class="btn btn-primary deleteAgentMerInfoBtn">确定</button>
		         </div>
		      </div><!-- /.modal-content -->
		     </div>
		</div><!-- /.modal -->
</body>
</html>

