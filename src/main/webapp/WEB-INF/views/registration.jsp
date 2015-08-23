<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="register-form">
    <form:form action="register" method="post" commandName="user">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Registration</h2></td>
            </tr>
            <tr>
                <td>Nickname:</td>
                <td><form:input path="username"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password"/></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
</div>