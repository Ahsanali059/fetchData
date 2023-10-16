<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    HttpSession session2 = request.getSession();

    List<Map<String, String>> usersData = (List<Map<String, String>>) session.getAttribute("user_data");
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profiles</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>All Present Users</h1>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email Address</th>
                    <th>Phone Number</th>
                    <th>Username</th>
                    
                </tr>
            </thead>
            <tbody>
                <% if (usersData != null) { 
                    for (Map<String, String> user : usersData) { 
                %>
                    <tr>
                        <td><%= user.get("user_id") %></td>
                        <td><%= user.get("firstname") %></td>
                        <td><%= user.get("lastname") %></td>
                        <td><%= user.get("email") %></td>
                        <td><%= user.get("phone") %></td>
                        <td><%= user.get("username") %></td>
                    </tr>
                <% } 
                } %>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- <script src="profile.js"></script> -->
</body>
</html>
