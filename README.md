## Shopping-cart

#### Este repositório contem o projeto back-end desenvolvido em Java(shopping-cart)
#### Faça o download e siga as instruções abaixo.

##### Instalando o Back End

###### Pré-requisito
- Maven(https://maven.apache.org/download.cgi).

- Wildfly 9(http://wildfly.org/downloads/)

- Banco de Dados

  - Foi utilizado Mongodb para esse projeto, então baixe o Mongo(https://www.mongodb.com/download-center#community)
e crie uma base de dados chamada "app_decorado".

###### Depois basta abrir o terminal
- Entrar na pasta do projeto e digitar
- mvn clean install
- Após o processo de build, navegue até /.m2/repository/shopping-cart/shopping-cart/0.0.1-SNAPSHOT
encontreo WAR da aplicação e copie na pasta ~/wildfly-9.0.2.Final/standalone/deployments do seu servidor Wildfly.
