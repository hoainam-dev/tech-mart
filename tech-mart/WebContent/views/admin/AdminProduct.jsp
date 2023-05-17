<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <%--    <link rel="stylesheet" th:href="@{static/dashboard.css}">--%>
  <link href="./static/css/dashboard.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />

</head>

<body>
<div class="">
        <jsp:include page="/includes/slide_nav.jsp" />
</div>
    <div class = "container" style ="padding-left: 0;
    ; margin-right: 0;">
        <jsp:include page="/includes/AdminNavbar.jsp" />
    </div>
<div class="container mt-3 mb-4" style ="padding-left: 0;
    ; margin-right: 0;">
  <div class="col-lg-9 mt-4 mt-lg-0">
    <div class="row">
      <div class="col-6">
       <a href="add">
          <button class="btn btn-success" data-toggle="modal" data-target="#myModalAdd">Add New</button></a>
           </div>
      <div class="col-6">
        <th class="text-center">Hiện Đang Có ${total} Sản Phẩm</th>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="user-dashboard-info-box table-responsive mb-0 bg-white p-4 shadow-sm">
          <div class="row">
            <form action="filter" method="Post">
              <label for="categoryId" class="form-label">Select Category</label>
              <select class="form-select" id="categoryId" name="category">
                <c:forEach var="category" items="${categories}">
                  <option value="${category.id}">${category.name}</option>
                </c:forEach>
              </select>
              <label for="price">Price:</label>
              <select id="price" name="price">
                <option value="">All</option>
                <option value="under-50">Under $50000</option>
                <option value="50-100">$50000 - $100000</option>
                <option value="over-100">Over $100000</option>
              </select>
              <button  type="submit" class="btn btn-info"> <i class="bi bi-funnel"></i> Filter </button>
            </form>
          </div>
          <table class="table manage-candidates-top mb-0">
            <thead>
            <tr>
              <th>Product Name</th>
              <th class="text-center">Price</th>
              <th class="action text-right">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
              <c:url var="tempLink" value="product">
                <c:param name="command" value="VIEW"></c:param>
                <c:param name="id" value="${product.id}"></c:param>
              </c:url>
              <c:url var="tempLink1" value="product">
                <c:param name="command" value="LOADUPDATE"></c:param>
                <c:param name="id" value="${product.id}"></c:param>
              </c:url>
              <c:url var="tempLink2" value="product">
                <c:param name="command" value="DELETE"></c:param>
                <c:param name="id" value="${product.id}"></c:param>
              </c:url>
              <tr class="candidates-list">
                <td class="title">
                  <div class="thumb">
                    <img class="img-thumbnail" style="max-width: none ; padding: 0" src="static/img/${product.image}" alt="">
                  </div>
                  <div class="candidate-list-details">
                    <div class="candidate-list-info">
                      <div class="candidate-list-title">
                        <h5 class="mb-0"><a href="#">${product.category}</a></h5>
                      </div>
                      <div class="candidate-list-option">
                        <ul class="list-unstyled">
                          <li><i class="fas fa-filter pr-1"></i>${product.name}</li>
                          <li><i class="fas fa-map-marker-alt pr-1">${product.description}</i></li>
                        </ul>
                        <p>${product.description}</p>
                      </div>
                    </div>
                  </div>
                </td>
                <td class="candidate-list-favourite-time text-center">
                  <a class="candidate-list-favourite order-2 text-danger" href="#"><i class="fas fa-heart"></i></a>
                    ${product.price}
                </td>
                <td>
                  <ul class="list-unstyled mb-0 d-flex justify-content-end">
                    <li><a href="${tempLink}" class="text-primary" data-toggle="tooltip" title="" data-original-title="view"><i class="far fa-eye"></i></a></li>
                    <li><a href="${tempLink1}" class="text-info" data-toggle="tooltip" title="" data-original-title="Edit"><i class="fas fa-pencil-alt"></i></a></li>
                    <li><a href="${tempLink2}" class="text-danger" data-toggle="tooltip" title="" data-original-title="Delete"><i class="far fa-trash-alt"></i></a></li>
                  </ul>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>

        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>