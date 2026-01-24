<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Products</title></head>
<body>
<h1>Products</h1>

<form action="products" method="get">
    Filter by price (≤):
    <input type="number" name="price" step="0.01"/>
    <button type="submit">Filter</button>
</form>

<table border="1">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Add to Cart</th></tr>
<c:forEach var="product" items="${products}">
<tr>
    <td>${product.id}</td>
    <td>${product.name}</td>
    <td>${product.price}</td>
    <td>
        <form action="addToCart" method="post">
            <input type="hidden" name="id" value="${product.id}"/>
            <input type="hidden" name="name" value="${product.name}"/>
            <input type="hidden" name="price" value="${product.price}"/>
            <button type="submit">Add to Cart</button>
        </form>
    </td>
</tr>
</c:forEach>
</table>
<a href="cart">View Cart</a>
</body>
</html>
