<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人所得税计算结果</title>
</head>
<body>
<h1>个人所得税计算结果</h1>
<p>月收入为 ${param.monthlyIncome} 元时，个人所得税为 ${requestScope.tax} 元</p>
<br>
<a href="index.jsp">返回</a>
</body>
</html>
