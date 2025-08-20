<%--
    Document   : venta
    Created on : 20/08/2025
    Author     : Le Chat
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="Styles/zapato.css" />
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zapateria| Gestión de Ventas</title>
    <link rel="stylesheet" href="Styles/venta.css">
</head>
<body>

    <nav>

    </nav>

    <div class="fondo"></div>

    <div class="contenedor-principal">

        <div class="panel-formulario">
            <h1>Gestión de Ventas</h1>
            <form action="Controlador?menu=Venta" method="post" class="formulario">

                <input type="text" autocomplete="off" value="${venta.getCodigoVenta()}" name="txtCodigoVenta" placeholder="Código Venta" />
                <input type="text" autocomplete="off" value="${venta.getCodigoZapato()}" name="txtCodigoZapato" placeholder="Código Zapato" required />
                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                </div>
            </form>
            <div class="marca-interna">
                Zapateria
            </div>
        </div>

        <div class="panel-tabla">
            <div class="tabla-contenedor">
                <table class="tabla">
                    <thead>
                        <tr>
                            <th>Código Venta</th>
                            <th>Código Zapato</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="venta" items="${ventas}">
                        <tr>
                            <td>${venta.codigoVenta}</td>
                            <td>${venta.codigoZapato}</td>
                            <td>
                            <a href="Controlador?menu=Venta&accion=Editar&codigoVenta=${venta.codigoVenta}" class="btn editar">Editar</a>
                            <a href="Controlador?menu=Venta&accion=Eliminar&codigoVenta=${venta.codigoVenta}" class="btn eliminar">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

</body>
</html>
