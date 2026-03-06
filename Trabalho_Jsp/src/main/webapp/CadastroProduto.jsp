<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novo Produto</title>

<style>

body{
    font-family: Arial, Helvetica, sans-serif;
    background-color: #f4f6f8;
    text-align: center;
}

h2{
    color: #2c3e50;
}

form{
    background-color: white;
    width: 300px;
    margin: auto;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
}

label{
    font-weight: bold;
}

input{
    width: 90%;
    padding: 8px;
    margin-top: 5px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="submit"]{
    background-color: #27ae60;
    color: white;
    border: none;
    cursor: pointer;
    font-weight: bold;
}

input[type="submit"]:hover{
    background-color: #1e8449;
}

</style>

</head>
<body>

<h2>Cadastrar Produto</h2>

<form action="produto" method="post">

<label>ID</label><br>
<input type="number" name="id" required>

<label>Nome</label><br>
<input type="text" name="nome" required>

<label>Preço</label><br>
<input type="number" step="0.01" name="preco" required>

<input type="submit" value="Cadastrar">

</form>

</body>
</html>