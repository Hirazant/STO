<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>Timetable</h2>

    <br><br><br>

    <table border="3" align="center">

        <tr>
            <th>Client Name</th>
            <th>Client Last Name</th>
            <th>Car Brand</th>
            <th>Car Model</th>
            <th>Car Year</th>
            <th>Breakdowns</th>
            <th>Fix Date</th>
            <th>Master Name</th>
            <th>Master Last Name</th>
            <th>Master Middle Name</th>
        </tr>

        <c:forEach var="session" items="${allSessions}">

            <c:url var="updateButton" value="/updateSession">
                <c:param name="sessionId" value="${session.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteSession">
                <c:param name="sessionId" value="${session.id}"/>
            </c:url>

            <tr>
                <td>${session.client.clientName}</td>
                <td>${session.client.clientLastname}</td>
                <td>${session.client.carBrand}</td>
                <td>${session.client.carModel}</td>
                <td>${session.client.carYear}</td>
                <td>${session.breakdown}</td>
                <td>
                    <fmt:formatDate value="${session.endTime}" pattern="yyyy-MM-dd HH:mm" />
                </td>
                <td>${session.master.masterName}</td>
                <td>${session.master.masterLastname}</td>
                <td>${session.master.masterMiddlename}</td>
                <td>
                    <input type="button" value="Update"
                           onclick="window.location.href = '${updateButton}'"/>
                    <input type="button" value="Delete"
                           onclick="if (confirm('Are you sure?')) window.location.href = '${deleteButton}'"/>
                </td>
            </tr>

        </c:forEach>

    </table>

    <br>
    <input type="button" value="add"
           onclick="window.location.href = 'addNewSession'"/>

</div>

</body>

</html>