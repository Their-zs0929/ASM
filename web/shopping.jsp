<%-- 
    Document   : search
    Created on : Mar 9, 2021, 12:38:42 PM
    Author     : Lucires
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER != null || sessionScope.GG_USER != null}">
            <h3>
                <font color="pink">Welcome
                <c:if test="${sessionScope.STATUS != null}">
                    <c:if test="${'Admin'.equals(sessionScope.STATUS)}">
                        ADMIN
                    </c:if>
                </c:if>
                ${sessionScope.USER.getName()} ${sessionScope.GG_USER.getName()}</font>
                <a href="LogoutController"><font color="orange">Log Out</font></a>
            </h3>
        </c:if>
        <c:if test="${sessionScope.USER == null && sessionScope.GG_USER == null}">
            <a href="login.html"><font color="pink">Login</font></a>  
            </c:if>

        <h1><font color="orange">My Store</font></h1>

        </br><!-- Search products with category -->
        <c:set var="categoryList" value="${sessionScope.CATE_LIST}"/>
        <form action="MainController">
            Category
            <select name="cbxCategory">
                <option value="all">-All-</option>
                <c:if test="${categoryList != null}">
                    <c:if test="${not empty categoryList}">
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </c:if>
                </c:if>           
            </select>
            <input type="submit" value="Search" name="action" /> 
            <input type="submit" value="View Cart" name="action" /> 
            <c:if test="${sessionScope.STATUS != null}">
                <c:if test="${'Admin'.equals(sessionScope.STATUS)}">
                    <input type="submit" value="Add Item" name="action" />
                </c:if>
            </c:if>
        </form>       
        </br><!-- Search Result -->
        <font color="green">${requestScope.MESSAGE}</font>
        <c:if test="${requestScope.PRO_LIST != null}">
            <c:if test="${not empty requestScope.PRO_LIST}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Add To Cart</th>
                                <c:if test="${sessionScope.STATUS != null}">
                                    <c:if test="${'Admin'.equals(sessionScope.STATUS)}">
                                    <th>Update</th>
                                    <th>Delete</th>
                                    </c:if>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${requestScope.PRO_LIST}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>
                                    <c:url var="AddToCart" value="MainController">
                                        <c:param name="id" value="${product.id}"></c:param>
                                        <c:param name="name" value="${product.name}"></c:param>
                                        <c:param name="price" value="${product.price}"></c:param>
                                        <c:param name="quantity" value="${product.quantity}"></c:param>
                                        <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>
                                        <c:param name="action" value="Add Cart"></c:param>
                                    </c:url>
                                    <a href="${AddToCart}">
                                        <font color="pink">Add to cart</font>
                                    </a>
                                </td>
                                <c:if test="${sessionScope.STATUS != null}">
                                    <c:if test="${'Admin'.equals(sessionScope.STATUS)}">
                                        <td>update</td>
                                        <td>
                                            <c:url var="Delete" value="MainController">
                                                <c:param name="id" value="${product.id}"></c:param>
                                                <c:param name="cbxCategory" value="${param.cbxCategory}"></c:param>       
                                                <c:param name="action" value="Delete Item"></c:param>       
                                            </c:url>
                                            <a href="${Delete}">Delete</a>
                                        </td>
                                    </c:if>
                                </c:if>
                            </tr>                           
                        </c:forEach>                                
                    </tbody>
                </table>
            </c:if>
        </c:if> 
    </body>
</html>
