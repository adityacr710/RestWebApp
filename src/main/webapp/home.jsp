<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <form action="addStud">
        <input type="text" name="sid"></input><br>
        <input type="text" name="sname"></input>
        <input type="submit">
    </form>

    <form action="getStud" method="get">
        <input type="text" name="sid"></input><br>
        <input type="submit">
    </form>
</body>
</html>