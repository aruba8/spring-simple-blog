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
<body>
<div id="header"><h1><a href="/">$blogName</a></h1></div>

<div id="content">
    <div class="date">${article.dateTime}
    </div>

    <div class="title">${article.title}</div>
    <ul class="post-info">
    </ul>

    <div class="article">
        <article>
            ${article.articleBody}
        </article>
    </div>

</div>
<div class="copyright">by <a href="https://github.com/biomaks/simple-java.blog">Simple Blog</a> 2013</div>

</body>
</html>
