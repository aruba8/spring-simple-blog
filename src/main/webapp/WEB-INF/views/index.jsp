<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h4>Hello: ${pageContext.request.userPrincipal.getName()}</h4>

<c:choose>
    <c:when test="${pageContext.request.userPrincipal.authenticated}">
        <div><span>Logged in</span></div>
        <br/>

        <div>
            <c:url var="logoutUrl" value="j_spring_security_logout"/>
            <form action="${logoutUrl}" method="post">
                <input type="submit" value="Log out"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        not logged in<br/>
        <a href="/login">login here</a>
    </c:otherwise>
</c:choose>
<div id="content">
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