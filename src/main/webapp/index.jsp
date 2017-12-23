<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="moe.ijnji.MoeApp" %>
<html>
<head>
  <link href="https://fonts.googleapis.com/css?family=Marmelad" rel="stylesheet" tpe="text/css">
  <title>Moe App GAE Standard Java 8</title>
</head>
<body>
  <h1>Hello Moe App on GAE using Java 8!</h1>
  <p><%= MoeApp.getInfo() %></p>
  <table>
    <tr>
      <td colspan="2" style="font-weight:bold;">Available Servlets:</td>
    </tr>
    <tr>
      <td><a href="/hello">Hello Moe App</a></td>
    </tr>
  </table>
</body>
</html>