<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="GroupifyJava.Kmeans" %>
<!DOCTYPE html>
<html lang="el">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Αλγόριθμος K-Means</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e7dae9;
            margin: 20px;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        .container {
            max-width: 800px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: left;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        h2 {
            color: #28a745;
        }
        h2.error {
            color: #dc3545;
        }
        p {
            margin: 10px 0;
        }
        strong {
            font-weight: bold;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #000;
            background-color: #ae0fdae0;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            text-align: center;
        }
        a:hover {
            background-color: #ae0fda90;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Εκτέλεση Αλγορίθμου K-Means</h1>
        <%
            String results = Kmeans.executeKMeans();
            String[] lines = results.split("\n");

            for (String line : lines) {
                if (line.startsWith("Team results:")) {
                    out.println("<p><strong>" + line + "</strong></p>");
                } else if (line.startsWith("Total teams:")) {
                    out.println("<p><strong>" + line + "</strong></p>");
                } else if (line.startsWith("team ")) {
                    int colonIndex = line.indexOf(":");
                    if (colonIndex != -1) {
                        String teamLabel = line.substring(0, colonIndex + 1);
                        String members = line.substring(colonIndex + 1);
                        out.println("<p><strong>" + teamLabel + "</strong>" + members + "</p>");
                    } else {
                        out.println("<p><strong>" + line + "</strong></p>");
                    }
                } else {
                    out.println("<p>" + line + "</p>");
                }
            }
        %>
        <a href="Index.jsp">Επιστροφή στην Αρχική Σελίδα</a>
    </div>
</body>
</html>
