<h1  >API REST - Cadastro de veículos</h1>
 <hr>
<p align="left">O projeto se baseia em uma API Rest que fornece os métodos (GET,POST,PUT,PATCH,DELETE) para controle e cadastro de veículos. O front-end que consome esta api se encontra no seguinte repositório: https://github.com/wdeus/front_tinnova </p>

<h2>Tecnologias utilizadas</h2>
<div style="display: inline_block">
<img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-plain-wordmark.svg" width=100>

<img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width=100 />

<img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" width=100 />

<img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/apache/apache-original.svg" width=100 />
       
</div>


<h2>Requisitos</h2>
  <li>Permitir o cadastro de veiculos</li>
  <li>Permitir a atualização de dadso de um veiculo</li>
  <li>Permitir a exclusão de um veiculo</li>
  <li>Exibir a informação de quantos veiculos estão como não vendidos na base</li>
  <li>Exibir a informação da distribuição de veiculos por década de fabricação</li>
  <li>Exibit a informação da distribuição de veículos por fabricante</li>
  <li>Exibir os carros registrados durante a última semana</li>
  <li>Deverá haver consistência das marcas fornecidas. Não poderá haver marcas escritas de forma errada<li>


<h2>Endpoints</h2>
<ol>GET<ol>
  <li><b>localhost:8080/veiculos</b> -- retorna todos os veiculos (metodo: listarTodosVeiculos)</li>
  <li><b>localhost:8080/veiculos?marca={marca}&ano={ano}</b> -- retorna o veiculo de acordo com a marca e ano informado nos parametros (metodo: listarTodosVeiculos)</li>
  <li><b>localhost:8080/veiculos/id</b> -- retorna o veiculo de acordo com o id informado (metodo: listarVeiculoPorId)</li>
  <li><b>localhost:8080/veiculos/veiculosPorFabricante</b> -- retorna a relação entre o fabricante e quantidade de veiculos (metodo: getVeiculosPorFabricante)</li>
  <li><b>localhost:8080/veiculos/veiculosNaoVendidos</b> -- retorna quantidade de veiculos não vendidos (metodo: getQuantidadeVeiculosNaoVendidos)</li>
  <li><b>localhost:8080/veiculos/veiculosPorDecada</b> -- retorna a relação entre quantidade de veiculos e decada de fabricação (metodo: getVeiculosPorDecada)</li>
  <li><b>localhost:8080/veiculos/veiculosUltimaSemana</b> -- retorna os veiculos registrados a sete dias atrás(metodo: getCarrosRegistradoUltimaSemana)<li>
</ol>
</ol>

<ol>POST<ol>
  <li><b>localhost:8080/veiculos</b> -- cadastrar um novo veiculo (metodo: cadastrar)</li>
</ol>
</ol>


<ol>PUT<ol>
  <li><b>localhost:8080/veiculos/id</b> -- altera os dados do veiculo  (metodo: alterarVeiculo)</li>
</ol>
</ol>


<ol>PATCH<ol>
  <li><b>localhost:8080/veiculos/id</b> -- altera alguns dados do veiculo (metodo: alterarVeiculoParcialmente)</li>
</ol>
</ol>


<ol>DELETE<ol>
  <li><b>localhost:8080/veiculos/id</b> -- exclui um veiculo (metodo: excluir)</li>
</ol>
</ol>

<h2>Demonstração da aplicação </h2>
<li>https://drive.google.com/file/d/1aguzMaNdeiEWl49rv3Q3Xgslm6LOFH2I/view?usp=sharing</li>
