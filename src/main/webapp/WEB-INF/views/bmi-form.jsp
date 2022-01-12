<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>

        .reg {
            border: 1px solid gray;
            margin : 20px auto;
            padding: 15px;
            width: 40%;
        }

    </style>
</head>
<body>

    <div class="reg">
        <form action="/bmi/info" method="POST">
            # 이름: <input type="text" name="name"> <br>
            # 키(cm): <input type="text" name="height"> <br>
            # 몸무게(kg): <input type="text" name="weight"> <br>

            <button type="submit">제출</button>
        </form>
    </div>

</body>
</html>