<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="login_block">
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.authenticated}">
            <span>Hello: ${pageContext.request.userPrincipal.getName()}</span>
            <c:url var="logoutUrl" value="j_spring_security_logout"/>
            <form action="${logoutUrl}" method="post">
                <input type="submit" value="Log out"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </c:when>
        <c:otherwise>
            <a href="/login">login here</a>
        </c:otherwise>
    </c:choose>
</div>
<c:forEach items="${articleList}" var="article">
    <c:set var="fullArticleBody" value="${article.articleBody}"/>
    <c:set var="articlePreview" value="${fn:substring(fullArticleBody, 0, 350)}"/>
    <div class="article-item">
        <h3><a href="/post/${article.permalink}">${article.title}</a></h3>
        <label><fmt:formatDate value="${article.dateTime}" type="date" dateStyle="long"/></label>
        <article class="article-preview"><c:out value="${articlePreview}"/></article>
        <ul class="post-info">
            <c:if test="${not empty article.tags}">
                <c:forEach items="${article.tags}" var="tag">
                    <li>
                        <span class="tag">
                        <a href="/tag?tag=${tag.name}">${tag.name}</a>
                        </span>
                    </li>
                </c:forEach>
            </c:if>
            <li class="more"><a href="/post/${article.permalink}">Read ...</a></li>
        </ul>
    </div>
</c:forEach>

<div class="pagination">
    <div class="left_arrows"><c:if test="${currentPage > 2}">
        <a href="?p=${currentPage-1}"> << </a>
    </c:if>
    <c:if test="${currentPage == 2}">
        <a href="/"> << </a>
    </c:if></div>
    <c:if test="${maxNumberOfPages > currentPage}">
        <div class="right_arrows">
            <a href="?p=${currentPage+1}"> >> </a>
        </div>
    </c:if>
</div>