<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.fatecpg.classes.Question"%>
<%@page import="br.com.fatecpg.classes.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if( request.getParameter("nome") == null) {
        response.sendRedirect("Index.jsp");
    }
    
    Quiz.addToQuiz();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Teste </h1>
        <form action="Index.jsp" method="POST">
            <%
                Quiz.setShuffle();
                int i = 0;
                for (Question q : Quiz.getQuestions()) {%>
                <label for="<%= i %>"><%= (i+1) + ") " + q.getQuestion()%></label><br>
                <% 
                    for (String x : q.getAlternatives()) {
                        out.println("<input type='radio' name='"+ i +"' id='"+ i +"' value='"+ x +"' required>" + x + "<br>");
                    }
                %>
                <% 
                    i++;
                }
            %>
            <input type='hidden' name='nome' value="<%= request.getParameter("nome") %>" />
            <button type='submit' name='enviar' class='btn btn-warning btn-blocking'>Enviar</button>
        </form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    </body>
</html>
