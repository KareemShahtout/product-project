<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f5f5f5;
        }

        .form-box {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 6px;
            max-width: 600px;
            margin-top: 20px;
        }

        input[readonly] {
            background-color: #e9ecef !important;
            opacity: 1;
        }
    </style>
</head>

<body>

<div class="container">
    <h2 class="mt-5 mb-3">Update Product</h2>

    <div class="form-box">

        <form:form action="${pageContext.request.contextPath}/products/updateProduct/${product.id}" method="post" modelAttribute="product">

            <!-- Id (readonly) -->
            <div class="mb-3">
                <label class="form-label">Id</label>
                <input type="number"
                       name="id"
                       class="form-control"
                       value="${product.id}"
                       readonly
                       />
            </div>

            <!-- Product Name -->
            <div class="mb-3">
                <label class="form-label">product name</label>
                <form:input type="text"
                       name="name"
                       class="form-control"
                       placeholder="Enter product name"
                       value="${productDetails.name}"
                       path="productDetails.name"
                       />
            </div>

            <!-- Expiration Date -->
            <div class="mb-3">
                <label class="form-label">Expiration Date</label>
                <form:input type="date"
                       name="expirationDate"
                       class="form-control"
                       placeholder="dd/mm/yyyy"
                       value="${productDetails.expirationDate}"
                       path="productDetails.expirationDate"/>
            </div>

            <!-- Manufacturer -->
            <div class="mb-3">
                <label class="form-label">Manufacturer</label>
                <form:input type="text"
                       name="manufacturer"
                       class="form-control"
                       placeholder="Manufacturer"
                       value="${productDetails.manufacturer}"
                       path="productDetails.manufacturer"/>
            </div>

            <!-- Price -->
            <div class="mb-3">
                <label class="form-label">Price</label>
                <form:input type="number"
                       name="price"
                       class="form-control"
                       placeholder="Price"
                       value="${productDetails.price}"
                       path="productDetails.price"/>
            </div>

            <!-- Availability -->
            <div class="mb-3">
                <label class="form-label">Availability</label>
                <form:input type="number"
                       name="availability"
                       class="form-control"
                       placeholder="0 or 1"
                       min="0"
                       max="1"
                       value="${productDetails.available}"
                       path="productDetails.available"/>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form:form>

    </div>
</div>

</body>
</html>