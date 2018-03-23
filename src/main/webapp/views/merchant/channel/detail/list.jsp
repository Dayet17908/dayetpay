<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/template.jsp"%>
<%@page import="com.sevenpay.bms.merchant.channel.controller.ChannelDetailPath" %> 

<html>
<head>
	<meta charset="utf-8" />
	<title>商户详情管理</title>
	<meta name="keywords" content="七分钱后台管理系统" />
	<meta name="description" content="七分钱后台管理" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<style type="text/css">
		table tr td{word-wrap:break-word;word-break:break-all;}
		.uploadImage{ float:left; 
			background:url(<%=request.getContextPath() %>/static/images/upload.jpg);
			background-size:120px 100px;
			width:120px;
			height:100px;
			margin: 10 10 10 10;
			}
	</style>
	<link rel="stylesheet" href="<c:url value='/static/css/combo.select.css' />" />
</head>
<%-- <script src='<c:url value="/static/My97DatePicker/WdatePicker.js"/>'></script> --%>
<script src='<c:url value="/static/js/jquery-ui.min.js"/>'></script>
<script src="<c:url value='/static/js/jquery.combo.select.js'/>"></script>
<script type="text/javascript">
$(function(){
	var channelLists = ${channelList};
	var channelList = $("tr.channel");
	$.each(channelLists,function(i,value){
		$.data(channelList[i],"channel",value);
	});
	//清除查询条件
	$(".clearChannelManage").click(function(){
		$('.search-table #status').val("");
		$('.search-table #merNo').val("");
		$('.search-table #payType').val("");
		$('.search-table #subPayType').val("");
	});
	//新增商户详情信息提交按钮
	$(".addBtn").click(function(){
	
		var merNo=$("#addChannelModal").find("#merNo").val();
		if(kong.test(merNo)){
			$.gyzbadmin.alertFailure("商户号不可为空");
			return;
		}
		var merCustId=$("#addChannelModal").find("#merCustId").val();
		if(kong.test(merCustId)){
			$.gyzbadmin.alertFailure("客户ID不可为空");
			return;
		}
		var payType=$("#addChannelModal").find("#payType").val();
		if(kong.test(payType)){
			$.gyzbadmin.alertFailure("请选择支付类型");
			return;
		}
		var subPayType=$("#addChannelModal").find("#subPayType").val();
		if(kong.test(subPayType)){
			$.gyzbadmin.alertFailure("产品类型不可为空");
			return;
		}
		var merKey=$("#addChannelModal").find("#merKey").val();
		if(kong.test(merKey)){
			$.gyzbadmin.alertFailure("商户key不可为空");
			return;
		}
		
		$.post(window.Constants.ContextPath +"<%=ChannelDetailPath.BASE + ChannelDetailPath.ADD %>",
			{
				'merNo':merNo,
				'merCustId':merCustId,
				'payType':payType,
				'subPayType':subPayType,
				'merKey':merKey,
			},
			function(data){
				$.unblockUI();
				if(data.result=="SUCCESS"){

					$.gyzbadmin.alertSuccess("新增成功！",function(){
						$("#addChannelModal").modal("hide");
					},function(){
						window.location.reload();
					});	
				}else{
						$.gyzbadmin.alertFailure("新增失败！已存在相同的商户信息",function(){
							$("#addChannelModal").modal("hide");
					});
				}
			},'json'
		);
	});

	//编辑商户详情回显信息
	$(".updateChannelLink").click(function(){
		 var channel = $.data($(this).parent().parent()[0],"channel");
	       $('#updateChannelModal').on('show.bs.modal', function () {
	    	    $("#updateChannelModal #merNo").val(channel.merNo);
	    	    $("#updateChannelModal #status").val(channel.status);
				$("#updateChannelModal #payType").val(channel.payType);
				$("#updateChannelModal #subPayType").val(channel.subPayType);
				$("#updateChannelModal #merKey").val(channel.merKey);
				$("#updateChannelModal #merCustId").val(channel.merCustId);
				$("#updateChannelModal #oldMerNo").val(channel.merNo);
				$("#updateChannelModal #oldPayType").val(channel.payType);
				$("#updateChannelModal #oldSubPayType").val(channel.subPayType);
			
	       });
		  $('#updateChannelModal').on('hide.bs.modal', function () {
			    $("#updateChannelModal #merNo").val('');
			    $("#updateChannelModal #status").val('');
				$("#updateChannelModal #payType").val('');
				$("#updateChannelModal #subPayType").val('');
				$("#updateChannelModal #merKey").val('');
				$("#updateChannelModal #merCustId").val('');	
				$("#updateChannelModal #oldMerNo").val('');
				$("#updateChannelModal #oldPayType").val('');
				$("#updateChannelModal #oldSubPayType").val('');
	       });
	});
	
	//商户详情编辑提交更新
	$(".updateBtn").click(function(){
		
		var merNo=$("#updateChannelModal").find("#merNo").val();
		
		if(kong.test(merNo)){
			$.gyzbadmin.alertFailure("商户号不可为空");
			return;
		}
		var merCustId=$("#updateChannelModal").find("#merCustId").val();
		if(kong.test(merCustId)){
			$.gyzbadmin.alertFailure("商户号不可为空");
			return;
		}
		var payType=$("#updateChannelModal").find("#payType").val();
		if(kong.test(payType)){
			$.gyzbadmin.alertFailure("请选择支付方式");
			return;
		}
		var subPayType=$("#updateChannelModal").find("#subPayType").val();
		if(kong.test(subPayType)){
			$.gyzbadmin.alertFailure("支付类型不可为空");
			return;
		}
		var merKey=$("#updateChannelModal").find("#merKey").val();
		if(kong.test(merKey)){
			$.gyzbadmin.alertFailure("商户Key不可为空");
			return;
		}
		var status=$("#updateChannelModal").find("#status").val();
		var oldMerNo=$("#updateChannelModal").find("#oldMerNo").val();
		var oldPayType=$("#updateChannelModal").find("#oldPayType").val();
		var oldSubPayType=$("#updateChannelModal").find("#oldSubPayType").val();
	
		$.post(window.Constants.ContextPath +"<%=ChannelDetailPath.BASE + ChannelDetailPath.UPDATE %>",
				{
					'merCustId':merCustId,
					'merNo':merNo,
					'payType':payType,
					'subPayType':subPayType,
					'merKey':merKey,
					'status':status,
					'oldMerNo':oldMerNo,
					'oldPayType':oldPayType,
					'oldSubPayType':oldSubPayType
				},
				function(data){
					$.unblockUI();
					if(data.result=="SUCCESS"){

						$.gyzbadmin.alertSuccess("修改成功！",function(){
							$("#updateCardModal").modal("hide");
						},function(){
							window.location.reload();
						});		
					}else{
							$.gyzbadmin.alertFailure("修改失败！已存在相同的商户详情信息",function(){
								$("#updateCardModal").modal("hide");
							});
					}
				},'json'
				);
		
	});
	//删除确认提示框
	$(".deleteChannelLink").click(function(){
		var channel = $.data($(this).parent().parent()[0],"channel");		
		$("#deleteChannelModal").find("input[name='merNo']").val(channel.merNo);
		$("#deleteChannelModal").find("input[name='payType']").val(channel.payType);
		$("#deleteChannelModal").find("input[name='subPayType']").val(channel.subPayType);
		$("span.sureDel").text(channel.merNo);		
	});
	
	//确认删除
	$(".deleteChannelBtn").click(function(){
		var merNo= $("#deleteChannelModal #merNo").val();
		var payType= $("#deleteChannelModal #payType").val();
		var subPayType= $("#deleteChannelModal #subPayType").val();
		$.blockUI();
		$.ajax({
			type:"POST",
			dataType:"json",
			url:window.Constants.ContextPath +'<%=ChannelDetailPath.BASE + ChannelDetailPath.DELETE %>',
			data:{
				'merNo':merNo,
				'payType':payType,
				'subPayType':subPayType
			},
			success:function(data){
				$.unblockUI();			
				if(data.result=='SUCCESS'){
					$.gyzbadmin.alertSuccess("删除成功！",function(){
						$("#deleteChannelModal").modal("hide");
					},function(){
						window.location.reload();
					});
				}else{
					$.gyzbadmin.alertFailure("删除失败！"+data.message);
				}
			}
		});
	});
});
function onLoadStatus(){
	$('.search-table #status').val($("#searchStatus").val());
	$('.search-table #payType').val($("#searchPayType").val());
	
}
</script>
<body onload="onLoadStatus()">
	<!-- APP登录页广告管理-->
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
							<form action='<c:url value="<%=ChannelDetailPath.BASE + ChannelDetailPath.LIST %>"/>' method="post">
							<table class="search-table">
								<input type="hidden" value="${queryBean.status }"  id="searchStatus"/>
								<input type="hidden" value="${queryBean.payType }"  id="searchPayType"/>
								<tr>
									<td class="td-left">商户号</td>
									<td class="td-right">
										<span class="input-icon">
											<input type="text"  name="merNo" value="${queryBean.merNo }" id="merNo">
											<i class="icon-leaf blue"></i>
										</span>
									</td>
									<td class="td-left">产品类型</td>
									<td class="td-right">
										<span class="input-icon">
											<input type="text"  name="subPayType" value="${queryBean.subPayType }" id="subPayType">
											<i class="icon-leaf blue"></i>
										</span>
									</td>
									
								</tr>
								<tr>
									<td class="td-left">支付类型</td>
									<td class="td-right">
										<select id="payType" name="payType"  >
											<option value = "">- 请选择  -</option>
										    <option value = "WEIXIN">微信</option>
										    <option value = "ALIPAY">支付宝</option>  
										
										</select>
									</td>
									<td class="td-left">状态</td>
									<td class="td-right" > 
									<!-- 	<input type="hidden" id="status" name="status" value="${queryBean.status}" > -->
										<select id="status" name="status"  >
											<option value = "">- 请选择  -</option>
										    <option value = "00">- 正常  -</option>
										    <option value = "1">- 不可用 -</option>    
										</select>
									</td>
									
									
								</tr>
								<tr>
									<td colspan="4" align="center">
										<span class="input-group-btn">
											<gyzbadmin:function url="<%=ChannelDetailPath.BASE + ChannelDetailPath.LIST  %>">
											<button type="submit" class="btn btn-purple btn-sm">
												查询
												<i class="icon-search icon-on-right bigger-110"></i>
											</button> 
											</gyzbadmin:function>
											<button  type="button" style="margin-left:10px;margin-right:10px;"class="btn btn-purple btn-sm  clearChannelManage"  >
												清空
												<i class=" icon-move icon-on-right bigger-110"></i>
											</button>
										
											<gyzbadmin:function url="<%=ChannelDetailPath.BASE + ChannelDetailPath.ADD  %>">
											<button  class="btn btn-purple btn-sm" data-toggle='modal' data-target="#addChannelModal">
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
								商户列表
							</div>
							<div class="table-responsive">
								<table id="sample-table-2" class="list-table">
									<thead>
										<tr>
											<th>商户号</th>
											<th>客户ID</th>							
											<th>支付类型</th>
											<th>产品类型</th>
											<th>状态</th>
											<th>创建时间</th>
											<th>修改时间</th>
											<th>商户key</th>
											<th>保留字段</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${channelList}" var="channel">
											
											<tr class="channel">
												<td>${channel.merNo}</td>
												<td>${channel.merCustId}</td>
												<td>
													<c:if test="${channel.payType=='ALIPAY'}">支付宝</c:if>
													<c:if test="${channel.payType=='WEIXIN'}">微信</c:if>									
												</td>
												
												<td>
													<c:if test="${channel.subPayType=='SK'}">刷卡</c:if>
													<c:if test="${channel.subPayType=='SM'}">现金</c:if>
													<c:if test="${channel.subPayType=='GZH'}">公众号</c:if>
													<c:if test="${channel.subPayType=='H5'}">H5</c:if>
												</td>
												<td>
													<c:if test="${channel.status=='00'}">正常</c:if>
													<c:if test="${channel.status=='1'}">不可用</c:if>
												</td>	
												<td><fmt:formatDate value="${channel.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>	
												<td><fmt:formatDate value="${channel.modifyTime }" pattern="yyyy-MM-dd HH:mm"/></td>		
												<td>${channel.merKey }</td>
												<td>
													<c:if test="${channel.reserved=='D'}">直清</c:if>
													<c:if test="${channel.reserved=='G'}">挂号</c:if>
												</td>								
												<td>
													<gyzbadmin:function url="<%=ChannelDetailPath.BASE + ChannelDetailPath.UPDATE %>">
														<a href="#updateChannelModal"  data-toggle='modal' class="tooltip-success updateChannelLink"  data-rel="tooltip" title="Edit">
															<span class="green">
																<i class="icon-edit bigger-120"></i>
															</span>
														</a>
													</gyzbadmin:function>
													<gyzbadmin:function url="<%=ChannelDetailPath.BASE + ChannelDetailPath.DELETE %>">
														<a href="#deleteChannelModal" data-toggle='modal' class="tooltip-error deleteChannelLink" data-rel="tooltip" title="Delete">
															<span class="red">
																<i class="icon-trash bigger-120"></i>
															</span>
														</a>
													</gyzbadmin:function>
												</td>
											</tr>
										</c:forEach>
										<c:if test="${empty channelList}">
											<tr><td colspan="15" align="center"><font style="color: red; font-weight: bold;font-size: 15px;">暂无数据</font></td></tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<!-- 分页 -->
							<c:if test="${not empty channelList}">
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

	<!-- 新增商户详情 -->
	<div class="modal fade" id="addChannelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog" style="width:40%">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h4 class="modal-title" id="myModalLabel">新增商户详情</h4>
	         </div>
	         <div class="modal-body">
	         	<form action='<%=ChannelDetailPath.BASE + ChannelDetailPath.ADD %>' method="post" id="addChannelForm">
	            <table class="modal-input-table" style="width: 100%;">
					<tr>	
						<td class="td-left" width="20%">商户号<span style="color:red">*</span></td>
						<td class="td-right" width="80%">
							<input type="text" id="merNo" name="merNo" style="width:80%">
						</td>
					</tr>
					<tr>	
						<td class="td-left" width="20%">客户ID<span style="color:red">*</span></td>
						<td class="td-right" width="80%">
							<input type="text" id="merCustId" name="merCustId" style="width:80%">
						</td>
					</tr>
					<tr>
						<td class="td-left" width="20%">支付类型<span style="color:red">*</span></td>
						<td class="td-right" width="80%">							
						    <select name="payType" id="payType" width="100%" >
						  		<option value="">-请选择-</option>
								<option value="WEIXIN">微信</option>
								<option value="ALIPAY">支付宝</option>			
							</select>
						</td>
					</tr>
					<tr>
						<td class="td-left">产品类型<span style="color:red">*</span></td>
						<td class="td-right" width="40%">
							<input type="text" id="subPayType" name="subPayType" style="width:80%">
						</td>
					</tr>
					<tr>
							<td class="td-left" width="20%">商户key<span style="color:red">*</span></td>
							<td class="td-right" width="80%">
								<input type="text" id="merKey" name="merKey"  style="width:80%"	>
							</td>
					</tr>
	            </table>
	            </form>
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            <button type="button" class="btn btn-primary addBtn">提交</button>
	         </div>
	      </div><!-- /.modal-content -->
	     </div>
	</div><!-- /.modal -->
	<!-- 修改广告信息 -->  
	<div class="modal fade" id="updateChannelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog" style="width:40%">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h4 class="modal-title" id="myModalLabel">编辑广告</h4>
	         </div>
	         <div class="modal-body">
	         	
	            <table class="modal-input-table" style="width: 100%;">
	          
	            	<input type="hidden" id="oldMerNo"" name="oldMerNo"" >
	            	<input type="hidden" id="oldPayType" name="oldPayType" >
	            	<input type="hidden" id="oldSubPayType" name="oldSubPayType" >
					<tr>	
						<td class="td-left" width="20%">商户号<span style="color:red">*</span></td>
						<td class="td-right" width="80%">
							<input type="text" id="merNo" name="merNo" style="width:80%">
						</td>
					</tr>
					<tr>	
						<td class="td-left" width="20%">客户ID<span style="color:red">*</span></td>
						<td class="td-right" width="80%">
							<input type="text" id="merCustId" name="merCustId" style="width:80%">
						</td>
					</tr>
					<tr>
						<td class="td-left" width="20%">支付类型<span style="color:red">*</span></td>
						<td class="td-right" width="80%">							
						    <select name="payType" id="payType" width="100%" >
						  		<option style=" value="">-请选择-</option>
								<option value="WEIXIN">微信</option>
								<option value="ALIPAY">支付宝</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td-left">产品类型<span style="color:red">*</span></td>
						<td class="td-right" width="40%">
							<input type="text" id="subPayType" name="subPayType" style="width:80%">
						</td>
					</tr>
					<tr>
							<td class="td-left" width="20%">商户key<span style="color:red">*</span></td>
							<td class="td-right" width="80%">
								<input type="text" id="merKey" name="merKey"  style="width:80%"	>
							</td>
					</tr>
						<td class="td-left" width="20%">状态<span style="color:red">*</span></td>
						<td class="td-right" width="80%">
							<select name="status" id="status" >
								<option value="00">正常</option>
								<option value="1">不可用</option> 
							</select>
						</td>
					</tr>
	            </table>
	          
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            <button type="button" class="btn btn-primary updateBtn">提交</button>
	         </div>
	      </div><!-- /.modal-content -->
	     </div>
	</div><!-- /.modal -->

	<!-- 删除确认 -->
	<div class="modal fade" id="deleteChannelModal" style="margin-top:150px;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content" style="width: 600px;">
	         <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times;</button>
	            <h4 class="modal-title" id="myModalLabel">删除商户详情</h4>
	         </div>
	         <div class="modal-body" align="center">
	         	<font style="font-weight: bold; font-size: 15px;">您确定要删除商户号为<span style="color:red;" class="sureDel"></span>的商户详情吗？</font>
	         </div>
	         <div class="modal-footer">
	         	<input type="hidden" name="merNo" id="merNo">
	         	<input type="hidden" name="payType" id="payType">
	         	<input type="hidden" name="subPayType" id="subPayType">
	            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	            <button type="button" class="btn btn-primary deleteChannelBtn">确定</button>
	         </div>
	      </div><!-- /.modal-content -->
	     </div>
	</div><!-- /.modal -->
	
	
</body>
</html>

