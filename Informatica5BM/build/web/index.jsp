<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zapateria CD | Tienda</title>
    <link rel="stylesheet" href="Styles/index.css">
</head>
<body>
    <h1>Bienvenido a CD.</h1>
    <p>Seleccione una opción:</p>

<ul>
    
<li><a href="Controlador?menu=Venta&accion=Listar" target="contenido">Ventas</a></li>
<li><a href="Controlador?menu=Zapato&accion=Listar" target="contenido">Zapatos</a></li>

</ul>

    <iframe name="contenido" style="width:100%; height:850px; border:none;"></iframe>
</body>
</html>
