<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Lectores</title>
    </head>
    <body>
        <table>
            <thead>  
            <tr>
                <th>Número de Lector</th>
                <th>Nombre</th>
                <th>Teléfono</th>
                <th>Dirección</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="lector" 
                           items="${lectores}">
                    <tr>
                        <td>${lector.numeroLector}</td>
                        <td>${lector.nombre}</td>
                        <td>${lector.telefono}</td>
                        <td>${lector.direccion}</td>
                        <td><a href="LectorController?action=cambiar&numeroLector=${lector.numeroLector}">Cambiar</a></td>
                        <td><a href="LectorController?action=borrar&numeroLector=${lector.numeroLector}">Borrar</a></td>
                     </tr>  
                </c:forEach> 
            </tbody>
        </table>
        <p>
            <a href="LectorController?action=agregar">
                Agregar Lector
            </a>
        </p>
    </body>
</html>
