<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
    <title>Blog</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="<c:url value="/resources/style.css"/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script src="http://rangy.googlecode.com/svn/trunk/currentrelease/rangy-core.js"></script>
    <script type="application/javascript" src="<c:url value="/resources/hallo.js" />"></script>
</head>

<div id="header"><h1><a href="/">$BlogName</a></h1></div>
<h4>Hello: ${pageContext.request.userPrincipal}</h4>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.authenticated}">Show something</c:when>
    <c:otherwise>Show something else</c:otherwise>
</c:choose>

<div id="content">

<c:forEach items="${articleList}" var="article">
    <h3><a href="/post/${article.permalink}">${article.title}</a></h3>
    <label>${article.dateTime}</label>
    <article class="article-preview">${article.articleBody}</article>
</c:forEach>

</div>
</body>
</html>
