<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="content">
    <div class="date"><fmt:formatDate value="${article.dateTime}" type="both" dateStyle="long" />
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