<%-- 
    Document   : viewCart
    Created on : Mar 13, 2021, 7:13:53 PM
    Author     : Lucires
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
    </head>
    <body>
        <h1>Your Shopping Cart</h1>
        <c:if test="${sessionScope.CART == null || empty sessionScope.CART.getCart()}">
            <font color="pink">Gio hang cua ban dang trong..</font></br>
        </c:if>
        <c:if test="${requestScope.QUANTITY_ERROR != null}">
            <c:set var="error" value="${requestScope.QUANTITY_ERROR}"/>
            ${requestScope.QUANTITY_ERROR.getUserIntegerError()}
        </c:if>

        <c:if test="${sessionScope.CART != null}">
            <c:if test="${not empty sessionScope.CART.getCart()}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="total" value="0"></c:set>
                        <c:forEach var="product" items="${sessionScope.CART.getCart().values()}" varStatus="counter">
                        <form action="MainController" method="POST">
                            <tr>
                                <c:set var="total" value="${total + Math.round(product.price * product.quantity * 10)/10}"></c:set>
                                <td>${counter.count}</td>
                                <td>
                                    <input type="text" name="id" value="${product.id}" readonly="true" />
                                </td>
                                <td>
                                    <input type="hidden" name="name" value="${product.name}" />
                                    ${product.name}
                                </td>
                                <td>
                                    <input type="hidden" name="price" value="${product.price}" />
                                    ${product.price}
                                </td>
                                <td>
                                    <input type="number" name="quantity" value="${product.quantity}" />
                                </td>
                                <td>${Math.round(product.price * product.quantity * 10)/10}</td>
                                <td>
                                    <input type="submit" value="Update cart" name="action"/>
                                </td>
                                <td>
                                    <input type="submit" value="Remove from cart" name="action"/>
                                </td>
                            </tr>
                        </form>                           
                    </c:forEach>                       
                </tbody>
            </table>
            <h2><c:out default="" value="Total : ${Math.round(total * 10)/10}"></c:out></h2>
            <c:url var="PayConfirm" value="MainController">
                <c:param name="total" value="${Math.round(total * 10)/10}"></c:param>     
                <c:param name="email" value="${sessionScope.GG_USER.getEmail()}"></c:param>     
                <c:param name="action" value="Confirm Payment"></c:param>       
            </c:url>
            <a href="${PayConfirm}">
                <font color="orange">Confirm Payment</font>                
            </a>
        </c:if>
    </c:if>
    <a href="SearchController?cbxCategory=${sessionScope.CATEGORY_SEARCH}">
        <font color="orange">Go back to shopping</font>
    </a></br>
</body>
</html>
