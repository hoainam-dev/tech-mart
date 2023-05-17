<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PV
  Date: 5/14/2023
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <c:choose>
        <c:when test = "${Status}">
            <div class="alert alert-danger" role="alert">
                Product id already exists !!!
            </div>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>


    <h1 class="mb-4">Add Product</h1>
    <form action="add" method="POST" >
        <div class="form-group">
            <label for="productName">Product ID:</label>
            <input type="text" class="form-control" id="productId" name="id" required>
        </div>
        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" class="form-control" id="productName" name="name" required>
        </div>
        <div class="form-group">
            <label for="categoryId" class="form-label">Select Category</label>
            <select class="form-select" id="categoryId" name="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description"></textarea>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" name="price" required>
        </div>
        <div class="form-group">
            <label for="image">Image:</label>
            <input type="text" class="form-control" id="image"  name="image" required>
<%--            <input type="file" class="form-control-file" id="image" name="image">--%>
        </div>
        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
</div>
</body>
</html>
