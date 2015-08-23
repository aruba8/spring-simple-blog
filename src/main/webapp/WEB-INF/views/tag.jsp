<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="category">
    <h2>Tag: ${tag.name}</h2>
    <c:forEach items="${articleList}" var="article">
        <h3><a href="/post/${article.permalink}">${article.title}</a></h3>
        <label><fmt:formatDate value="${article.dateTime}" type="date" dateStyle="long"/></label>
        <article class="article-preview">${article.articleBody}</article>
        <ul class="post-info">
            <c:if test="${not empty article.tags}">
                <c:forEach items="${article.tags}" var="tag">
                    <li><a href="/tag?tag=${tag.name}">${tag.name}</a></li>
                </c:forEach>
            </c:if>
            <li class="more"><a href="/post/${article.permalink}">Read ...</a></li>
        </ul>
    </c:forEach>
</div>
