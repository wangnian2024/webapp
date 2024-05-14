<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人所得税计算器</title>
</head>
<body>
<h1>个人所得税计算器</h1>
<form action="incomeTaxCalculatorServlet" method="post">
    月收入：<input type="text" name="monthlyIncome"><br>
    子女个数：<input type="text" name="children"><br>
    <input type="submit" value="计算个人所得税">
</form>
</body>
</html>