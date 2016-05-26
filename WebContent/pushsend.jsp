<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Push send</title>

</head>
<body>
	<form action="PushServlet">
		<input name="sessionId" value="${sessionId}" style="width:500px;"/><br />
		<input name="pushmsg" value="${pushmsg}" style="width:500px;"/><br />
		<input type="submit" value="send"/>
	</form>
</body>
</html>