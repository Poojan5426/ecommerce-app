<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Cart</title></head>
<body>
<h1>Your Cart</h1>

<table border="1">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Quantity</th></tr>
<c:forEach var="cartItem" items="${cartItems}">
    <tr>
        <td>${cartItem.id}</td>
        <td>${cartItem.name}</td>
        <td>${cartItem.price}</td>
        <td>${cartItem.quantity}</td>
    </tr>
</c:forEach>
</table>

<a href="products">Back to Products</a>
</body>
</html>
