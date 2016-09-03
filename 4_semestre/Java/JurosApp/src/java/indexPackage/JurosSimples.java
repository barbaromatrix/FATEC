/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author barbaromatrix
 */
public class JurosSimples extends HttpServlet {

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
".bg-grey {"+
  "background-color: #f6f6f6;"+
"}"+
"footer {"
  +"position: static;"
  +"margin-top: 11.5vw;"
  + "font-weight: bold;"
  +"width: 100%;"
  + "padding: 20px;"
  + "vertical-align: center"
  +"+height: auto;"
  +"background-color: orange;"
+"}"
+"#resultadoConta {"+
  "display: block;"+
"}"+
 "li.not-active > a, li.active > a {"
+ "color: #000000;"
+ "font-weight: bold;"
+ "}"+
"</style>"+
"  </head>\n" +
"  <body>\n" +
"<nav class='navbar navbar-default' style='background-color: orange; border: none'>"+
  "<div class='container'>"+
    "<div class='navbar-header'>"+
      "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#navbar-item'>"+
        "<span class='icon-bar'></span>"+
        "<span class='icon-bar'></span>"+
        "<span class='icon-bar'></span>" +
      "</button>"+
      "<a class='navbar-brand' href='#'></a>"+
    "</div>"+
    "<div class='collapse navbar-collapse' id='navbar-item'>"+
      "<ul class='nav navbar-nav navbar-right'>"+
        "<li class='not-active'><a href='home'>INÍCIO</a></li>"+
        "<li class='active'><a href='juros-simples'>JUROS SIMPLES</a></li>"+
        "<li class='not-active'><a href='juros-composto'>JUROS COMPOSTO</a></li>"+
      "</ul>"+
    "</div>"+
  "</div>"+
"</nav>"+
"<div class='container'>"+
"<span id='juros-definition'>"+
  "<div class='row'>"+
    "<div class='col-md-5 text-center'>"+
      "<h2>Juros Simples</h2>"+
      "<p style='text-align: justify'>"+
      "O juros é definido como simples rendimento de uma aplicação financeira referente ao atraso no pagamento de uma prestação ou quantia paga por empréstimo de um valor capital."+
  "Durante o período em que são gerados novos juros, os mesmos não são aplicados aos valores antigos. Colocando em fórmulas, o <strong>Juros</strong> é definido pelo valor principal(também entendido como <strong>Capital</strong>), que se interage com a <strong>taxa de juros</strong>, que interage com a <strong>quantidade de tempo</strong>.</p>"+
      
      "<p style='text-align: justify'>Após calcular o valor de juros, também é possível que calculemos o <strong>montante</strong>( ou valor total), em que aplicamos o valor de juros com o <strong>Capital</strong>, interagindo junto à <strong>taxa de juros</strong> encontrada aproximando a aplicação real dos valores. Podem ser determinadas através das fórmulas: </p>"+
      
      "<h4><kbd>Juros = Capital(PV) * taxa de juros ( i / 100 ) * tempo de aplicação (n)</kbd></h4>"+
      "<h4><kbd>Montante = PV * ( 1 + ( i * n ) )</kbd></h4>"+
    "</div>"+
    "<div class='col-md-1'></div>"+
    "<div class='col-md-1'></div>"+
    "<div class='col-md-5'>"+
    "<div class='row'>"+
        "<h2 class='text-center'>Gostaria de tentar?</h2>"+
      "<form action='juros-simples' method='POST'>"+
        "<div class='form-group'>"+
          "<label for='vl_base'>Valor inicial: </label>"+
          "<input required type='number' min='1' name='vl_base' id='vl_base' maxlength='50' placeholder='1'  class='form-control' />"+
        "</div>"+
        "<div class='form-group'>"+
          "<label for='vl_juros'>Juros aplicado: </label>"+
          "<input type='number' min='0' max='100' required id='vl_juros' name='vl_juros' maxlength='3' class='form-control' />"+
        "</div>"+        
"        <div class='form-group'>\n" +
"          <div class='row'>\n" +
"            <div class='col-md-6'>\n" +
"              <label for='qt_tempo'>Tempo aplicado </label>\n" +
"              <input type='number' min='1' required name='qt_tempo' id='qt_tempo' class='form-control'  />\n" +
"            </div>\n" +
"            <div class='col-md-6'>\n" +
"              <label for='qt_tempo'>Tempo base: </label>\n" +
"              <select name='po' id='po' class='form-control'>\n" +
"                <option value='dia'>Dia(s)</option>\n" +
"                <option value='mes'>Mês(meses)</option>\n" +
"                <option value='ano'>Ano(s)</option>\n" +
"              </select>\n" +
"            </div>\n" +
"          </div>\n" +
        "</div>"+
"        <div class='form-group'>"+
"           <label for=''>Tempo desejado: </label>"+
"<select name='apt' id='apt' class='form-control'>\n" +
"            <option value='dia'>\n" +
"              Ao dia (a.d)\n" +
"            </option>\n" +
"            <option value='mes'>\n" +
"              Ao mês (a.m)\n" +
"            </option>\n" +
"            <option value='ano'>\n" +
"              Ao Ano (a.a)\n" +
"            </option>\n" +
"          </select>"+
"        </div>"+
        "<div class='form-group'>"+
          "<button class='btn btn-primary'>"+
            "Calcular"+
          "</button>"+
        "</div>"+
      "</form>"+
    "</div>"+
  "</div>"+
  "</div>"+
"</span>");

