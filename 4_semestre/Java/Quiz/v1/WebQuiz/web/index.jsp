<%@page import="com.exemplo.quiz.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (request.getParameter("userTest") != null) {
        String answers[] = {
            request.getParameter("0"),
            request.getParameter("1"),
            request.getParameter("2"),
            request.getParameter("3"),
            request.getParameter("4"),
            request.getParameter("5")
        };
        Quiz.validateTest(answers);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Quiz</title>
    </head>
    <body>
        <div>
            <h1>Web Quiz</h1>
            <h2>Inicio</h2>
            <hr>
            <h3>Ultima nota: <%= Quiz.getLastGrade() + "%"%></h3>
            <hr>
            <h3>Media: <%= Quiz.getGradeAverage()%> </h3>
            <hr>

            <a href="teste.jsp"><button>Iniciar Teste</button></a>

        </div>
    </body>
</html>
