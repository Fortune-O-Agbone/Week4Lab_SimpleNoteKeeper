<%-- 
    Document   : editnote
    Created on : Jun 12, 2023, 4:47:14 AM
    Author     : Fortune Agbone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper | Edit Note</title>
    </head>
    
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>Edit Note</h2>
        
        <form method="post" action="note">
            Title: <input type="text" name="title" value="${title}"></br>
        Contents: <textarea name="contents">${contents}</textarea>
        <input type="submit" value="Save">
        </form>
    </body>
</html>
