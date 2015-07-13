<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="/test/helloworld.do" method="post">

    请输入姓名：<input type="text" name="userName"/>

    <input type="submit" value="提交"/>

    <br/>

</form>

<form action="/test/helloname.do" method="post">

    请输入姓名：<input type="text" name="userName"/>

    <input type="submit" value="提交"/>

    <br/>
    <a href="notify.jsp">通知页面</a>
    <br/>
    //TODO 支持修改平台账户余额，用户余额等。
</form>
</body>
</html>