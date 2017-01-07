<%@page import="br.com.fatecpg.classes.Question"%>
<%@page import="br.com.fatecpg.classes.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
        
        <link rel="stylesheet" href="build.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        

    </head>
    <body>
    <center><h1> Teste </h1></center>
        <div class ="col-md-4">col md 4</div>
        <div class ="col-md-6" style="border: 2px solid black;">
        <form action="Index.jsp" method="get">
            <%
                if(request.getParameter("iniciar") != null)
                {
                    String sOut = "";

                    if(Quiz.getQuestions().size() <= 0 )
                        Quiz.addToQuiz();

                    Quiz.setShuffle();

                    for(int i = 0; i < Quiz.getQuestions().size(); i++)
                    {
                        Question q = Quiz.getQuestions().get(i);

                        sOut += "<label>" + q.getQuestion() +"</label><br>";

                        for(int j = 0; j < q.getAlternatives().length; j++)
                            sOut += "<input type='radio' id='Radios1' name='" + i + "' value='" + q.getAlternatives()[j].toString() +"' required>" + q.getAlternatives()[j].toString();

                        sOut += "<br>";
                    }

                    sOut += "<input type='hidden' name='nome' value='" + request.getParameter("nome") + "'>";
                    sOut += "<button type='submit' name='enviar'>Enviar</button>";

                    out.println(sOut);
                }
            %>
            </form>
        </div>
        <div class ="col-md-2">col md 2</div>
    </body>
</html>
