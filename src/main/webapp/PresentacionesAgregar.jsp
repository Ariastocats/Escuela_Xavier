<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<html>

    <head>
        <title> Agrega presentacion </title>
    </head>


<body>



    <form action="ServletPresentaciones" method="post">

        <label for="Presentacion"> Nombre de Presentacion </label>
        <input id="presentacion" type="text" name="presentacion">

        <br>
        <br>

        <label for="nombre"> dia </label>
        <input id="nom_her" type="date" name="dia">

        <br>
        <br>

        <label for="id_int"> Horario </label>
        <input id="nom_her" type="time" name="hora">



        <input type="submit" value="Agregar Presentacion">

    </form>


</body>
</html>