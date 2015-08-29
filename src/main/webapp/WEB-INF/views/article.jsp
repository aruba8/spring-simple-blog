<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <div id="content">
        <div class="date"><fmt:formatDate value="${article.dateTime}" type="both" dateStyle="long"/>
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
<div class="comments">
<c:forEach items="${article.comments}" var="comment">
    <div class="comment">
        <div class="comment_author">${comment.author.name}</div>
        <div class="comment_date"><fmt:formatDate value="${comment.dateTime}" type="both"
                                                  dateStyle="long"/></div>
        <div class="comment_text">${comment.comment}</div>
    </div>
</c:forEach>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal.authenticated}">

            <div class="add_comment">
                <form:form method="post" action="/comment/addcomment" commandName="comment"
                           modelAttribute="comment">
                    <input name="article_id" type="hidden" value="${article.id}"/>
                    <textarea name="comment"></textarea>
                    <input type="submit" value="Comment">
                </form:form></div>
        </div>
    </c:when>
</c:choose>
<script>hljs.initHighlightingOnLoad();</script>