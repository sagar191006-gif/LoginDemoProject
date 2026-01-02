<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>

    <style>
        body {
            font-family: Arial;
            text-align: center;
            margin-top: 100px;
        }

        .logout {
            color: red;
            font-weight: bold;
        }
    </style>
</head>

<body>

<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        request.setAttribute("error", "Session expired! Please login again.");
        RequestDispatcher rd = request.getRequestDispatcher("Login.html");
        rd.forward(request, response);
        return;
    }
%>

<h2>Welcome, <%= username %>!</h2>
<p>You are successfully logged in.</p>

<a href="logout" class="logout">Logout</a>

</body>
</html>
