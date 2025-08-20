<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Contenido Gestión de Zapatos</title>
    <link rel="stylesheet" href="Styles/zapato.css" />
</head>
<body>
    <nav></nav>
    <div class="contenedor-principal">
        <div class="form-container">
            <h2>Gestión de Zapatos</h2>
            <form action="Controlador?menu=Zapato" method="POST" class="formulario">
                <input type="text" autocomplete="off" value="${zapato.getCodigoZapato()}" name="txtCodigoZapato" placeholder="Código Zapato" />
                <input type="text" autocomplete="off" value="${zapato.getModelo()}" name="txtModelo" placeholder="Modelo" required />
                <input type="number" autocomplete="off" value="${zapato.getTalla()}" name="txtTalla" placeholder="Talla" required />
                <input type="text" autocomplete="off" value="${zapato.getColor()}" name="txtColor" placeholder="Color" required />
                <input type="number" step="0.01" autocomplete="off" value="${zapato.getPrecio()}" name="txtPrecio" placeholder="Precio" required />
                <input type="number" autocomplete="off" value="${zapato.getStock()}" name="txtStock" placeholder="Stock" required />
                <div class="botones">
                    <button type="submit" name="accion" value="Agregar">Agregar</button>
                    <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
                </div>
            </form>
            <div class="marca-interna">Zapatos DC</div>
        </div>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Modelo</th>
                        <th>Talla</th>
                        <th>Color</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="zapato" items="${zapatos}">
                        <tr>
                            <td>${zapato.codigoZapato}</td>
                            <td>${zapato.modelo}</td>
                            <td>${zapato.talla}</td>
                            <td>${zapato.color}</td>
                            <td>${zapato.precio}</td>
                            <td>${zapato.stock}</td>
                            <td>
                                <a href="Controlador?menu=Zapato&accion=Editar&codigoZapato=${zapato.codigoZapato}" class="btn editar">Editar</a>
                                <a href="Controlador?menu=Zapato&accion=Eliminar&codigoZapato=${zapato.codigoZapato}" class="btn eliminar">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>