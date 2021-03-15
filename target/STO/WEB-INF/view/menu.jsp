<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<div style="text-align: center;">

    <br><br>

    <table border="3" align="center">
        <tr>
            <th>Menu</th>
        </tr>

        <tr>
            <td>
                <input type="button" style="height:50px;width:100px" value="All clients"
                       onclick="window.location.href = '<c:url value="/showAllClients"/>'"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" style="height:50px;width:100px" value="All masters"
                       onclick="window.location.href = '<c:url value="/showAllMasters"/>'"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" style="height:50px;width:100px" value="Repair"
                       onclick="window.location.href = '<c:url value="/showAllSessions"/>'"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" style="height:50px;width:100px" value="Report"
                       onclick="window.location.href = '<c:url value="/showReport"/>'"/>
            </td>
        </tr>

    </table>

</div>

</body>

</html>