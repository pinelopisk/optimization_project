<%@ page import="java.sql.*" %>
<%
    request.setCharacterEncoding("UTF-8"); 

   
    String am = request.getParameter("am");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");

    int q1 = Integer.parseInt(request.getParameter("question1"));
    int q2 = Integer.parseInt(request.getParameter("question2"));
    int q3 = Integer.parseInt(request.getParameter("question3"));
    int q4 = Integer.parseInt(request.getParameter("question4"));
    int q5 = Integer.parseInt(request.getParameter("question5"));
    int q6 = Integer.parseInt(request.getParameter("question6"));
    int q7 = Integer.parseInt(request.getParameter("question7"));
    int q8 = Integer.parseInt(request.getParameter("question8"));
    int q9 = Integer.parseInt(request.getParameter("question9"));
    int q10 = Integer.parseInt(request.getParameter("question10"));
    int q11 = Integer.parseInt(request.getParameter("question11"));
    int q12 = Integer.parseInt(request.getParameter("question12"));
    int q13 = Integer.parseInt(request.getParameter("question13"));
    int q14 = Integer.parseInt(request.getParameter("question14"));
    int q15 = Integer.parseInt(request.getParameter("question15"));
    int q16 = Integer.parseInt(request.getParameter("question16"));
    int q17 = Integer.parseInt(request.getParameter("question17"));
    int q18 = Integer.parseInt(request.getParameter("question18"));
    int q19 = Integer.parseInt(request.getParameter("question19"));
    int q20 = Integer.parseInt(request.getParameter("question20"));

  
    String url = "jdbc:mysql://localhost:3306/QuestionnaireDB";
    String user = "root";
    String password = "Rooney2003g"; 

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "INSERT INTO responses (am, name, surname, email, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10," 
                   + " q11, q12, q13, q14, q15, q16, q17, q18, q19, q20) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, am);
        pstmt.setString(2, name);
        pstmt.setString(3, surname);
        pstmt.setString(4, email);
        pstmt.setInt(5, q1);
        pstmt.setInt(6, q2);
        pstmt.setInt(7, q3);
        pstmt.setInt(8, q4);
        pstmt.setInt(9, q5);
        pstmt.setInt(10, q6);
        pstmt.setInt(11, q7);
        pstmt.setInt(12, q8);
        pstmt.setInt(13, q9);
        pstmt.setInt(14, q10);
        pstmt.setInt(15, q11);
        pstmt.setInt(16, q12);
        pstmt.setInt(17, q13);
        pstmt.setInt(18, q14);
        pstmt.setInt(19, q15);
        pstmt.setInt(20, q16);
        pstmt.setInt(21, q17);
        pstmt.setInt(22, q18);
        pstmt.setInt(23, q19);
        pstmt.setInt(24, q20);

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
        <h2>Η υποβολή των απαντήσεών σας ολοκληρώθηκε με επιτυχία!</h2>
        <a href="index.html">Επιστροφή στη Φόρμα</a>
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
    <h2>Υπήρξε σφάλμα κατά την αποθήκευση των απαντήσεών σας.</h2>
    <p><%= e.getMessage() %></p>
    <a href="index.html">Επιστροφή στη Φόρμα</a>
</body>
</html>
<%
    }
%>
