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
public class JurosCompostoServlet extends HttpServlet {

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

            out.println("<!DOCTYPE html>\n"
                    + "<html >\n"
                    + "  <head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <title>Trabalho OOP - Servlet/juros-simples</title>\n"
                    + "    	<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>\n"
                    + "		<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Lato'>\n"
                    + "<style>"
                    + ".bg-grey {"
                    + "background-color: #f6f6f6;"
                    + "}"
                    +"footer {"
  +"position: static;"
  +"margin-top: 11.5vw;"
  + "font-weight: bold;"
  +"width: 100%;"
  + "padding: 10px;"
  + "vertical-align: center"
  +"+height: auto;"
  +"background-color: orange;"
+"}"
                    + "#resultadoConta {"
                    + "display: block;"
                    + "}"
                    + "li.not-active > a, li.active > a {"
                    + "color: #000000;"
                    + "font-weight: bold;"
                    + "}"
                    + "</style>"
                    + "  </head>\n"
                    + "  <body>\n"
                    + "<nav class='navbar navbar-default ' style='background-color: orange; border: none'>\n"
                    + "  <div class='container'>\n"
                    + "    <div class='navbar-header'>\n"
                    + "      <button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#navbar-item'>\n"
                    + "        <span class='icon-bar'></span>\n"
                    + "        <span class='icon-bar'></span>\n"
                    + "        <span class='icon-bar'></span> \n"
                    + "      </button>\n"
                    + "      <a class='navbar-brand' href='#'></a>\n"
                    + "    </div>\n"
                    + "    <div class='collapse navbar-collapse' id='navbar-item'>\n"
                    + "      <ul class='nav navbar-nav navbar-right'>\n"
                    + "        <li class='not-active'><a href='home'>INÍCIO</a></li>\n"
                    + "        <li class='not-active'><a href='juros-simples'>JUROS SIMPLES</a></li>\n"
                    + "        <li class='active'><a href='juros-composto'>JUROS COMPOSTO</a></li>\n"
                    + "      </ul>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</nav>\n"
                    + "<div class='container'>\n"
                    + "<span id='juros-definition'>\n"
                    + "  <div class='row'>\n"
                    + "    <div class='col-md-5'>\n"
                    + "      <div class='row'>\n"
                    + "        <h2 class='text-center'>Gostaria de tentar?</h2>\n"
                    + "      <form action='juros-composto' method='POST'>\n"
                    + "        <div class='form-group'>\n"
                    + "          <label for='vl_base'>Valor inicial: </label>\n"
                    + "          <input required type='number' min='0' name='vl_base' id='vl_base' maxlength='50' placeholder='1' class='form-control' />\n"
                    + "        </div>\n"
                    + "        <div class='form-group'>\n"
                    + "          <label for='vl_juros'>Juros aplicado: </label>\n"
                    + "          <input type='text' min='0' max='100' required id='vl_juros' name='vl_juros' maxlength='3' class='form-control' />\n"
                    + "        </div>\n"
                    + "        <div class='form-group'>\n"
                    + "          <div class='row'>\n"
                    + "            <div class='col-md-6'>\n"
                    + "              <label for='qt_tempo'>Tempo aplicado </label>\n"
                    + "              <input type='number' min='0' required name='qt_tempo' id='qt_tempo' class='form-control'  />\n"
                    + "            </div>\n"
                    + "            <div class='col-md-6'>\n"
                    + "              <label for='qt_tempo'>Tempo base</label>\n"
                    + "              <select name='po' id='po' class='form-control'>\n"
                    + "                <option value='dia'>Dia(s)</option>\n"
                    + "                <option value='mes'>Mês(meses)</option>\n"
                    + "                <option value='ano'>Ano(s)</option>\n"
                    + "              </select>\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "        </div>"
                    + "        <div class='form-group'>"
                    + "           <label for=''>Tempo desejado: </label>"
                    + "<select name='apt' id='apt' class='form-control'>\n"
                    + "            <option value='dia'>\n"
                    + "              Ao dia (a.d)\n"
                    + "            </option>\n"
                    + "            <option value='mes'>\n"
                    + "              Ao mês (a.m)\n"
                    + "            </option>\n"
                    + "            <option value='ano'>\n"
                    + "              Ao Ano (a.a)\n"
                    + "            </option>\n"
                    + "          </select>"
                    + "        </div>"
                    + "        <div class='form-group'>\n"
                    + "          <button class='btn btn-primary'>\n"
                    + "            Calcular\n"
                    + "          </button>\n"
                    + "        </div>\n"
                    + "      </form>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "    <div class='col-md-1'></div>\n"
                    + "    <div class='col-md-1'></div>\n"
                    + "    <div class='col-md-5 text-center'>\n"
                    + "      <h2>Juros Compostos</h2>\n"
                    + "      <p style='text-align: justify'>\n"
                    + "      O regime de juros compostos é o mais comum no sistema financeiro e o mais útil para cálculos de problemas do dia-a-dia.\n"
                    + "      O atual sistema financeiro utiliza o regime de juros compostos, pois ele oferece uma maior rentabilidade quando comparado ao regime de juros simples, uma vez que juros compostos incidem mês a mês, de acordo com o somatório acumulativo do capital com o rendimento mensal.\n"
                    + "      \n"
                    + "      <p style='text-align: justify'>Juros compostos são muito usados no comércio, como em bancos. Os juros compostos são utilizados na remuneração das cadernetas de poupança, e é conhecido como <strong>juro sobre juro</strong>.&nbsp;A fórmula de juros compostos pode ser escrita através da remuneração cobrada pelo empréstimo de dinheiro. O valor da dívida é sempre corrigido e a taxa de juros é calculada sobre esse valor.</p>\n"
                    + "      \n"
                    + "      <h4><kbd>Juros = Montante - Capital(PV)</kbd></h4>\n"
                    + "      <h4><kbd>Montante = C * ( 1 + i )^n</kbd></h4>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</span>\n");

