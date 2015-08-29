<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<c:set var="now" value="<%=new java.util.Date()%>"/>
by <a href="https://github.com/biomaks/simple-java.blog">Simple Blog</a>
<fmt:formatDate value="${now}" pattern="yyyy"/>