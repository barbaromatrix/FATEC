<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.DecimalFormatSymbols" %>
<%@ page import="java.util.Locale" %>

<%--
    Funções
--%>
<%!
    public double conversor(String po, String apt, double n) {
        if (po.equals("dia") && apt.equals("mes")) {
            return (n / 30);
        }
        if (po.equals("dia") && apt.equals("ano")) {
            return (n / 364);
        }
        if (po.equals("mes") && apt.equals("dia")) {
            return (n * 30);
        }
        if (po.equals("mes") && apt.equals("ano")) {
            return (n / 12);
        }
        if (po.equals("ano") && apt.equals("dia")) {
            return (n * 364);
        }
        if (po.equals("ano") && apt.equals("mes")) {
            return (n * 12);
        }
        return .0;
    }

    public String mascaraDinheiro(double valor, DecimalFormat moeda) {
        return moeda.format(valor);
    }
%>

<%@include file="__includes/header.jsp" %>
<div class="jumbotron text-center name-me" style="background: url('https://wallpaperscraft.com/image/hand_pen_calculator_calculations_80041_1920x1080.jpg') center">
    <h1 class="presentation">Sistema Americano</h1>
</div>
<%@include file="__includes/header-interno.jsp" %>
<div class="container">
    <div class="row text-center">
        <h1> Parcela presa, juros soltos.  </h1>
    </div>
    <div class="row" style="margin-top: 3vw;">
        <div class="col-md-6">
            <form class="form-horizontal" method="post">
                <div class="form-group">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="pv">Capital</label>
                        <div class="input-group col-sm-6"> 
                        <div class="input-group-addon ">R$</div>
                            <input type="text" class="form-control" id="pv" name="pv" placeholder="Capital">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="i">Taxa de Juros</label>
                        <div class="input-group col-sm-6"> 
                        <div class="input-group-addon ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                            <input type="number" class="form-control" id="i" name="i" placeholder="Juros">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="n">Tempo</label>
                        <div class="input-group col-sm-6"> 
                    <div class="input-group-addon ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                            <input type="number" class="form-control" id="n"  name="n" placeholder="Tempo">
                        </div>
                    </div>
                    <div class="recuo">
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="apt"> Aplicação da taxa </label>
                            <div class="input-group col-sm-6"> 
                            <div class="input-group-addon ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                <select class="form-control" name="apt">
                                    <option value="dia"> ao dia(a.d.) </option>
                                    <option value="mes" selected> ao mês(a.m.) </option>
                                    <option value="ano"> ao ano(a.a.) </option>
                                </select>
                            </div>
                        </div>                    
                        <div class="form-group">
                            <label class="control-label col-sm-4" for="po"> Período de operação </label>
                            <div class="input-group col-sm-6"> 
                                <div class="input-group-addon ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                                <select class="form-control" name="po">
                                    <option value="dia"> Dia(s) </option>
                                    <option value="mes" selected> Mês(Meses) </option>
                                    <option value="ano"> Ano(s) </option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group text-center">
                <input class="btn btn-default" type="submit" value="Calcular Montante" class="form-control">
            </div>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <p class="explanation">O Sistema Americano de Amortização é um tipo de quitação de empréstimo que favorece aqueles que desejam pagar o valor principal através de uma única parcela, porém os juros devem ser pagos periodicamente ou, dependendo do contrato firmado entre as partes, os juros são capitalizados e pagos junto ao valor principal. </p>
            <p class="explanation">Tem como desvantagem que o pagamento de juros pode, em tese, ser perpétuo mesmo quando já se pagou o equivalente à dívida em si. Para isso, basta que o número de prestações exceda 100% quando da soma dos juros simples.</p>
            <!--<p class="explanation">Simule ao lado o método americano de amortização.</p>-->
        </div>
    </div>
</div>

<%
    if (request.getParameter("pv") != null && request.getParameter("i") != null && request.getParameter("n") != null) {
        DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

        double pv = Double.valueOf(request.getParameter("pv"));
        double i = (Double.parseDouble(request.getParameter("i")) / 100);
        double n = Double.parseDouble(request.getParameter("n"));
        String po = request.getParameter("po");
        String apt = request.getParameter("apt");
        if (!po.equals(apt)) {
            n = conversor(po, apt, n);
        }

        int mes = 0;
        int count = 1;

        try {
            mes = (int) n;
        } catch (Exception ex) {
        }

        double saldo_devedor = pv;
        double juros = (saldo_devedor * i);
        double prestacao = juros;
%>
<div class="container">
    <table border="1" class="table">
        <tr class="info">                
            <th class="text-center">Mês</th>
            <th class="text-center">Saldo Devedor</th>
            <th class="text-center">Amortização</th>
            <th class="text-center">Juros</th>
            <th class="text-center">Prestação</th>   
        </tr>
        <tr class="info">                
            <td class="text-center"><%= 0%></td>
            <td class="text-center"><%= mascaraDinheiro((double) saldo_devedor, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></td>
        </tr>
        <%for (count = 1; count < mes; count++) {%>
        <tr class="info">
            <td class="text-center"><%= count%></td>
            <td class="text-center"><%= mascaraDinheiro((double) saldo_devedor, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro((double) 0, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro((double) juros, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro((double) prestacao, DINHEIRO_REAL)%></td>
        </tr>
        <%}%>
        <tr class="info">
            <td class="text-center"><%= count%></td>
            <td class="text-center"><%="-"%></td>
            <td class="text-center"><%= mascaraDinheiro(saldo_devedor, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro(juros, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro(saldo_devedor + juros, DINHEIRO_REAL)%></td>
        </tr>
        <tr class="info">
            <td class="text-center">-</td>
            <td class="text-center">-</td>
            <td class="text-center">-</td>
            <td class="text-center">-</td>
            <td class="text-center">-</td>
        </tr>
        <tr class="info">          
            <td class="text-center"><%= "Total"%></td>
            <td class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro((double) saldo_devedor, DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro((double) (juros * mes), DINHEIRO_REAL)%></td>
            <td class="text-center"><%= mascaraDinheiro((double) (juros * mes) + saldo_devedor, DINHEIRO_REAL)%></td>
        </tr> 
    </table>
</div>
<% }%>

<%@include file="__includes/footer.jsp" %>