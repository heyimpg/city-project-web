<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/11/2021
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>

<%--Thay mới--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tra cứu thành phố</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="/Asset/css/list-css.css">
</head>
<body>



<div class="bg">
    <header>
        <!-- Tiêu đề -->
        <h2 class="title-city">Danh sách thành phố</h2>
        <!-- navigation -->
        <div class="nav">
            <div class="row">
                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <button class="btnOption">
                        <a href="/cities?action=create">Thêm thành phố</a>

                    </button>
                </div>
                <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                    <form  method="POST" action="cities?action=search" role="form">

                        <!-- <div class="form-group"> -->
                        <input type="text" name="search-name" class="form-control" id="inputSearch" placeholder="Nhập tên thành phố...">
                        <button type="submit" class="btn btn-primary">Tìm kiếm</button>


                        <!-- </div> -->
                    </form>
                </div>

            </div>
            <div class="row">
                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <button class="btnOption" style="margin-top: 10px">
                        <a href="/cities">Hiện tất cả</a>
                    </button>
                </div>
            </div>
        </div>

    </header>
    <!-- phần chứa bảng -->
    <div class="container-fluid">
        <div class="field-table">
            <!-- table -->
            <table class="table table-striped table-hover" border="1" cellpadding="5">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Thành phố</th>
                        <th>Quốc gia</th>
                        <th>Chức năng</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="city" items="${listCities}">
                        <tr>
                            <td><c:out value="${city.getID()}"/></td>
                            <td><a href="/cities?action=detail&id=${city.getID()}"><c:out value="${city.getName()}"/></a></td>
                            <td><c:out value="${city.getCountry()}"/></td>
                            <td>
                                <a href="/cities?action=edit&id=${city.getID()}">Sửa</a>
                                |
                                <a href="/cities?action=delete&id=${city.getID()}">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Paging -->
        <% String searchRt = (String) request.getAttribute("search-name-rt");%>
        <% String actionRt = (String) request.getAttribute("action-rt");%>

      <%--  <%int currentPage = (int) request.getAttribute("pageIndex");%>--%>
        <div class="paging">
            <ul class="pagination">
                <li><a href="#">&laquo;</a></li>

                <c:choose>
<%--                    In ra bthg nếu size <= 3 --%>
                    <c:when test="${countPage<=3}">
                        <c:forEach begin="1" end="${countPage}" var="item">
                            <li>
                                <a href="/cities?action=<%=actionRt%>&pageIndex=${item}&search-name=<%=searchRt%>">
                                        ${item}
                                </a>
                            </li>
                        </c:forEach>
                    </c:when>
<%--                   Phân ra làm TH nếu >3 --%>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${pageIndex==1}">
                                <c:forEach begin="${pageIndex}" end="${pageIndex+2}" var="item">
                                    <li>
                                        <a href="/cities?action=<%=actionRt%>&pageIndex=${item}&search-name=<%=searchRt%>">
                                                ${item}
                                        </a>
                                    </li>
                                </c:forEach>
                            </c:when>
                            <c:when test="${pageIndex==countPage}">
                                <c:forEach begin="${pageIndex-2}" end="${pageIndex}" var="item">
                                    <li>
                                        <a href="/cities?action=<%=actionRt%>&pageIndex=${item}&search-name=<%=searchRt%>">
                                                ${item}
                                        </a>
                                    </li>
                                </c:forEach>
                            </c:when>
                           <c:otherwise>
                               <c:forEach begin="${pageIndex-1}" end="${pageIndex+1}" var="item">
                                   <li>
                                       <a href="/cities?action=<%=actionRt%>&pageIndex=${item}&search-name=<%=searchRt%>">
                                               ${item}
                                       </a>
                                   </li>
                               </c:forEach>
                           </c:otherwise>
                        </c:choose>

                    </c:otherwise>
                </c:choose>

                <li><a href="#">&raquo;</a></li>
            </ul>
        </div>

    </div>
    <!-- <div class="overlay">

    </div> -->
</div>
</body>
</html>