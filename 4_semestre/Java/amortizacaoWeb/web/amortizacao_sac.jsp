<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>

<%
    DecimalFormat DINHEIRO_DOLAR;
    DecimalFormat DINHEIRO_EURO;
    DecimalFormat DINHEIRO_REAL;

    DINHEIRO_DOLAR = new DecimalFormat("¤ ###,###,##0.00", new DecimalFormatSymbols(Locale.US));
    DINHEIRO_EURO = new DecimalFormat("¤ ###,###,##0.00", new DecimalFormatSymbols(Locale.GERMANY));
    DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    int mes = 0;
    double saldo_devedor[] = {};
    double amortizacao = 0;
    double juro[] = {};
    double prestacao[] = {};
    double pv = 0, i = 0, n = 0;
%>

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

        return 0;
    }

    public String mascaraDinheiro(double valor, DecimalFormat moeda) {
        return moeda.format(valor);
    }
%>

<%
    if (request.getParameter("pv") != null && request.getParameter("i") != null && request.getParameter("n") != null) {

        pv = Double.valueOf(request.getParameter("pv"));
        i = Double.parseDouble(request.getParameter("i")) / 100;
        n = Double.parseDouble(request.getParameter("n"));
        mes = 0;

        // Converte o valor para o tempo desejado
        String po = request.getParameter("po");
        String apt = request.getParameter("apt");
        if (!po.equals(apt)) {
            n = conversor(po, apt, n);
        }

        mes = (int) n;

        saldo_devedor = new double[mes + 1];

        juro = new double[mes + 1];
        prestacao = new double[mes + 1];

        saldo_devedor[0] = pv;
        amortizacao = pv / n;
        juro[0] = .0;
        prestacao[0] = .0;

        for (int count = 1; count < (mes + 1); count++) {
            juro[count] = saldo_devedor[count - 1] * i;
            prestacao[count] = amortizacao + juro[count];
            saldo_devedor[count] = saldo_devedor[count - 1] - amortizacao;
        }
    }
%>

<%@include file="__includes/header.jsp" %>
<div class="jumbotron text-center name-me" style="background: url('http://www.mas.gov.sg/~/media/Internal%20banner/Statistics.ashx') center">
    <h1 class="presentation">Sistema Price</h1>
</div>
<%@include file="__includes/header-interno.jsp" %>
<div class="container">
    <div class="row text-center">
        <h1> Método hamburguês, parcelas decrescentes.</h1>
    </div>
    <div class="row" style="margin-top: 3vw;">
        <div class="col-md-6">
            <form class="form-horizontal" method="post"><!-- action="calc_amortizacao_sac.jsp" -->
                <div class="form-group">
                    
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="pv">Capital</label>
                        <div class="input-group col-sm-6"> 
                                <div class="input-group-addon ">R$</div>
                            <input type="number" class="form-control" id="pv" name="pv" placeholder="Capital">
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
                                <select class="form-control" name="apt" >
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
                O atual mercado financeiro oferece variadas operações de crédito para quem deseja financiar carro, imóveis, constituir um negócio próprio, investir na empresa, entre outras opções. As instituições financeiras oferecem um capital que deverá ser devolvido com juros durante o período pré-determinado. este sistema o saldo devedor é reembolsado em valores de amortização iguais. Desta forma, no sistema SAC o valor das prestações é decrescente, já que os juros diminuem a cada prestação. O valor da amortização é calculada dividindo-se o valor do principal pelo número de períodos de pagamento, ou seja, de parcelas.
            </p>
            <!--<p class="explanation">
                As formas de quitar o empréstimo são inúmeras, vamos abordar o funcionamento do sistema de amortizações constantes, que consiste no pagamento da dívida baseada em parcelas de amortizações iguais com prestações e juros decrescentes.
            </p>-->
        </div>
    </div>
    
</div>



<% if (request.getParameter("pv") != null && request.getParameter("i") != null && request.getParameter("n") != null) {%>
<div class="container">
    <table border="1" class="table">
        <tr class="info">                
            <th><div class="text-center">Mês</div></th>
            <th><div class="text-center">Saldo Devedor</div></th>
            <th><div class="text-center">Amortização</div></th>
            <th><div class="text-center">Juros</div></th>
            <th><div class="text-center">Prestação</div></th>   
        </tr>
        <tr class="info">                
            <td><div class="text-center"><%= 0%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) saldo_devedor[0], DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
        </tr>
        <%for (int count = 0; count < mes; count++) {%>
        <tr class="info">          
            <td><div class="text-center"><%= count%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) (saldo_devedor[count - 1] - amortizacao), DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) amortizacao, DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) (saldo_devedor[count - 1] * i), DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) amortizacao + (saldo_devedor[count - 1] * i), DINHEIRO_REAL)%></div></td>
        </tr>
        <%
            }
            double soma_sal_devedor = .0;
            double soma_amortizacao = amortizacao * mes;
            double soma_juro = .0;
            double soma_prestacao = .0;

            for (int count = 0; count < (mes + 1); count++) {
                soma_sal_devedor += saldo_devedor[count];
                soma_juro += juro[count];
                soma_prestacao += prestacao[count];
            }
        %>
        <tr class="info">
            <td><div class="text-center"><%="-"%></div></td>
            <td><div class="text-center"><%="-"%></div></td>
            <td><div class="text-center"><%="-"%></div></td>
            <td><div class="text-center"><%="-"%></div></td>
            <td><div class="text-center"><%="-"%></div></td>
        </tr>
        <tr class="info">          
            <td><div class="text-center"><%= "Total"%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) soma_amortizacao, DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) soma_juro, DINHEIRO_REAL)%></div></td>
            <td><div class="text-center"><%= mascaraDinheiro((double) soma_prestacao, DINHEIRO_REAL)%></div></td>
        </tr> 
    </table>
</div>
<%}%>

<%@include file="__includes/footer.jsp" %>
