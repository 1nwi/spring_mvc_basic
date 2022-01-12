<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <h3>
        # 이름: ${b.name}  <br>
        # 키: ${b.height} <br>
        # 몸무게: ${b.weight} <br>
        # BMI 수치 : ${b.weight / (b.height * b.height)}
    </h3>


</body>
</html>