            if (request.getParameter("vl_base") != null && request.getParameter("vl_juros") != null && request.getParameter("qt_tempo") != null && request.getMethod().equals("POST")) {
                if (!hasRegex(request.getParameter("vl_base"), "[a-zA-z]") && !hasRegex(request.getParameter("qt_tempo"), "[a-zA-z]") && !hasRegex(request.getParameter("po"), "[0-9]")) {
                    double n = Double.parseDouble(request.getParameter("qt_tempo"));
                    double resultado = 0;

                    if (!request.getParameter("po").equals(request.getParameter("apt"))) {
                        n = conversor(request.getParameter("po"), Double.parseDouble(request.getParameter("qt_tempo")), request.getParameter("apt"));
                    }

                    resultado = calculaMontante(Double.parseDouble(request.getParameter("vl_base")), Double.parseDouble(request.getParameter("vl_juros")), n);

                    out.println("<div class='alert alert-info text-center'>");
                    out.println("  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
                    out.println("<h2>Seu resultado: </h2><p>Mediante uma taxa de " + request.getParameter("vl_juros") + "%, você possui: </p>");
                    out.println("<p>");
                    out.printf("Montante de: R$ %.2f", resultado);
                    out.println("</p>");

                    out.println("<p>Juros de:");
                    out.printf("R$ %.2f", calculaJuros(Double.parseDouble(request.getParameter("vl_base")), resultado));
                    out.println("</p><br>");

                    out.println("<table class='table table-hover text-center'><thead class='text-center'><tr><th class='text-center'>Período</th><th class='text-center'>Montante acumulado</th></tr></thead><tbody>");
                    String periodo = request.getParameter("po");
                    if ("mes".equals(periodo)) {
                        periodo = periodo.replace("e", "ê");
                    }
                    
                    double ini_cap = Double.parseDouble(request.getParameter("vl_base"));
                    double mot;
                    
                    for (int i = 1; i < n; i++) {
                        mot = calculaMontante(ini_cap, Double.parseDouble(request.getParameter("vl_juros")), i);
                        out.printf("<tr><td class='text-center'>" + i + "º " + periodo + "</td><td class='text-center'>R$ %.2f</td></tr>",
                                mot
                        );
                    }
                    out.printf("<tr><td class='text-center'>" + (int) n + "º" + periodo + "</td><td class='text-center'> R$ %.2f</td></tr>", calculaMontante(Double.parseDouble(request.getParameter("vl_base")), Double.parseDouble(request.getParameter("vl_juros")), n));
                    out.println("</tbody></table>");
                    out.println("</div>");

                } else {
                    out.println("<div class='alert alert-danger fade in'>"
                            + "  <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>"
                            + "<strong>Por favor, utilize apenas números nos campos.</strong> "
                            + "</div>");
                }
            }
            out.println("</div>");
            out.println(
"<footer >\n" +
"  <div class='container text-center'>\n" +
"    <p>Fatec Praia Grande - Análise e Desenvolvimento de Sistemas / 2016</p>\n" +
"  </div>\n" +
"</footer>"
            );
            out.println("    <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>\n"
                    + "<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
                    + "  </body>\n"
                    + "</html>");

            out.close();
        }
    }

    public double calculaJuros(double Capital, double Montante) {
        return Montante - Capital;
        //return 100 * (Math.pow(( Montante/Capital ), ( (1/n) )) - 1 );

    }

    public double calculaMontante(double Capital, double taxa, double tempo) {
        return Capital * Math.pow((1 + (taxa / 100)), tempo);
    }

    public double conversor(String po, double n, String apt) {
        if (po.equals("dia") && apt.equals("mes")) // transforma x dias em y mês
        {
            return (n / 30);
        } else if (po.equals("dia") && apt.equals("ano")) // transforma x dias em y mês
        {
            return (n / 365);
        } else if (po.equals("mes") && apt.equals("dia")) // transforma x mês em y dias
        {
            return (n * 30);
        } else if (po.equals("mes") && apt.equals("ano")) // transforma x meses em y anos
        {
            return (n / 12);
        } else if (po.equals("ano") && apt.equals("dia")) // transforma x anos em y dias
        {
            return (n * 365);
        } else if (po.equals("ano") && apt.equals("mes")) // transforma x anos em y mes
        {
            return (n * 12);
        } else {
            return n;
        }
    }

    public boolean hasRegex(String contexto, String pattern) {
        Pattern p = Pattern.compile(pattern);
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
