<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.DecimalFormatSymbols" %>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/jquery.min.js" type="text/javascript"></script>
        <title> Amortização Constante </title>
    </head>
    <body>
        <a href="amortizacao_sam.jsp"></a>
        <%
            Locale BRAZIL = new Locale("pt", "BR");
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00", REAL);

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
                    <td><div class="text-center"><%= mascaraDinheiro((double) saldo_devedor, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro(0, DINHEIRO_REAL)%></div></td>
                </tr>
                <%for (count = 1; count < mes; count++) {%>
                <tr class="info">
                    <td><div class="text-center"><%= count%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro((double) saldo_devedor, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro((double) 0, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro((double) juros, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro((double) prestacao, DINHEIRO_REAL)%></div></td>
                </tr>
                <%}%>
                <tr class="info">
                    <td><div class="text-center"><%= count%></div></td>
                    <td><div class="text-center"><%="-"%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro(saldo_devedor, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro(juros, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro(saldo_devedor + juros, DINHEIRO_REAL)%></div></td>
                </tr>
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
                    <td><div class="text-center"><%= mascaraDinheiro((double) saldo_devedor, DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro((double) (juros * mes), DINHEIRO_REAL)%></div></td>
                    <td><div class="text-center"><%= mascaraDinheiro((double) (juros * mes) + saldo_devedor, DINHEIRO_REAL)%></div></td>
                </tr> 
            </table>
        </div>
    </body>
</html>
