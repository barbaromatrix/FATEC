<%@include file="__includes/header.jsp" %>
<%@include file="__includes/header-interno.jsp" %>
<div class="jumbotron text-center name-me">
    <h1 class="presentation">Voc� j� ouviu falar sobre o termo "<strong>Amortiza��o</strong>"?</h1>
    <h3 class="presentation">Caso n�o saiba do que estamos falando, descubra abaixo :)</h3>
</div>

<div class="container">
    <!--  div de apresenta��o do grupo  -->
    <span id="grupo-apresentacao">
        <section id="equipe" style='margin-top: 1%;'>
            <div class="row text-center">
                <h2>Equipe</h2>
            </div>
            <div class="row">
                <div class="col-md-4 text-center item-shadow">
                    <!-- Marcelo -->
                    <img src="http://image.flaticon.com/icons/svg/145/145843.svg" alt="Patinho pro Galdino no CS" style='text-align: center; max-width: 16vw; width: 100%; height: auto; margin-bottom: 1vw' />
                    <h3 class="text-center">
                        Marcelo
                    </h3>
                    <p style='text-align: justify'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima veniam non, dolorum aperiam ad dolores quidem possimus laudantium asperiores magnam animi, libero explicabo in neque iusto repellat aliquam voluptatibus harum!</p>
                </div>
                <div class="col-md-4 text-center item-shadow">
                    <!-- Diogo -->
                    <img src="http://image.flaticon.com/icons/svg/145/145845.svg" alt="Mestre android" style='text-align: center; max-width: 16vw; width: 100%; height: auto; margin-bottom: 1vw' data-toggle="tooltip" title="Hooray!" />
                    <h3 class="text-center">
                        Diogo
                    </h3>
                    <p style='text-align: justify'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima veniam non, dolorum aperiam ad dolores quidem possimus laudantium asperiores magnam animi, libero explicabo in neque iusto repellat aliquam voluptatibus harum!</p>
                </div>
                <div class="col-md-4 text-center item-shadow">
                    <!-- Galdino -->
                    <img src="http://image.flaticon.com/icons/svg/145/145848.svg" alt="Mais ou menos como o galdino parece (desconsiderar a grande quantidade de cabelo)" style='text-align: center; max-width: 16vw; width: 100%; height: auto; margin-bottom: 1vw' />
                    <h3 class="text-center">
                        (Matheus) Galdino
                    </h3>
                    <p style='text-align: justify'>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis harum temporibus quas a quam laudantium dolorum animi. Saepe deserunt amet nostrum vitae, praesentium, reiciendis consequatur aspernatur delectus perferendis impedit magni!</p>
                </div>
            </div>
        </section>
    </span>
    <br>
    <br>
    <br>
    <span id="explicacao-amortizacao">
        <div class="row text-center">
            <h2>Amortiza��o</h2>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p class="explanation">
                    Na amortiza��o, cada presta��o � uma parte do valor total, incluindo os juros e o saldo devedor restante. Amortiza��o � um termo muito utilizado em contabilidade, administra��o financeira e matem�tica. A amortiza��o traduz-se pela soma do reembolso do capital ou do pagamento dos juros do saldo devedor. Dentro da amortiza��o, est�o inclu�dos os prazos, que � o tempo necess�rio para o pagamento de todas as parcelas; as parcelas de amortiza��o, que � o valor devolvido periodicamente e as presta��es, que � a soma da amortiza��o, com o acr�scimo de juros e impostos. </p>
                <p class="explanation">
                    A amortiza��o tamb�m est� presente na �rea da contabilidade, que � o processo que torna inating�vel os ativos classificados na conta do balan�o patrimonial, e pode ser relacionado tamb�m com a deprecia��o, que � a redu��o dos valores dos bens, � medida que s�o utilizados. Conhe�a abaixo sobre alguns dos pricipais m�todos utilizados no c�lculo da amortiza��o. Os m�todos s�o: <kbd>Americano</kbd>, <kbd>Amortiza��o Constante</kbd>, e <kbd>Price</kbd>.
                </p>
            </div>
        </div>
    </span>
    <br>
    <br>
    <br>
    <span id="tipos-amortizacao">
        <!--  divis�o em v�rias row, cada uma explicando sobre o conceito    -->
        <!--  Divis�o price    -->
        <div class="row amortizacao">
            <div class="col-md-4">
                <img src="http://image.flaticon.com/icons/svg/168/168539.svg" alt="Sistema de amortiza��o Americano" style="max-width: 60%" class="img-responsive"/>
            </div>
            <div class="col-md-8 text-center">
                <h2>(S.A.C)</h2>
                <p style="text-align: justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa necessitatibus, eum sit nihil doloribus alias, labore eos exercitationem dolorem explicabo ipsam laboriosam, in neque laborum cumque quidem dignissimos voluptas numquam.</p>
                <a href="amortizacao_sac.jsp" role="button" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-usd"></i>&nbsp; Quero conhecer!&nbsp; <i class="glyphicon glyphicon-usd"></i></a>
            </div>
        </div>

        <!--  Divis�o Americano    -->
        <div class="row amortizacao">
            <div class="col-md-4">
                <img src="http://image.flaticon.com/icons/svg/140/140354.svg" alt="Sistema de amortiza��o Americano" style="max-width: 60%" class="img-responsive"/>
            </div>
            <div class="col-md-8 text-center">
                <h2>Sistema Americano (S.A)</h2>
                <p style="text-align: justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa necessitatibus, eum sit nihil doloribus alias, labore eos exercitationem dolorem explicabo ipsam laboriosam, in neque laborum cumque quidem dignissimos voluptas numquam.</p>
                <a href="amortizacao_sam.jsp" role="button" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-usd"></i>&nbsp; Quero conhecer!&nbsp; <i class="glyphicon glyphicon-usd"></i></a>
            </div>
        </div>

        <!--  Price  -->    
        <div class="row amortizacao">
            <div class="col-md-4">
                <img src="http://image.flaticon.com/icons/svg/190/190474.svg" alt="Sistema Price" style="max-width: 60%" class="img-responsive"/>
            </div>
            <div class="col-md-8 text-center">
                <h2>Price</h2>
                <p style="text-align: justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa necessitatibus, eum sit nihil doloribus alias, labore eos exercitationem dolorem explicabo ipsam laboriosam, in neque laborum cumque quidem dignissimos voluptas numquam.</p>
                <a href="price.jsp" role="button" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-usd"></i>&nbsp; Quero conhecer!&nbsp; <i class="glyphicon glyphicon-usd"></i></a>
            </div>
        </div>
    </span>
</div>
<%@include file="__includes/footer.jsp" %>