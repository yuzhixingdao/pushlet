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
   //��pushlet�ĳ�ʼ��������web.xml�е�servlet��
   PL.uniqueId = '<%=sessionId %>';//�Զ���Ψһ��ʶ����Ҫ���޸ģ�ajax-pushlet-client.js�����룬�޸�������48��224��
   PL._init();
   //����ļ��������⣬������sources.properties�����õĶ���������������⡣
   //sources.properties�������¼�Դ��EventSources�����ڷ���������ʱ���Զ����
   //����ͨ����������������¼�鿴�õ������Խ�����ļ��ŵ�WEB-INFĿ¼�������classessĿ¼���涼���ԡ�
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
	<div id="msg">��������Ϣ</div>
	<div>http://127.0.0.1:8281/pushlet/PushServlet?sessionId=<%=sessionId %></div>
</body>
</html>