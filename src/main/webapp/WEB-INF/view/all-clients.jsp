<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <h2>All clients</h2>

    <br><br><br>
    <a href="../STO_war_exploded/report"> Make reports</a>
    <br><br><br>

    <table border="3" align="center">

        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>Middle Name</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Year</th>
            <th>Mileage</th>
        </tr>

        <c:forEach var="client" items="${allClients}">

            <c:url var="updateButton" value="/updateClient">
                <c:param name="clientId" value="${client.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteClient">
                <c:param name="clientId" value="${client.id}"/>
            </c:url>

            <tr>
                <td>${client.clientName}</td>
                <td>${client.clientLastname}</td>
                <td>${client.clientMiddlename}</td>
                <td>${client.carBrand}</td>
                <td>${client.carModel}</td>
                <td>${client.carYear}</td>
                <td>${client.carMileage}</td>
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
               onclick="window.location.href = 'addNewClient'"/>

</div>

</body>

</html>