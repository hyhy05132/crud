<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/post/update" method="post">
<input type="text" value="${post.title }" name="title" placeholder="title"/><br/>
<textarea rows="5" cols="20" name="content">
${post.content}<br/>
</textarea><br/>

<input type="submit" value="전송"/>
</form>


</body>
</html>