<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    // Ανάκτηση δεδομένων από τη φόρμα
    int arithmosOmadon = Integer.parseInt(request.getParameter("arithmos_omadon"));
    String email = request.getParameter("email");
    int foitites = Integer.parseInt(request.getParameter("foitites"));

    // Στοιχεία σύνδεσης στη βάση δεδομένων
    String url = "jdbc:mysql://localhost:3306/QuestionnaireDB";
    String user = "root"; // Αλλάξτε το αν έχετε άλλο χρήστη
    String password = "Rooney2003g"; // Βάλτε το password σας

    try {
        // Σύνδεση με τη βάση δεδομένων
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        // SQL εντολή για εισαγωγή
        String sql = "INSERT INTO professors (team, email, foitites) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Ρυθμίσεις παραμέτρων
        pstmt.setInt(1, arithmosOmadon);
        pstmt.setString(2, email);
        pstmt.setInt(3, foitites);

        // Εκτέλεση της εντολής
        pstmt.executeUpdate();
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
        }
        a:hover {
            background-color: #ae0fda90;
        }
    </style>
</head>
<body>
    <div class="message">
        <h2>Τα στοιχεία του καθηγητή αποθηκεύτηκαν με επιτυχία!</h2>
        <a href="professor.jsp">Επιστροφή στη Φόρμα</a>
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
    <a href="professor.jsp">Επιστροφή στη Φόρμα</a>
</body>
</html>
<%
    }
%>
