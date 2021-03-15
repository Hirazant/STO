<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>Master Info</h2>

    <br>

    <table align="center" cellpadding="10">
        <tr>
            <td align="left">
                <form:form action="saveMaster" modelAttribute="master">

                    <form:hidden path="id"/>

                    Number <form:input path="masterNumber"/>
                    <br><br>
                    Name <form:input path="masterName"/>
                    <br><br>
                    Last Name <form:input path="masterLastname"/>
                    <br><br>
                    Middle Name <form:input path="masterMiddlename"/>
                    <br><br>
                    Specialization <form:input path="masterSpecialization"/>
                    <br><br>
                    <input type="submit" value="OK">
                </form:form>
            </td>
        </tr>
    </table>

</div>

</body>

</html>