# GerenciamentoEstoque
Uma aplicação CRUD de gerenciamento de estoque web desenvolvida no padrão MVC em Java e construída com o Spring Boot,  banco de dados (MySQL). Na camada de visualização foi utilizado o template Thymeleaf e o framework Bootstrap. O sistema possui outras funcionalidades como, tela de login/cadastro, criptografia de dados do usuário, entre outras.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Maven
- HTML/CSS/JS
- MySQL
- Thymeleaf
- Bootstrap

## Tela de login
![login](https://user-images.githubusercontent.com/25832382/213353549-f0591f05-fbf1-408f-9ca7-019914e8b45c.PNG)

## Tela de cadastro de usuário
![cadastro-usuario](https://user-images.githubusercontent.com/25832382/213353998-1bf55a13-44fb-488c-8d1e-3d386c6b4eca.PNG)

## Página Principal
![principal](https://user-images.githubusercontent.com/25832382/213354143-e62e9526-b684-4b5a-9e32-7633507da004.PNG)

## cadastro de Produto
![cadastro-produto](https://user-images.githubusercontent.com/25832382/213354212-843937d6-b54a-4c2a-a80c-67184cfb7a05.PNG)

## Tela de Categorias
![categoria](https://user-images.githubusercontent.com/25832382/213354261-5482f944-ea8a-47f2-a723-8d6b3f2b6ac7.PNG)

## Tela de listagem de Produtos
![listar-produtos](https://user-images.githubusercontent.com/25832382/213354372-a20c03af-f1be-44f5-959d-1a2c83c731df.PNG)

## Banco de dados
![banco](https://user-images.githubusercontent.com/25832382/213355053-a3bb2235-9f68-4b16-be2a-b1876275eec8.PNG)

## Instalação

Importar o projeto na IDE como um projeto Maven.

## Configurações do banco de dados
Criar um banco de dados MySQL com o nome sistema_estoque, as tabelas serão criadas automaticamente pelo Hibernate por meio das anotações nas entidades utilizando o mapemanro objeto-relacional. As configurações do banco ficam localizadas em src/main/resources/application.properties:

```
# DataSource
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_estoque?useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.testWhileIdle=true
spring.datasource.validationQuery=SELECT 1


# JPA
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

# Thymeleaf
spring.thymeleaf.mode=HTML
spring.thymeleaf.cache=false

```
 

## Execução
Execute o projeto através do IDE, acessar via url: http://localhost:8080




