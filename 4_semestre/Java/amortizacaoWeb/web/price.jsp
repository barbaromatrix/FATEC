<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@include file="__includes/header.jsp" %>
<%@include file="__includes/header-interno.jsp" %>


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
<div class="jumbotron text-center name-me" style="background: url('http://www.mas.gov.sg/~/media/Internal%20banner/Monetary_Policy_and_Economics.ashx?20120623T1049411759') center">
    <h1 class="presentation">Sistema Price</h1>
</div>
<div class="container">
    <div class="row text-center">
        <h1>"De pouco em pouco, a amortização é realizada."</h1>
    </div>
    
    <div class="row" style="margin-top: 3vw;">
        <div class="col-md-6">
            <form class="form-horizontal" method="post">
        <div class="form-group">
            <!--<h1> Sistema Price</h1>-->
            <div class="form-group">
                <label class="control-label col-sm-4" for="pv">Capital</label>
                <div class="input-group col-sm-6">
                    <div class="input-group-addon ">R$</div>
                    <input type="text" class="form-control" id="capital" name="capital" placeholder="Capital">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-4" for="taxa">Taxa de Juros</label>
                <div class="input-group col-sm-6"> 
                    <div class="input-group-addon ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <input type="text" class="form-control" id="taxa" name="taxa" placeholder="Juros">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-4" for="periodo">Tempo</label>
                <div class="input-group col-sm-6"> 
                    <div class="input-group-addon ">&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <input type="text" class="form-control" id="periodo" name="periodo" placeholder="Tempo">
                </div>
            </div>
            <div class="recuo">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="apt">Aplicação da taxa </label>
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
            <p class="explanation">
                Os financiamentos utilizando a tabela Price são oferecidos com o propósito de prestações fixas ao longo do período de quitação do bem, sem aumento por algum tipo de correção (dependendo do contrato de financiamento). O método Price consiste em calcular prestações fixas, sendo que o saldo devedor é amortizado aos poucos, até a quitação do débito.
            </p>
            <p class="explanation">
                Os juros estão embutidos nas prestações, a seguir iremos construir uma tabela especificando o valor dos juros pagos e da amortização sobre o valor do saldo devedor. Assim teremos condições de analisar todos os passos mensais de um empréstimo.
            </p>
            
        </div>
    </div>
    
</div>
<%
    if (request.getParameter("capital") != null && request.getParameter("periodo") != null && request.getParameter("taxa") != null) {

        String sCapital = request.getParameter("capital");
        String sPeriodo = request.getParameter("periodo");
        String sTaxa = request.getParameter("taxa");
        DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

        double dCapital = Double.parseDouble(sCapital);
        double iPeriodo = Double.parseDouble(sPeriodo);
        double dTaxa = (Double.parseDouble(sTaxa) / 100);
    
        // Transforma o tempo
        String po = request.getParameter("po");
        String apt = request.getParameter("apt");
        if (!po.equals(apt)) {
            iPeriodo = conversor(po, apt, iPeriodo);
        }
        
        
        // Gera a conta
        double dCima = Math.pow((1 + dTaxa), iPeriodo) * dTaxa;
        double dBaixo = Math.pow((1 + dTaxa), iPeriodo) - 1;
        double dPMT = dCapital * (dCima / dBaixo);
        double dJuros, dAmortizacao, dSaldoDevedor;

        dSaldoDevedor = dCapital;
        %>
        
        <div class="container">
            <table border="1" class="table">
                <tr class="info">                
                    <th><div class="text-center">#</div></th>
                    <th><div class="text-center">Parcela</div></th>
                    <th><div class="text-center">Juros</div></th>
                    <th><div class="text-center">Amortização</div></th>
                    <th><div class="text-center">Saldo devedor</div></th>   
                </tr>
                <tr>
                    <td class="text-center">0</td>
                    <td class="text-center">-----</td>
                    <td class="text-center">-----</td>
                    <td class="text-center">-----</td>
                    <td class="text-center"><%= mascaraDinheiro(dCapital, DINHEIRO_REAL) %></td>
                </tr>
                <%
                    for (int i = 1; i <= (int) iPeriodo; i++) { 
                        dJuros = dSaldoDevedor * dTaxa;
                        dAmortizacao = dPMT - dJuros;
                        dSaldoDevedor -= dAmortizacao;
                %>
                <tr>
                    <td class="text-center"><%= i %></td>
                    <td class="text-center"><%= mascaraDinheiro(dPMT, DINHEIRO_REAL) %></td>
                    <td class="text-center"><%= mascaraDinheiro(dJuros, DINHEIRO_REAL) %></td>
                    <td class="text-center"><%= mascaraDinheiro(dAmortizacao, DINHEIRO_REAL) %></td>
                    <td class="text-center"><%= mascaraDinheiro(dSaldoDevedor, DINHEIRO_REAL) %></td>
                </tr>
                   <% } %>
            </table>
        </div>
        
                    <%}%>
<%@include file="__includes/footer.jsp" %>



