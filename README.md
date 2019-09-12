# LOJA ONLINE

API criada para auxiliar no aprendizado de HTML CSS e JAVASCRIPT

url: localhost:8080

 
 Foi utilizado um banco de dados em memória, H2. Portando ele existirá somente ao subir o sistema.
 
 Em /src/main/resources/data.sql estão os insertes iniciais, sendo executados automaticamente.
 
 As tabelas são criadas de acordo com o mapeamento do JPA, de forma automática.
 
 Para rodar, execute o comando ./mvnw na pasta raiz do projeto.
 
 Outra forma é com o maven, mvn clean install, após execute o jar dentro de /target: java -jar loja-online.jar
 
 Para acessar o console do H2, http://localhost:8080/h2-console

