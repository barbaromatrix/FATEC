<%@include file="__includes/header.jsp" %>
<%@include file="__includes/header-interno.jsp" %>
<div class="jumbotron text-center name-me">
    <h1 class="presentation">Você já ouviu falar sobre o termo "<strong>Amortização</strong>"?</h1>
    <h3 class="presentation">Caso não saiba do que estamos falando, descubra abaixo :)</h3>
</div>

<div class="container">
    <!--  div de apresentação do grupo  -->
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
            <h2>Amortização</h2>
        </div>
        <div class="row">
            <div class="col-md-12">
                <p class="explanation">
                    Na amortização, cada prestação é uma parte do valor total, incluindo os juros e o saldo devedor restante. Amortização é um termo muito utilizado em contabilidade, administração financeira e matemática. A amortização traduz-se pela soma do reembolso do capital ou do pagamento dos juros do saldo devedor. Dentro da amortização, estão incluídos os prazos, que é o tempo necessário para o pagamento de todas as parcelas; as parcelas de amortização, que é o valor devolvido periodicamente e as prestações, que é a soma da amortização, com o acréscimo de juros e impostos. </p>
                <p class="explanation">
                    A amortização também está presente na área da contabilidade, que é o processo que torna inatingível os ativos classificados na conta do balanço patrimonial, e pode ser relacionado também com a depreciação, que é a redução dos valores dos bens, à medida que são utilizados. Conheça abaixo sobre alguns dos pricipais métodos utilizados no cálculo da amortização. Os métodos são: <kbd>Americano</kbd>, <kbd>Amortização Constante</kbd>, e <kbd>Price</kbd>.
                </p>
            </div>
        </div>
    </span>
    <br>
    <br>
    <br>
    <span id="tipos-amortizacao">
        <!--  divisão em várias row, cada uma explicando sobre o conceito    -->
        <!--  Divisão price    -->
        <div class="row amortizacao">
            <div class="col-md-4">
                <img src="http://image.flaticon.com/icons/svg/168/168539.svg" alt="Sistema de amortização Americano" style="max-width: 60%" class="img-responsive"/>
            </div>
            <div class="col-md-8 text-center">
                <h2>(S.A.C)</h2>
                <p style="text-align: justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa necessitatibus, eum sit nihil doloribus alias, labore eos exercitationem dolorem explicabo ipsam laboriosam, in neque laborum cumque quidem dignissimos voluptas numquam.</p>
                <a href="amortizacao_sac.jsp" role="button" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-usd"></i>&nbsp; Quero conhecer!&nbsp; <i class="glyphicon glyphicon-usd"></i></a>
            </div>
        </div>

        <!--  Divisão Americano    -->
        <div class="row amortizacao">
            <div class="col-md-4">
                <img src="http://image.flaticon.com/icons/svg/140/140354.svg" alt="Sistema de amortização Americano" style="max-width: 60%" class="img-responsive"/>
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