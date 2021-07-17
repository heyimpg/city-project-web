<%@ page import="Model.City" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/14/2021
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--code mới--%>
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
    <link rel="stylesheet" href="/Asset/css/detail-css.css">
</head>
<body>

<% City city = (City) request.getAttribute("detail-city"); %>

<div class="bg">
    <head>
        <!-- Tiêu đề -->
        <h2 class="title-city">Chi tiết thành phố <%=city.getName()%></h2>
        <!-- navigation -->
    </head>
    <!-- phần chứa bảng -->
    <div class="container-fluid">
        <div class="field-input">
            <div>
                <h4 style="text-align: inherit;"> Tên: <span><%=city.getName()%></span> </h4>
            </div>
            <div>
                <h4 style="text-align: inherit;"> Quốc gia: <span><%=city.getCountry()%></span> </h4>
            </div>
            <div>
                <h4 style="text-align: inherit;"> Diện tích: <span><%=city.getArea()%></span> </h4>
            </div>
            <div>
                <h4 style="text-align: inherit;"> Dân số: <span><%=city.getPopulation()%></span> </h4>
            </div>
            <div>
                <h4 style="text-align: inherit;"> GDP: <span><%=city.getGdp()%></span> </h4>
            </div>
            <br>
            <div>
                <h4 style="text-align: inherit;"> Giới thiệu:</h4>
                <h4 style="text-align: inherit;"> <%=city.getInstruction()%></h4>
            </div>
        </div>
        <!-- Paging -->
        <div class="paging">
            <button type="button" class="btn btn-info"><a href="/cities">Xong</a></button>
        </div>
    </div>
    <!-- <div class="overlay">
    </div> -->
</div>
</body>
</html>