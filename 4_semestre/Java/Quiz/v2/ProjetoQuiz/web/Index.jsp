<%@page import="br.com.fatecpg.classes.Pessoa"%>
<%@page import="br.com.fatecpg.classes.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
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
                        out.println("Rapaz, o nome é igual mesmo");
                            
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
        <div class="container-fluid">
            <div class="jumbotron well">
                <h2> Quiz Online </h2>
		<p> Responda as perguntas e obtenha uma nota </p>
		<p> Responda várias perguntas e obtenha uma média </p>
            </div>
	</div>
		
	<div class="container-fluid" style="margin-bottom: 5%; margin-top: 5%;">
            <div class="row">
                <div class="col-sm-6">
                    <ul style="list-style-type: none; text-align: center; list-style-position:inside; display: block;">
                        <li> Responda de forma rápida. </li>
			<li> Você poderá realizar o teste quantas vezes quiser. </li>
			<li> Sua nota ficará armazenada na tabela abaixo. </li>
			<li> As perguntas serão aleatórias. </li>
                    </ul>
		</div>
		<div class="col-sm-6">
                    <form class="form-horizontal" method="POST" action="Quiz.jsp">
                        <div class="form-group">
                            <label for="nome" class="control-label col-sm-3"> Digite seu nome </label>
                            <div class="col-sm-6">
				<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required>
                            </div>
                        </div>
            		<div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6">
                                <button type="submit" name="iniciar" class="btn btn-warning" style="width:100%;">Iniciar</button>
                            </div>
			</div>
                    </form>
                </div>
            </div>
	</div>
		
            <div class="container-fluid">
                <div class="row">
                    <table class="table table-hover">
                        <tr>
                            <th> Nome </th>
                            <th> Ultima nota </th>
                            <th> Média </th>
                        </tr>
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
                        
                    </table>
		</div>
        </div>
    </body>
</html>
