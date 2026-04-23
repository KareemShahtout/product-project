<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Products Data</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f5f5f5;
        }

        .main-box {
            background-color: #e9e9e9;
            padding: 30px;
            margin-top: 50px;
            border-radius: 6px;
        }

        .table thead {
            background-color: #2c2c2c;
            color: white;
        }

        .btn-warning {
            color: white;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="main-box">

        <h2 class="mb-4">Products Data</h2>

        <table class="table table-borderless align-middle">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Show Details</th>
                    <th>Add/Update</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>

                <!-- البيانات جاي من السيرفلت -->
                <c:forEach var="product" items="${productList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${product.name}</td>

                        <td>
                            <a href="viewProduct?id=${product.id}"
                               class="btn btn-primary btn-sm">
                                View Details
                            </a>
                        </td>

                        <td>
                            <a href="<c:url value='/products/updateProduct/${product.id}' />"
                               class="btn btn-warning btn-sm">
                                Add/Update Details
                            </a>
                        </td>

                        <td>
                             <form action="${pageContext.request.contextPath}/products/deleteProduct/${product.id}"
                                      method="post"
                                      style="display: inline;">

                                    <input type="hidden" name="id" value="${product.id}" />

                                    <button type="submit" class="btn btn-danger btn-sm">
                                        Delete
                                    </button>
                                </form>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <a href="<c:url value='/products/addNewProduct' />" class="btn btn-success">
            Add new Product
        </a>

    </div>
</div>

</body>
</html>