<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.exemplo.quiz.Quiz"%>
<%@page import="com.exemplo.quiz.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Quiz - Teste</title>
    </head>
    <body>
        
        <h1>WebQuiz</h1>
        <h2>Teste</h2>
        <form action="index.jsp">
            <% ArrayList<Question> test = Quiz.getTest();
            List<Question> teste = test.subList(0, 5);
            
            Collections.shuffle(test);
            %>
            
            <% for (Question q : teste) {%>
            
            <h3><%= q.getQuestion()%></h3>
            <input type="radio"
                   name="<%= test.indexOf(q)%>"
                   value="<%= q.getAlternatives()[0]%>"/>
                   <%= q.getAlternatives()[0]%>

                   <input type="radio"
                   name="<%= test.indexOf(q)%>"
                   value="<%= q.getAlternatives()[1]%>"
                   />
                   <%= q.getAlternatives()[1]%>

                   <input type="radio"
                   name="<%= test.indexOf(q)%>"
                   value="<%= q.getAlternatives()[2]%>"/>
                   <%= q.getAlternatives()[2]%>
                   <input type="radio"
                   name="<%= test.indexOf(q)%>"
                   value="<%= q.getAlternatives()[3]%>"/>
                   <%= q.getAlternatives()[3]%>
                   <% }%>
                   <input type="submit" name="userTest" value="confirmar"/>
        </form>
    </body>
</html>
