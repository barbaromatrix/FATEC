/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author barbaromatrix
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>\n" +
"<html >\n" +
"  <head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <title>Trabalho OOP - Servlet/juros-simples</title>\n" +
"    	<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>\n" +
"		<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Lato'>\n" +
"<style>"+
".navbar > li {"+
  "font-family: 'Lato', cursive;"+
"}"+
".jumbotron-span {"+
  "height: 35vw;"+
  "background-color: orange !important;"+
"}"+
".nav li > a {"+
"color: white;"+
""+
"}"+
 "li.not-active > a, li.active > a {"
+ "color: #000000;"
+ "font-weight: bold;"
+ "}"+
".jumbotron-description {"+
  "position: relative;"+
  "top: 35%;"+
  "bottom: 65%;"+
"}"+

".item-shadow{"+
  "border: 1px solid transparent; "+
    "border-radius:0;"+
  "transition: box-shadow 0.5s;"+
"}"+

".item-shadow:hover {"+
 " box-shadow: 5px 0px 40px rgba(0,0,0, .2);"+
"}"+

".bg-grey {"+
  "background-color: #f6f6f6;"+
"}"+
"</style>"+
"  </head>\n" +
"  <body>\n" +
"    <nav class=\"navbar navbar-default navbar-fixed-top\" style=\"background-color: orange; border: none\">\n" +
"	  <div class=\"container\">\n" +
"	    <div class=\"navbar-header\">\n" +
"	      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-item\">\n" +
"	        <span class=\"icon-bar\"></span>\n" +
"	        <span class=\"icon-bar\"></span>\n" +
"	        <span class=\"icon-bar\"></span> \n" +
"	      </button>\n" +
"	      <a class=\"navbar-brand\" href=\"#\"></a>\n" +
"	    </div>\n" +
"	    <div class=\"collapse navbar-collapse\" id=\"navbar-item\">\n" +
"	      <ul class=\"nav navbar-nav navbar-right\">\n" +
"	        <li class='not-active'><a href=\"home\">INÍCIO</a></li>\n" +
"	        <li class='not-active'><a href=\"juros-simples\">JUROS SIMPLES</a></li>\n" +
"	        <li class='not-active'><a href=\"juros-composto\">JUROS COMPOSTO</a></li>\n" +
"	      </ul>\n" +
"	    </div>\n" +
"	  </div>\n" +
"	</nav>\n" +
"	<span>\n" +
"	  <div class=\"jumbotron text-center jumbotron-span\" >\n" +
"	    <div class='jumbotron-description'>\n" +
"	       <h1>Trabalho de POO - Servlet</h1>\n" +
"	      <p>Juros é a roda do Brasil</p>\n" +
"	    </div>\n" +
"	  </div>\n" +
"	</span>\n" +
"	<div class=\"container\" style=\"margin-top: 5vw !important\">\n" +
"	  <section id='sobreJuros' style='margin-top: 1%'>\n" +
"	    <div class=\"row text-center\">\n" +
"	      <h2>Sobre Juros</h2>\n" +
"	    </div>\n" +
"	    <div class=\"row\">\n" +
"	      <div class=\"col-md-6 text-center\">\n" +
"	        <h3 class='text-center'>Juros Simples</h3>\n" +
"	        <p style='text-align: center'>Sendo utilizados nas situações de curto prazo, os juros simples não são tão utilizados a capitalização baseada no regime simples, mas, de qualquer forma, é utilizado com referência à <strong>atrasos de pagamento ou prestação de fatura</strong>.</p>\n" +
"	        <a href=\"juros-simples\" class=\"btn btn-primary text-center\"><strong>Fazer uma simulação!</strong></a>\n" +
"	      </div>\n" +
"	      <div class=\"col-md-6 text-center\">\n" +
"	        <h3 class='text-center'>Juros Compostos</h3>\n" +
"	        <p style='text-align: center'>Através desse modelo de investimento, as modalidades de investimentos e financiamentos são calculadas, visto que através deste, é oferecido um maior rendimento, consequentemente <strong>originando mais lucro</strong>.</p>\n" +
"	        <a href=\"juros-composto\" class=\"btn btn-primary text-center\"><strong>Fazer uma simulação!</strong></a>\n" +
"	      </div>\n" +
"	    </div>\n" +
"	  </section>\n" +
"	</div>\n" +
"	<div class=\"container-fluid bg-grey\" style=\"margin-top: 5vw !important\">\n" +
"	  <section id=\"equipe\" style='margin-top: 1%; padding: 10px 10px'>\n" +
"	    <div class=\"row text-center\">\n" +
"	      <h2>Equipe</h2>\n" +
"	    </div>\n" +
"	    <div class=\"row\">\n" +
"	      <div class=\"col-md-4 text-center item-shadow\">\n" +
"	       <!-- Andrei -->\n" +
"	        <img src=\"images/Imagem1.png\" alt=\"Savage Capitain\" style='text-align: center; max-width: 16vw; width: 100%; height: auto; margin-bottom: 1vw' />\n" +
"	        <h3 class=\"text-center\">\n" +
"	          (Capitão) Andrei\n" +
"	        </h3>\n" +
"	        <p style='text-align: justify'>Formado no curso de Informática pela ETEC Mongaguá, estudante de Análise e Desenvolvimento de Sistemas na Fatec Praia Grande. Nas horas vagas gosto de ler e assistir filmes e séries. <strong>Documentador (ABNT <3 )</strong>.</p>\n" +
"	      </div>\n" +
"	      <div class=\"col-md-4 text-center item-shadow\">\n" +
"	       <!-- Diogo -->\n" +
"	        <img src=\"http://image.flaticon.com/icons/svg/145/145845.svg\" alt=\"Mestre android\" style='text-align: center; max-width: 16vw; width: 100%; height: auto; margin-bottom: 1vw' data-toggle=\"tooltip\" title=\"Hooray!\" />\n" +
"	        <h3 class=\"text-center\">\n" +
"	          Diogo\n" +
"	        </h3>\n" +
"	        <p style='text-align: justify'>Formado na ETEC Dra. Ruth Cardoso (SV), sou <strong>programador Android</strong>, amante de java, estudante de Análise e Desenvolvimento de Sistemas na Fatec de Praia Grande. Nas horas vagas, passo o tempo lendo sobre como ser o melhor e assisto jogos de futebol e séries. Android > IOS</p>\n" +
"	      </div>\n" +
"	      <div class=\"col-md-4 text-center item-shadow\">\n" +
"	       <!-- Galdino -->\n" +
"	        <img src=\"http://image.flaticon.com/icons/svg/145/145848.svg\" alt=\"Mais ou menos como o galdino parece (desconsiderar a grande quantidade de cabelo)\" style='text-align: center; max-width: 16vw; width: 100%; height: auto; margin-bottom: 1vw' />\n" +
"	        <h3 class=\"text-center\">\n" +
"	          (Matheus) Galdino\n" +
"	        </h3>\n" +
"	        <p style='text-align: justify'>Formado no curso de informática pela ETEC São Vicente, sou <strong>programador JAVA e PHP</strong>, estudante de Análise e Desenvolvimento de Sistemas na Fatec Praia Grande, bem calvo e enrolo demais para terminar uma série que não envolve programação. É quase calvo e adora caronas.</p>\n" +
"	      </div>\n" +
"	    </div>\n" +
"	  </section>\n" +
"	</div>\n" +
"<footer class='navbar-default' style='background-color: orange'>\n" +
"  <div class='container text-center'>\n" +
"    <p>Fatec Praia Grande - Análise e Desenvolvimento de Sistemas / 2016</p>\n" +
"  </div>\n" +
"</footer>"+
"    <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>\n" +
"  </body>\n" +
"</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
