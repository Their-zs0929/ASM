<%-- 
    Document   : addItem
    Created on : Mar 18, 2021, 8:50:11 PM
    Author     : Lucires
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item</title>
    </head>
    <body>
        <h1>Add New Item</h1>
        <form action="MainController" method="POST">
            <c:if test="${requestScope.ERROR != null}">
                <c:set var="error" value="${requestScope.ERROR}"/>
            </c:if>
            
            Product ID <input type="text" name="id" value="${sessionScope.MAX + 1}" readonly="true" /></br></br>
            Category 
            <c:set var="categoryList" value="${sessionScope.CATE_LIST}"/>
            <select name="categoryId"> 
                <c:if test="${categoryList != null}">
                    <c:if test="${not empty categoryList}">
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </c:if>
                </c:if>           
            </select></br></br>         
            Product Name <input type="text" name="name" value="" required="true"/></br></br>
            Product Price <input type="number" name="price" value="0" step="0.1"/>
            ${error.getUserFloatError()}</br></br>
            Product Quantity <input type="number" name="quantity" value="0" />
            ${error.getUserIntegerError()}</br></br>
            <input type="submit" value="Add Confirm" name="action" />
        </form>
    </body>
</html>
