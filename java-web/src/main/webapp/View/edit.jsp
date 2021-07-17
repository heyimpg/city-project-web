<%@ page import="Model.City" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/11/2021
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--File mới có css--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
    <title>Chỉnh sửa</title>
    <link rel="stylesheet" href="/Asset/css/create-css.css">
</head>
<body>

<%City city = (City) request.getAttribute("edit-city");%>

<div class="bg">
    <head>
        <!-- Tiêu đề -->
        <h2 class="title-city">Chỉnh sửa thành phố ${requestScope["edit-city"].getName()}</h2>
        <!-- navigation -->
    </head>
    <!-- phần chứa bảng -->
    <div class="container-fluid">
        <div class="field-input">

            <form method="POST" role="form">

                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <h4>Tên</h4>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="name" placeholder="Nhập tên thành phố" value="<%=city.getName()%>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <h4>Quốc gia</h4>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <input type="text" class="form-control" name="country" placeholder="Nhập tên quốc gia" value="<%=city.getCountry()%>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <h4>Diện tích</h4>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="area" placeholder="Nhập diện tích" value="<%=city.getArea()%>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <h4>Dân số</h4>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="population" placeholder="Nhập dân số" value="<%=city.getPopulation()%>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <h4>GDP</h4>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="GDP" placeholder="Nhập GDP"  value="<%=city.getGdp()%>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <h4>Giới thiệu</h4>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <textarea class="form-control" name="instruction" placeholder="Thêm giới thiệu về thành phố của bạn" id="floatingTextarea2" style="height: 100px"><%=city.getInstruction()%></textarea>
                    </div>
                </div>
                <div class="row">
                    <center>
                        <button type="submit" class="btn btn-primary" >Cập nhật</button>
                        <button class="btn btn-default" ><a href="/cities">Thoát</a></button>
                    </center>
                </div>

            </form>

        </div>

    </div>

</div>
</body>
</html>
