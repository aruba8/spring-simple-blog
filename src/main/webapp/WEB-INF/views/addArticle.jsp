<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Place this in the body of the page content -->
<form:form method="post" action="/addarticle" commandName="article">
    <textarea id="article-body" name="articleBody">
Title:
Date:${dateTime}
Categories:
Comments:true
~~~~~~~~~~~~~~

</textarea>
  <input type="submit" name="submit" value="submit" />
</form:form>
