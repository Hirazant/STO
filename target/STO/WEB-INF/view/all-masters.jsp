<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>All masters</h2>

    <br><br><br>

    <table border="3" align="center">

        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Middle Name</th>
            <th>Specialization</th>
        </tr>

        <c:forEach var="master" items="${allMasters}">

            <c:url var="updateButton" value="/updateMaster">
                <c:param name="masterId" value="${master.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteMaster">
                <c:param name="masterId" value="${master.id}"/>
            </c:url>

            <tr>
                <td>${master.masterNumber}</td>
                <td>${master.masterName}</td>
                <td>${master.masterLastname}</td>
                <td>${master.masterMiddlename}</td>
                <td>${master.masterSpecialization}</td>
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
           onclick="window.location.href = 'addNewMaster'"/>

</div>

</body>

</html>