# beer-factory

Projeto criado para te ajudar a encontrar a melhor cerveja de acordo com a temperatura.

url: localhost:8080

Endpoins: 
  /beer - Get- Lista todas as cervejas cadastradas
  /beer - Post - Adiciona uma nova cerveja
        {
		      "id" : null, 
		      "type": "BRAHMA",
	      	"min": -1,
		      "max": 3
         }
 /beer/{id} - Put - Altera o registro de acordo com o ID.
        {
		      "type": "ALTERADO",
	      	"min": -2,
		      "max": 5
         }
 /beer/{id} - Delete - Exclui o registro de acordo com o ID
 
  /beer/best-choice - Get - Usado para pesquisar sobre a temperatura da cerveja
  	{
	   "temperatura" :-2
	}
 
 Foi utilizado um banco de dados em memória, H2. Portando ele existirá somente ao subir o sistema.
 
 Em /src/main/resources/data.sql estão os insertes iniciais, sendo executados automaticamente.
 
 As tabelas são criadas de acordo com o mapeamento do JPA, de forma automática.
 
 Para rodar, execute o comando ./mvnw na pasta raiz do projeto.
 Outra forma é com o maven, mvn clean install, após execute o jar dentro de /target: java -jar beer-factory.jar
 
 Para acessar o console do H2, http://localhost:8080/h2-console

