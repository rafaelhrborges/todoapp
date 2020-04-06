# Todo List - Desafio ESIG

DEMO: [https://esigtodoapp.herokuapp.com/](https://esigtodoapp.herokuapp.com/)

Este projeto foi desenvolvido para participar do processo seletivo na ESIG. 

## Objetivo
Desenvolver uma a aplicação web que permita cadastrar,
atualizar e remover um registro (CRUD) , e exiba os registros em uma listagem
semelhante ao exemplo informado no site http://todomvc.com/examples/angularjs/#/.

## Sistema
A aplicação foi desenvolvida usando Spring Boot como base. O JSF é habilitado usando a biblioteca Joinfaces que facilita a integração com o Spring Boot. Para conexão com o banco de dados, foi utilizado a especificação padrão do JPA, fazendo uso do Spring Data. 

A comunicação com o frontend é feita através de um controller (Spring MVC) em escopo de visão, que permite um melhor gerenciamento do estado da aplicação, e que melhor se encaixa na proposta da aplicação. A comunicação com o banco é feita através da camada de serviço.

No frontend foi utilizado o Primefaces, com seus componentes de javascript e o Bootstrap 4.

A biblioteca Lombok, teve seu uso apenas para facilitar na criação de getters e setters, no entanto, é uma ferramenta bastante poderosa.


## Itens implementados
A, B, C, D, E, F, G, J

## Tecnologias e Bibliotecas Utilizadas

* JSF 
* Primefaces
* Spring Boot
* Spring Data JPA
* Spring MVC
* Bootstrap 4
* Lombok



## Executando localmente

```
mvn spring-boot:run -Dspring-boot.run.arguments="--HOST=172.17.0.3" -Dspring-boot.run.jvmArguments="-Dspring.datasource.username=todo_user -Dspring.datasource.password=Abcd123*"
```