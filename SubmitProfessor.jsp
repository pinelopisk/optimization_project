<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    String fullname = request.getParameter("fullname");
    int arithmos_atomwn = Integer.parseInt(request.getParameter("arithmos_atomwn"));
    String email = request.getParameter("email");
    int foitites = Integer.parseInt(request.getParameter("foitites"));

    String url = "jdbc:mysql://localhost:3306/QuestionnaireDB";
    String user = "root"; 
    String password = "Rooney2003g"; 

    int totalEntries = 0;
    int totalStudents = 0; 

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        String countQuery = "SELECT COUNT(*) AS total_entries FROM responses";
        Statement countStmt = conn.createStatement();
        ResultSet countRs = countStmt.executeQuery(countQuery);

        if (countRs.next()) {
            totalEntries = countRs.getInt("total_entries");
        }

        String studentCountQuery = "SELECT COUNT(DISTINCT am) AS total_students FROM responses";
        Statement studentCountStmt = conn.createStatement();
        ResultSet studentCountRs = studentCountStmt.executeQuery(studentCountQuery);

        if (studentCountRs.next()) {
            totalStudents = studentCountRs.getInt("total_students");
        }

        String sql = "INSERT INTO professors (fullname, email, foitites, arithmos_atomwn) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, fullname);  
        pstmt.setString(2, email);
        pstmt.setInt(3, foitites);
        pstmt.setInt(4, arithmos_atomwn);

        pstmt.executeUpdate();

        countRs.close();
        countStmt.close();
        studentCountRs.close();
        studentCountStmt.close();
        pstmt.close();
        conn.close();
%>
<!DOCTYPE html>
<html lang="el">
<head>
    <meta charset="UTF-8">
    <title>Επιτυχία</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #e7dae9;
        }
        .message {
            max-width: 600px;
            margin: auto;
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .message h2 {
            color: #333;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            color: #000;
            text-decoration: none;
            background-color: #ae0fdae0;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
        }
        a:hover {
            background-color: #ae0fda90;
        }
        
        button[type="submit"] {
            display: inline-block;
            margin-top: 20px;
            color: #000; 
            background-color: #ae0fdae0;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            width: 256px; 
            
        }
        button[type="submit"]:hover {
            background-color: #ae0fda90;
        }
    </style>
</head>
<body>
    <div class="message">
        <h2>Τα στοιχεία του καθηγητή αποθηκεύτηκαν με επιτυχία!</h2>
        <h2>Σύνολο μαθητών που έχουν συμπληρώσει τη φόρμα: <%= totalStudents %></h2>

        <form action="Kmeans.jsp" method="post">
            <button type="submit" name="startKMeans">Χωρισμός σε Ομάδες</button>
        </form>

        <a href="Index.jsp">Επιστροφή στην αρχική σελίδα</a>
    </div>
</body>
</html>
<%
    } catch (Exception e) {
        e.printStackTrace();
%>
<!DOCTYPE html>
<html lang="el">
<head>
    <meta charset="UTF-8">
    <title>Σφάλμα</title>
</head>
<body>
    <h2>Υπήρξε σφάλμα κατά την αποθήκευση των στοιχείων του καθηγητή.</h2>
    <p><%= e.getMessage() %></p>
    <a href="Index.jsp">Επιστροφή στην αρχική σελίδα</a>
</body>
</html>
<%
    }
%>
