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
        <form action="/bmi/calc" method="POST">
            # 이름: <input type="text" name="name"> <br>
            # 신장: <input type="text" name="height" placeholder="cm로 입력"> <br>
            # 채중: <input type="text" name="weight" placeholder="kg로 입력"> <br>

            <button type="submit">확인</button>
        </form>
    </div>

</body>
</html>