if( request.getParameter( "vl_base" ) != null && request.getParameter( "vl_juros" ) != null && request.getParameter( "qt_tempo" ) != null && request.getMethod().equals("POST") )
{
    if( !hasRegex(request.getParameter( "vl_base" ), "[a-zA-z]") && !hasRegex(request.getParameter( "vl_juros" ), "[a-zA-z]") && !hasRegex(request.getParameter( "qt_tempo" ), "[a-zA-z]") && !hasRegex(request.getParameter( "po" ), "[0-9]") && !hasRegex(request.getParameter( "apt" ), "[0-9]") )
    {
        
        
        double n = Double.parseDouble( request.getParameter("qt_tempo") );
    
        if( !request.getParameter("po").equals(request.getParameter("apt")) )
            n = conversor( request.getParameter("po"),  Double.parseDouble( request.getParameter( "qt_tempo" ) ), request.getParameter("apt") );

        out.println("<div class='alert alert-info fade in text-center'>");
        out.println("  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
          out.println("<h2>Seu resultado</h2>");
          out.println("<p>Mediante uma taxa de "+ request.getParameter("vl_juros") + "%, você possui: </p><p>Juros: ");
          out.printf("R$ %.2f", calculaJuros( Double.parseDouble( request.getParameter( "vl_base" ) ), Double.parseDouble(request.getParameter( "vl_juros" )), n ) );
          out.println("</p><p>Montante: ");
          out.printf("R$ %.2f", calculaMontante(Double.parseDouble( request.getParameter("vl_base") ), Double.parseDouble( request.getParameter("vl_juros") ), n ));
          out.println("</p></div>");
        
    } else {
        
        out.println("<div class='alert alert-danger fade in'>"+
            "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>"+
            "<strong>Por favor, utilize apenas números nos campos.</strong> "+
        "</div>");
        
    }
    
}

out.println("</div>"+
"<footer>"+
"  <div class='container text-center'>\n" +
"    <p>Fatec Praia Grande - Análise e Desenvolvimento de Sistemas / 2016</p>\n" +
"  </div>\n" +
"</footer>"+
"    <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>\n" +
"<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"+
"  </body>\n" +
"</html>");
            
            out.close();
        }
    }
    
    public double calculaJuros( Double capital, Double taxa, double tempo )
    {
        return ( capital * (taxa/100) * tempo );
    }
    
    public double calculaMontante( double Capital, double taxa, double tempo )
    {
         return (Capital * ( 1 + ( (taxa/100) * tempo ) ) );
    }
    
 
    public double conversor( String po , double n  , String apt)
    {
        if (po.equals("dia") && apt.equals("mes")) // transforma x dias em y mês
            return (n / 30);
        
        else if (po.equals("dia") && apt.equals("ano")) // transforma x dias em y mês
            return (n / 365);
        
        else if (po.equals("mes") && apt.equals("dia")) // transforma x mês em y dias
            return (n * 30);
        
        else if (po.equals("mes") && apt.equals("ano")) // transforma x meses em y anos
            return (n / 12);
        
        else if (po.equals("ano") && apt.equals("dia")) // transforma x anos em y dias
            return (n * 365);
        
        else if (po.equals("ano") && apt.equals("mes")) // transforma x anos em y mes
            return (n * 12);
        
        else
            return n;
    }
    
    public boolean hasRegex( String contexto, String pattern )
    {
        Pattern p = Pattern.compile( pattern );
        Matcher m = p.matcher(contexto);
        return m.find();
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
