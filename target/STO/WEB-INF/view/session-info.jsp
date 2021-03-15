<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>Session Info</h2>

    <br>

    <table align="center" cellpadding="10">
        <tr>
            <td align="left">
                <form:form action="saveSession" modelAttribute="session">

                    <form:hidden path="id"/>

                    Client Name <form:select path="clientId">
                    <c:forEach var="cli" items="${allClients}">
                        <form:option value="${cli.id}" label="${cli.clientName}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Client Last  Name <form:select path="clientId">
                    <c:forEach var="cli" items="${allClients}">
                        <form:option value="${cli.id}" label="${cli.clientLastname}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>


                    Client Middle  Name <form:select path="clientId">
                    <c:forEach var="cli" items="${allClients}">
                        <form:option value="${cli.id}" label="${cli.clientMiddlename}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Car Brand <form:select path="clientId">
                    <c:forEach var="cli" items="${allClients}">
                        <form:option value="${cli.id}" label="${cli.carBrand}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Car Model <form:select path="clientId">
                    <c:forEach var="cli" items="${allClients}">
                        <form:option value="${cli.id}" label="${cli.carModel}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Car Year <form:select path="clientId">
                    <c:forEach var="cli" items="${allClients}">
                        <form:option value="${cli.id}" label="${cli.carYear}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Breakdowns <form:input path="breakdown"/>

                    <br><br>

                    Fix Date <form:input path="endTime"/>
                    <br><form:errors path="endTime"/><br>

                    Master Name <form:select path="masterId">
                    <c:forEach var="mas" items="${allMasters}">
                        <form:option value="${mas.id}" label="${mas.masterName}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Master Last Name <form:select path="masterId">
                    <c:forEach var="mas" items="${allMasters}">
                        <form:option value="${mas.id}" label="${mas.masterLastname}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>

                    Master Middle Name <form:select path="masterId">
                    <c:forEach var="mas" items="${allMasters}">
                        <form:option value="${mas.id}" label="${mas.masterMiddlename}"/>
                    </c:forEach>
                    </form:select>
                    <br><br>


                    <input type="submit" value="OK">
                </form:form>
            </td>
        </tr>
    </table>

</div>

</body>

</html>