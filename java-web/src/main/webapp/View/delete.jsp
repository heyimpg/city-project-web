

<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/10/2021
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
    <title>Document</title>
    <link rel="stylesheet" href="/Asset/css/delete-css.css">
</head>
<body>



<div class="bg">
    <head>
        <!-- Tiêu đề -->
        <h2 class="title-city">Xóa thành phố</h2>
        <!-- navigation -->
    </head>
    <!-- phần chứa bảng -->


    <div class="container-fluid">
        <div class="field-input">
            <form method="post">
                <div>
                    <h4 style="text-align: inherit;"> Bạn có chắc muốn xóa thành phố ${requestScope["delete-city"].getName()} ?</h4>
                </div>
                <center>
                    <div>
                        <button type="submit" class="btn btn-danger">Xóa</button>
                        <button class="btn btn-default"><a href="/cities">Thoát</a></button>
                    </div>
                </center>
            </form>
        </div>

    </div>

    <!-- <div class="overlay">
    </div> -->
</div>
</body>
</html>
