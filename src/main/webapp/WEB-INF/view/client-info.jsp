<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>Client Info</h2>

    <br>

    <table align="center" cellpadding="10">
        <tr>
            <td align="left">
                <form:form action="saveClient" modelAttribute="client">

                    <form:hidden path="id"/>

                    Name <form:input path="clientName"/>
                    <br><form:errors path="clientName"/><br>
                    Last Name <form:input path="clientLastname"/>
                    <br><br>
                    Middle Name <form:input path="clientMiddlename"/>
                    <br><br>
                    Brand <form:input path="carBrand"/>
                    <br><br>
                    Model <form:input path="carModel"/>
                    <br><br>
                    Year <form:input path="carYear"/>
                    <br><br>
                    Mileage <form:input path="carMileage"/>
                    <br><br>
                    <input type="submit" value="OK">
                </form:form>
            </td>
        </tr>
    </table>

</div>

</body>

</html>