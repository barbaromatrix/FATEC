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
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.9/font-awesome-animation.min.css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default" style="border: 0; background-color: transparent; border-bottom: 1px solid #e7e7e7">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" href="#">Quiz</a>
              </div>
              <ul class="nav navbar-nav navbar-right">
              <li ><a href="#" data-toggle="modal" data-target="#myModal"><strong>Desenvolvedores</strong></a></li>
              </ul>
            </div>
          </nav>

            <section class="row" style="border-bottom: solid 1px gainsboro; padding-bottom: 5%;">
              <div class="row">
                <div class="col-md-12">
                  <h2>Responda as questões abaixo</h2>
                </div>
              </div>
              <br>
              <form action="Index.jsp" method="POST" >
                <div class="row">
                  <%
                        Quiz.setShuffle();
                        int i = 0;
                        for (Question q : Quiz.getQuestions()) {
                  %>                  
                  <div class="col-md-3">
                    <div class="panel panel-primary">
                      <div class="panel-heading"><%= (i + 1) + ") " + q.getQuestion() %></div>
                      <div class="panel-body">
                        <div class="form-group">
                            <% 
                                for (String x : q.getAlternatives()) { 
                                    out.println("<input type='radio' name='"+ i +"' id='"+ i +"' value='"+ x +"' required>&nbsp;" + x + "<br>");
                                }
                                i++;
                            %>
                        </div>
                      </div>
                    </div>
                  </div>
                <% } %>
                </div>
                <input type='hidden' name='nome' value="<%= request.getParameter("nome") %>" />
                <div class="col-md-12">
                  <div class="form-group">
                    <button class="btn btn-danger btn-lg" name='enviar'>
                      Enviar
                    </button>
                  </div>
                </div>
              </form>
            </section>
          </div>

          <footer class="footer-fixed">
            <div class="container ">
              <div class="row">
                <div class="col-md-4">
                  Fatec Praia Grande
                </div>
                <div class="col-md-8 text-right">
                  Feito com muito amor&nbsp;
                  <span class="glyphicon glyphicon-heart faa-animated pulse" style="color: red"></span>
                </div>
              </div>
            </div>
          </footer>

          <!-- Modal -->
          <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title text-center">Desenvolvido por: </h4>
                </div>
                <div class="modal-body text-center">
                  <p>Bruno Nístico</p>
                  <p>Marcelo Henrique</p>
                  <p>Matheus Galdino</p>
                </div>
              </div>
            </div>
          </div>    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    </body>
</html>
