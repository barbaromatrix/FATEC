package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.fatecpg.classes.Pessoa;
import br.com.fatecpg.classes.Quiz;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\t\t\n");
      out.write("\t<style>\n");
      out.write("\t\tth, td{ text-align: center;}\n");
      out.write("\t</style>\n");
      out.write("        \n");
      out.write("        <title>Index</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if(request.getParameter("enviar") != null)
            {                
                String[] answers = new String[Quiz.getQuestions().size()];
                
                for(int k = 0; k < Quiz.getQuestions().size(); k++)
                    answers[k] = request.getParameter("" + k);
                
                double dGrade = Quiz.validateQuiz(answers);
                String nome = request.getParameter("nome");
                
                try{
                    int iIndex = 0;

                    for(int i = 0; i < Quiz.getPessoas().size(); i++)
                    {
                        Pessoa p = Quiz.getPessoas().get(i);

                        if(p.getNome().equals(nome))
                        {
                            iIndex = i;

                            break;
                        }
                    }

                    if( iIndex >= 0 )
                    {
                        out.println("CHEGUEI NO IF DO IINDEX: " + iIndex);
                        
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
                        out.println("CHEGUEI NO ELSE COM iIndex: " + iIndex);
                        Pessoa p = new Pessoa();

                        p.setTestCount(1);
                        p.setGradeSum(dGrade);
                        p.setLastGrade(dGrade);
                        p.setNome(nome);

                        Quiz.getPessoas().add(p);
                    }
                }
                catch(Exception e){ out.print(e.getMessage()); }
            }
        
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"jumbotron well\">\n");
      out.write("                <h2> Quiz Online </h2>\n");
      out.write("\t\t<p> Responda as perguntas e obtenha uma nota </p>\n");
      out.write("\t\t<p> Responda várias perguntas e obtenha uma média </p>\n");
      out.write("            </div>\n");
      out.write("\t</div>\n");
      out.write("\t\t\n");
      out.write("\t<div class=\"container-fluid\" style=\"margin-bottom: 5%; margin-top: 5%;\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-6\">\n");
      out.write("                    <ul style=\"list-style-type: none; text-align: center; list-style-position:inside; display: block;\">\n");
      out.write("                        <li> Responda de forma rápida. </li>\n");
      out.write("\t\t\t<li> Você poderá realizar o teste quantas vezes quiser. </li>\n");
      out.write("\t\t\t<li> Sua nota ficará armazenada na tabela abaixo. </li>\n");
      out.write("\t\t\t<li> As perguntas serão aleatórias. </li>\n");
      out.write("                    </ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("                    <form class=\"form-horizontal\" method=\"get\" action=\"Quiz.jsp\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"nome\" class=\"control-label col-sm-3\"> Digite seu nome </label>\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"nome\" name=\"nome\" placeholder=\"Nome\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("            \t\t<div class=\"form-group\">\n");
      out.write("                            <div class=\"col-sm-offset-3 col-sm-6\">\n");
      out.write("                                <button type=\"submit\" name=\"iniciar\" class=\"btn btn-warning\" style=\"width:100%;\">Iniciar</button>\n");
      out.write("                            </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\t</div>\n");
      out.write("\t\t\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th> Nome </th>\n");
      out.write("                            <th> Ultima nota </th>\n");
      out.write("                            <th> Média </th>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                    </table>\n");
      out.write("\t\t</div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
