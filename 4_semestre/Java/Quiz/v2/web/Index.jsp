<%@page import="br.com.fatecpg.classes.Pessoa"%>
<%@page import="br.com.fatecpg.classes.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.9/font-awesome-animation.min.css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/style.css">
	<style>
		th, td{ text-align: center;}
	</style>
        
        <title>Index</title>
    </head>
    <body>
        <%
            if(request.getParameter("enviar") != null)
            {                
                String[] answers = new String[Quiz.getQuestions().size()];
                
                for(int k = 0; k < Quiz.getQuestions().size(); k++)
                    answers[k] = request.getParameter("" + k);
                
                double dGrade = Quiz.validateQuiz(answers);
                
                String nome = request.getParameter("nome");

                int iIndex = -1;

                for(int i = 0; i < Quiz.getPessoas().size(); i++)
                {
                    Pessoa p = Quiz.getPessoas().get(i);

                    if(p.getNome().equals(nome))
                    {
                        // rapaz, a pessoa é a mesma
                        iIndex = i;

                        break;
                    }
                }

                if( iIndex >= 0 )
                {                        
                    Pessoa p = Quiz.getPessoas().get(iIndex);

                    p.setTestCount(p.getTestCount() + 1);
                    p.setGradeSum(p.getGradeSum() + dGrade);
                    p.setLastGrade(dGrade);
                    p.setNome(nome);

                    Quiz.getPessoas().remove(iIndex);
                    Quiz.getPessoas().add(p);
                }
                else 
                {
                    Pessoa p = new Pessoa();

                    p.setTestCount(1);
                    p.setGradeSum(dGrade);
                    p.setLastGrade(dGrade);
                    p.setNome(nome);

                    Quiz.getPessoas().add(p);
                }
            }
        %>
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
  
  <div class="jumbotron text-center">
    <h1>Você consegue acertar?</h1>
    <h3>batat batat batat batat </h3>
  </div>
            
   <%
            if(request.getParameter("enviar") != null)
            {                
                String[] answers = new String[Quiz.getQuestions().size()];
                
                for(int k = 0; k < Quiz.getQuestions().size(); k++)
                    answers[k] = request.getParameter("" + k);
                
                double dGrade = Quiz.validateQuiz(answers);
                
                String nome = request.getParameter("nome");

                int iIndex = -1;

                for(int i = 0; i < Quiz.getPessoas().size(); i++)
                {
                    Pessoa p = Quiz.getPessoas().get(i);

                    if(p.getNome().equals(nome))
                    {
                        // rapaz, a pessoa é a mesma
                        out.println(
                                "<div class='alert alert-success alert-dismissible'>"+
                                "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"+
                                "<strong>Parabéns "+ nome + "! Sua nota foi alterada com sucesso!.</strong></div>"
                        );
                        iIndex = i;

                        break;
                    }
                }

                if( iIndex >= 0 )
                {                        
                    Pessoa p = Quiz.getPessoas().get(iIndex);

                    p.setTestCount(p.getTestCount() + 1);
                    p.setGradeSum(p.getGradeSum() + dGrade);
                    p.setLastGrade(dGrade);
                    p.setNome(nome);

                    Quiz.getPessoas().remove(iIndex);
                    Quiz.getPessoas().add(p);
                }
                else 
                {
                    Pessoa p = new Pessoa();

                    p.setTestCount(1);
                    p.setGradeSum(dGrade);
                    p.setLastGrade(dGrade);
                    p.setNome(nome);

                    Quiz.getPessoas().add(p);
                }
            }
        %>
  
  <section class="row" style="border-bottom: solid 1px gainsboro; padding-bottom: 5%;">
    <div class="col-md-6 text-center">
      <div class="row">
        <div class="col-md-12 text-center">
          <h3>Como participar?</h3>
        </div>
        <div class="col-md-12 text-center">
          <p>Responsa de forma acertiva. Uma pergunta gera uma nota, um conjunto gera uma média.</p>
        </div>
      </div>
    </div>
    <div class="col-md-6" style="border-left: solid 0.5px gainsboro">
      <div class="row">
        <div class="col-md-12 text-center">
          <h3>Vamos lá?</h3>
        </div>
      </div>
      <form method="POST" action="Quiz.jsp">
        <div class="form-group">        
          <input type="text" class="form-control" id="nome" name="nome" placeholder="Maria Ricarda Joaquina da Silva Rhee" required />
        </div>
        <div class="form-group">
          <div class="col-sm-offset-3 col-sm-6">
            <button type="submit" name="iniciar" class="btn btn-warning faa-vertical animated" style="width:100%;">Iniciar</button>
          </div>
        </div>
      </form>
    </div>
  </section>
  
  <section style="margin-top: 3%;">
    <div class="row">
      <div class="col-md-12 text-center">
        <h2><strong>Resultados</strong></h2>
      </div>
      <div class="col-md-12">
        <table class="table">
      <thead>
        <tr>
          <th class="text-center">Nome</th>
          <th class="text-center">Última nota</th>
          <th class="text-center">Média</th>
        </tr>
      </thead>
      <tbody>
        <%
                            String sOut = "";
                            
                            for(int i = 0; i < Quiz.getPessoas().size(); i++)
                            {
                                Pessoa p = Quiz.getPessoas().get(i);
                                
                                sOut += "<tr>";
                                sOut += "<td>" + p.getNome() + "</td>";
                                sOut += "<td>" + p.getLastGrade() + "</td>";
                                sOut += "<td>" + p.getGradeAverage() + "</td>";
                                sOut += "</tr>";
                            }
                            
                            out.println(sOut);
                        %>
      </tbody>
    </table>
      </div>
    </div>
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
        <span class="glyphicon glyphicon-heart faa-pulse animated" style="color: red"></span>
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
</body>
</html>
