<%@page import="es.tarjetas.modelo.TarjetaCredito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Actualizar" method="get">
<% TarjetaCredito tarjetaCredito = (TarjetaCredito)request.getAttribute("tarjetaCredito"); %>
<table>
    <tr>
      <th>Nº Tarjeta consultado</th>
      <th>Modificar Cupo Disponible</th>
   </tr>
     
  <tr>
      <td><input type="text" name="numero" value="<%=tarjetaCredito.getNumero() %>"readonly="readonly"/></td>
      <td><input type="text" name="cupoDisponible" value="<%=tarjetaCredito.getCupoDisponible() %>"/></td> 
  </tr>
</table>
 
 <input type="submit" value="Actualizar" id="actualizar" name="actualizar"/>
</form>
 <p><a href="index.html"  >Volver a Inicio</a></p>
</body>

</html>