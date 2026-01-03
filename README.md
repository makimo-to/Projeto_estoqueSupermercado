<div align="center">
  <h1>Projeto Estoque de Supermercado (CRUD)</h1>
  <p>Esta é uma API REST desenvolvida para o gerenciamento de stock de supermercados, construída com Java 25 e Spring Boot 4. O projeto foi concebido como um exemplo prático de aplicação de princípios de Clean Code, Arquitetura em Camadas e Resiliência no Tratamento de Erros.</p>
</div>
<br>
<div align="center">
  <h2>Diferenciais do Projeto</h2>
</div>

<div align="left">
  
  <h3>🏛️ Arquitetura e Design de Software</h3>
  <ul>
    <li><strong>Padrão DTO (Data Transfer Object):</strong> Implementado para isolar as entidades do banco de dados da camada de exposição (API), garantindo que dados sensíveis ou internos não sejam expostos desnecessariamente.</li>
    <li><strong>Camada de Mapeamento (Mappers):</strong>Utilização de componentes dedicados para a conversão entre ProdutoModel e ProdutoDTO, mantendo a lógica de conversão centralizada e limpa.</li>
    <li><strong>Camada de Serviço (Service):</strong>Toda a regra de negócio está concentrada na ProdutoService, mantendo o controlador (Controller) leve e focado apenas no fluxo de requisição/resposta.</li>
  </ul>
  
  <h3>🛠️ Robustez e Tratamento de Erros</h3>
  <ul>
    <li><strong>Global Exception Handling: </strong>Implementação de um @RestControllerAdvice no ProdutoController para capturar exceções de validação e retornar mensagens amigáveis e padronizadas para o cliente.</li>
    <li><strong>Validação de Dados:</strong>Uso rigoroso de Bean Validation (@NotNull, @Min) para garantir a integridade dos dados antes mesmo de chegarem à camada de negócio. </li>
  </ul>
  
  <h3>🔒 Segurança e Configuração</h3>
  <ul>
    <li><strong>Externalização de Configurações:</strong>Uso de variáveis de ambiente (.env) e perfis de configuração no application.properties para gerir credenciais de banco de dados de forma segura, evitando o hard-coding de senhas.</li>
    <li><strong>Infraestrutura com Docker:</strong>Disponibilização de um arquivo docker-compose.yml para facilitar o setup do ambiente de base de dados (MySQL), garantindo que a aplicação seja facilmente replicável.</li>
  </ul>
</div>

<div align="left">
  <h2>📋 Pré-requisitos</h2>
  <h3>🔧 Ambiente de Desenvolvimento</h3>
  <ul>
    <li>Java JDK 25: O projeto utiliza a versão mais recente do Java (OpenJDK 25).</li>
    <li>Maven 3.x: Gerenciador de dependências e build do projeto.</li>
    <li>IDE: Recomendado IntelliJ IDEA (devido às configurações de variáveis de ambiente mostradas nos prints) ou VS Code com extensões Java.</li>
  </ul>
  <h3>🗄️ Banco de Dados e Infraestrutura</h3>
  <ul>
    <li>Docker & Docker Compose: Necessários para subir o container do MySQL 8.0 configurado no projeto.</li>
    <li>H2 Database (Opcional): O projeto está configurado para suportar banco em memória ou arquivo local para testes rápidos.</li>
  </ul>
</div>

<div align="left">
  <h2>🔧 Instalação</h2>
  
  <h3>clone o projeto</h3>
  <p>para sistemas windows/linux:</p>
  <pre>
    <code>
    git clone https://github.com/makimo-to/Projeto_estoqueSupermercado.git 
    cd Projeto_Supermecado 
  </code></pre>
  
  <h3>Configurar Variáveis de Ambiente</h3>
  <p>O projeto utiliza variáveis externas para proteger dados sensíveis. Você deve criar um arquivo chamado .env na raiz do projeto ou configurar as variáveis no seu sistema/IDE com os seguintes valores:</p
    <ul>
    <li><code>DATABASE_URL: URL de conexão</code> (ex: jdbc:mysql://localhost:3306/db_supermercado).</li>
    <li><code>DATABASE_DRIVE:</code> Driver do banco (ex: com.mysql.cj.jdbc.Driver).</li>
    <li><code>DATABASE_USERNAME:</code> Seu usuário do banco.</li>
    <li><code>DATABASE_PASSOWORD:</code> Sua senha do banco.</li>
  </ul>

  <h3>Iniciar o Banco de Dados (Docker)</h3>
  <pre>
    <code>
      docker-compose up -d 
    </code>
  </pre>

  <h3>compilar e rodas a aplicação</h3>
  <pre>
    <code>
        ./mvnw clean install
        ./mvnw spring-boot:run
    </code>
  </pre>
  
</div>





  
