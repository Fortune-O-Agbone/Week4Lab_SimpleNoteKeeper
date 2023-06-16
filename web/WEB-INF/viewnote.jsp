<%-- 
    Document   : viewnote
    Created on : Jun 12, 2023, 4:47:03 AM
    Author     : Fortune Agbone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper | View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>View Note</h2>
        
        <h3>Title: ${title}</h3>
        
        <h3>Contents:</h3>
        <p>${contents}</p>
        
        <a href="note?edit">Edit Note</a>
    </body>
</html>
