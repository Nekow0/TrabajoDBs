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
    <title>Proveedor::</title>
</head>

<body>
<jsp:include page="templates/navbar.jsp"/>
	<div class="container-fluid">
		<form:form method="post" action="/proveedor/login" modelAttribute="proveedor">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="apellido">Apellido:</form:label>
			<form:input type="text" path="apellido"/>
			<br>
			<form:label path="limite">Email:</form:label>
			<form:input type="text" path="limite"/>
			<br>
			<form:label path="codigoPostal">Edad:</form:label>
			<form:input type="text" path="codigoPostal"/>
			<br>
			<form:select path="cliente">
				<c:forEach items="${listaClientes}" var="proyecto">
					<form:option value="${proyecto.getId()}">
						${proyecto.getNombre()}
					</form:option>
				</c:forEach>
			</form:select>
			<br>
			<!--  <select class="form-select" name="proyecto">
					<c:forEach items="${listaProyectos}" var="proyecto">
						<c:if test="${proyecto.id == usuario.proyecto.id}">
							option selected value="${proyecto.id}">${proyecto.nombre}</option>
						</c:if>
						<option value="${proyecto.id}">${proyecto.nombre}</option>
					</c:forEach>
					</select> -->
			<input type="submit" value="Crear Usuario">

		</form:form>
		
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">Limite</th>
					<th scope="col">Codigo Postal</th>
					<th scope="col">Email</th>
					<th scope="col">Proyecto</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaUsuarios}" var="usuario">
					<tr>
						<th scope="row">${usuario.getId()}</th>
						<td>${usuario.getNombre()}</td>
                        <td>${usuario.getApellido()}</td>
                        <td>${usuario.getLimite()}</td>
                        <td>${usuario.getCodigoPostal()}</td>
                        <td>${usuario.getEmail()}</td>
                        <td>${usuario.getProyecto()}</td>
                        <td>
                        	<a href="/usuario/${usuario.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
                        </td>
                        <td>
                        	<form action="/usuario/eliminar" method="get">
                        		<input type="hidden" name="id" value="${usuario.getId()}">
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