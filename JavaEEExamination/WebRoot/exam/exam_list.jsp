<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exam_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="${pageContext.request.contextPath }/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/exam-list.css"/>
  </head>
  
  <body>
   <div class="list-div">
			<div class="list-div-head">
				<label class="list-div-head-bar1 checked" onclick="changeBarStyle()">java</label>
				<label class="list-div-head-bar2 unchecked" onclick="changeBarStyle()">javascript</label>
			</div> 
			<div class="list-div-main">
				<table border="1px">
					<tr>
						<th>题目</th>
						<th>答案A</th>
						<th>答案B</th>
						<th>答案C</th>
						<th>答案D</th>
						<th>正确答案</th>
						<th>操作</th>
					</tr>
				</table>
			</div>
		</div>
  </body>
  <script type="text/javascript">
  var paperType = 0;
  $(function(){
	  $.ajax({
		  type:"post",
		  url:"${pageContext.request.contextPath}/paper_getPaperList.action?paperType="+paperType,
		  data:"",
		  success:function(data){
			  alert(data);
		  }
	  });
  });
  function changeBarStyle(){
		var labels = $("label");
		var label_java = labels.eq(0);
		var label_javascript = labels.eq(1);
		var str= label_java.attr("class");
		if(str.indexOf("unchecked") != -1){
			label_java.attr("class","list-div-head-bar1 checked");
			label_javascript.attr("class","list-div-head-bar2 unchecked");
			paperType = 0;
		}else{
			label_java.attr("class","list-div-head-bar1 unchecked");
			label_javascript.attr("class","list-div-head-bar2 checked");
			paperType = 1;
		}
		window.location.reload();
	}
  
  </script>
</html>
