<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <table border="0">
        <tr>
            <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <h3>Thank you for registering! Here's the review of your details:</h3>
            </td>
        </tr>
        <tr>
            <td>User Name:</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td>${user.email}</td>
        </tr>
    </table>
</div>