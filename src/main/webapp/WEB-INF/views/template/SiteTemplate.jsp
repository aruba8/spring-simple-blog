<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blog</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
    <script src="<c:url value="/resources/js/main.js"/>"></script>
</head>
<body>
<div class="wrapper">
    <!-- Header -->
    <title:insertAttribute name="header"/>

    <!-- Body -->

    <div class="content">
        <tiles:insertAttribute name="content"/>
    </div>

    <!-- Footer -->

    <div class="footer">
        <tiles:insertAttribute name="footer"/>
    </div>

</div>
</body>
</html>
