<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
  <title>Login Page</title>
</head>
<body>
<h2 style="color: orange">Login</h2>
<c:if test="${not empty error}">
  <div style="color:red">
    Login Failed!!!<br />
    Reason : ${error}
  </div>
</c:if>
<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>
<form action="<c:url value='/j_spring_security_check' />" method="POST">
  <input type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}' />
  <table frame="box" cellpadding="0" cellspacing="6">
    <tr>
      <td>Username:</td>
      <td><input type='text' name='username' /></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type='password' name='password'></td>
    </tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit" value="Submit"></td>
    </tr>
  </table>
</form>
</body>
</html>