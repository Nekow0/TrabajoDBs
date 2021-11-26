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
    <title>Clientes::</title>
</head>

<body>
<jsp:include page="../templates/navbar.jsp"/>
	<div class="container-fluid">
		<form:form method="post" action="/cliente/crear" modelAttribute="cliente">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/>
			<br>
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"/>
			<br>
			<form:label path="edad">Edad:</form:label>
			<form:input type="text" path="edad"/>
	
			<br>
			<br>
			<form:form action="cliente/cliente.jsp" method="get">
				<input type="checkbox" name="cliente" value="${cliente.getId()}">
			</form:form>
			<br>
			<input type="submit" value="Crear Cliente">
		</form:form>
		
		<table>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Email</th>
					<th scope="col">Edad</th>
					<th scope="col">Plan</th>
					<th scope="col-2">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaClientes}" var="proveedor">
					<tr>
						<th scope="row">${cliente.getId()}</th>
						<td>${cliente.getNombre()}</td>
                        <td>${cliente.getEmail()}</td>
                        <td>${cliente.getEdad()}</td>
                         <td>${cliente.getPlan()}</td>
                          <td>${cliente.getCelular()}</td>
                        <td>
                        	<a href="/cliente/${cliente.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
                        </td>
                        <td>
                        	<form action="/cliente/eliminar" method="get">
                        		<input type="hidden" name="id" value="${cliente.getId()}">
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