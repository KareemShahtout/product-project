<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add New Product</title>

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
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>

<body>

<div class="container">
    <h3 class="mt-4">Add new Product</h3>

    <div class="main-box">

        <h4 class="mb-4">Add Product</h4>

        <!-- Spring Form -->
        <form:form method="post"
                   action="${pageContext.request.contextPath}/products/addNewProduct"
                   modelAttribute="product">

            <!-- Product Name -->
            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <form:input path="productDetails.name"
                            cssClass="form-control"
                            placeholder="Enter product name"/>
                            <form:errors path="productDetails.name" cssClass="error"/>

            </div>

            <!-- Expiration Date -->
            <div class="mb-3">
                <label class="form-label">Expiration Date</label>
                <form:input path="productDetails.expirationDate"
                            type="date"
                            cssClass="form-control"/>
                            <form:errors path="productDetails.expirationDate" cssClass="error"/>
            </div>

            <!-- Manufacturer -->
            <div class="mb-3">
                <label class="form-label">Manufacturer</label>
                <form:input path="productDetails.manufacturer"
                            cssClass="form-control"
                            placeholder="Manufacturer"/>
                            <form:errors path="productDetails.manufacturer" cssClass="error"/>
            </div>

            <!-- Price -->
            <div class="mb-3">
                <label class="form-label">Price</label>
                <form:input path="productDetails.price"
                            type="number"
                            step="0.01"
                            cssClass="form-control"
                            placeholder="Price"/>
                            <form:errors path="productDetails.price" cssClass="error"/>
            </div>

            <!-- Availability -->
            <div class="mb-3">
                <label class="form-label">Availability (0 or 1)</label>
                <form:input path="productDetails.available"
                            type="number"
                            min="0"
                            max="1"
                            cssClass="form-control"
                            placeholder="0 or 1"/>
                            <form:errors path="productDetails.available" cssClass="error"/>
            </div>

            <button type="submit" class="btn btn-primary">
                Submit
            </button>

        </form:form>

    </div>
</div>

</body>
</html>