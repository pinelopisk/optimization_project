<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="el">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Παρακαλώ επιλέξτε τύπο χρήστη</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: rgb(231, 218, 233);
            flex-direction: column; 
        }
        h1 {
            font-size: 28px;
            margin-bottom: 30px;
            color: #333; 
        }
        .button {
            font-size: 24px;
            padding: 20px 40px;
            margin: 20px;
            cursor: pointer;
            border: none;
            background-color: #ae0fdae0; 
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
            width: 300px;
        }
        .button:hover {
            background-color: #8b008b; 
        }
    </style>
</head>
<body>
    <h1>Παρακαλώ επιλέξτε τύπο χρήστη</h1>
    <button class="button" onclick="window.location.href='professor.jsp'">Καθηγητής</button>
    <button class="button" onclick="window.location.href='form.jsp'">Φοιτητής</button>
</body>
</html>
