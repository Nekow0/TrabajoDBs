<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Proveedores::</title>
</head>

<body>
<jsp:include page="../templates/navbar.jsp"/>
	<div class="container-fluid">
		<form:form method="post" action="/proveedor/crear" modelAttribute="proveedor">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input type="text" path="apellido"/>
			<br>
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"/>
			<br>
			<form:label path="edad">Edad:</form:label>
			<form:input type="text" path="edad"/>
			<br>
			<form:form action="proveedor/proveedor.jsp" method="get">
				<input type="checkbox" name="cliente" value="${proveedor.getId()}">
			</form:form>
			<br>
			<input type="submit" value="Crear Proveedor">
		</form:form>
		
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">Email</th>
					<th scope="col">Edad</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaProveedores}" var="proveedor">
					<tr>
						<th scope="row">${proveedor.getId()}</th>
						<td>${proveedor.getNombre()}</td>
                        <td>${proveedor.getEmail()}</td>
                        <td>${proveedor.getEdad()}</td>
                        <td>
                        	<a href="/proveedor/${proveedor.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
                        </td>
                        <td>
                        	<form action="/proveedor/eliminar" method="get">
                        		<input type="hidden" name="id" value="${proveedor.getId()}">
                        		<input type="submit" value="Eliminar">
                        	</form>
                        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

</html>