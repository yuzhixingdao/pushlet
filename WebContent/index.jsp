<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%
	String sessionId = request.getSession().getId();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>

<script type="text/javascript" src="ajax-pushlet-client.js"></script>

<script type="text/javascript"> 
   //对pushlet的初始化，触发web.xml中的servlet。
   PL.uniqueId = '<%=sessionId %>';//自定义唯一标识，需要再修改（ajax-pushlet-client.js）代码，修改行数（48、224）
   PL._init();
   //这里的监听的主题，必须在sources.properties中配置的对象中声明这个主题。
   //sources.properties配置着事件源（EventSources），在服务器启动时会自动激活。
   //可以通过服务器的启动记录查看得到。可以将这个文件放到WEB-INF目录下面或者classess目录下面都可以。
   PL.joinListen('/hello');
   function onData(event) {
	   var msg = event.get("msg");
	   if (msg != undefined && msg != null) {
		   document.getElementById("msg").innerHTML = msg;
		   console.log(msg);
	   }
   }
   
</script>

</head>
<body>
	<div id="msg">待接收信息</div>
	<div>http://127.0.0.1:8281/pushlet/PushServlet?sessionId=<%=sessionId %></div>
</body>
</html>