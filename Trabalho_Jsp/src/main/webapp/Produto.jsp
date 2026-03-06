<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Produto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>

<style>

body{
	font-family: Arial, Helvetica, sans-serif;
	background-color: #f4f6f8;
	text-align: center;
}

h1{
	color: #2c3e50;
}

table{
	margin: auto;
	border-collapse: collapse;
	width: 60%;
	background-color: white;
}

th{
	background-color: #34495e;
	color: white;
	padding: 10px;
}

td{
	padding: 8px;
	border: 1px solid #ddd;
}

tr:nth-child(even){
	background-color: #f2f2f2;
}

a{
	display: inline-block;
	margin-top: 20px;
	padding: 10px 15px;
	background-color: #3498db;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}

a:hover{
	background-color: #2980b9;
}

.erro{
	color: red;
	font-weight: bold;
}

.sucesso{
	color: green;
	font-weight: bold;
}

</style>

</head>
<body>

<h1>Produtos Cadastrados</h1>

<%
String erro = (String) request.getAttribute("erro");
String sucesso = (String) request.getAttribute("sucesso");

if(erro != null){
%>
<p class="erro"><%= erro %></p>
<%
}

if(sucesso != null){
%>
<p class="sucesso"><%= sucesso %></p>
<%
}
%>

<table border=1>
<tr>
	<th>ID</th>
	<th>Nome</th>
	<th>Preço</th>
</tr>

<%
ArrayList<Produto> lista = (ArrayList<Produto>)request.getAttribute("minhaLista");
if (lista != null) {
	for (Produto p : lista) {
%>

<tr>
	<td><%= p.getId() %></td>
	<td><%= p.getNome() %></td>
	<td>R$ <%= p.getPreco() %></td>
</tr>

<%
	}
}
%>

</table>

<a href="produto?troca=novo">Novo Produto</a>

</body>
</html>