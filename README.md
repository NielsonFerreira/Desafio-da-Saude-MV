<h1 align="center">
    <img alt="Desafio da Saúde MV" title="#Desafio da Saúde MV" src="banner.png" />
</h1>

## 💻 Sobre o projeto
API REST para ler manipular dados do CNES (Cadastro Nacional de Estabelecimentos de Saúde) do Brasil

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- <a href="https://spring.io/projects/spring-boot">Spring Boot</a>
- <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools">DevTools</a>
- <a href="https://maven.apache.org">Maven</a>
- <a href="https://hibernate.org">Hibernate</a>
- <a href="https://www.h2database.com/html/main.html">H2 Database</a>
- <a href="https://docs.jboss.org/hibernate/orm/5.4/topical/html_single/metamodelgen/MetamodelGenerator.html">JPA Metamodel</a>
- <a href="https://junit.org/junit5/">Junit</a>
- <a href="https://projectlombok.org/">Lombok</a>
- <a href="https://commons.apache.org/proper/commons-lang/">Apache Commons Lang</a>
- <a href="https://www.postman.com">Postman</a>
- <a href="https://www.google.com/intl/pt-BR/chrome/">Google Chrome</a>


## 🚀 Como executar o projeto

Usando o Prompt de Comando, entrar no diretório do projeto e executar o comando:

```bash
java -jar Desafio-da-Saude-MV-0.0.1-SNAPSHOT.jar
```
E esperar a aplicação subir em http://localhost:8080.

Para esse projeto foi utilizado o banco de dados H2. Os registros vem do arquivo "cnes_ativo.csv"
que se encontra no diretório "...Desafio-da-Saude-MV\src\main\resources".

A seguir as configurações utilizadas no arquivo "application.properties"
```bash
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:file:~/desafiomv
spring.datasource.username=cnes
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format-sql=true
```

## ⚙️ Endpoints

Os endpoints dessa API estão detalhadamente explicados nesse link :point_right: https://documenter.getpostman.com/view/7857036/TzXumekg

## 📋 Informações Extras

Durante o desenvolvimento foi utilizado alguns padrões como "Observer", "Dependency Injection" e "Repository". 
Também foi dada atenção ao uso dos verbos HTTP e aos códigos de respostas.

## 🎁 Comentários Finais

Encontrei vários obstaculos durante o desenvolvimento desse projeto, mas busquei dar o meu melhor para que eu pudesse apresentar
algo funcional.