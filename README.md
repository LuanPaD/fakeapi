# API com Spring Boot

Este projeto é uma API RESTful desenvolvida com Java e Spring Boot. O objetivo principal é consumir os dados de produtos da API pública [Fake Store API](https://fakestoreapi.com), persisti-los em um banco de dados e expor endpoints para operações de CRUD (Criar, Ler, Atualizar e Deletar) sobre esses produtos.

A API está documentada utilizando Swagger para facilitar a visualização e o teste dos endpoints.

## ✨ Tecnologias Utilizadas

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-black?style=for-the-badge&logo=openjdk" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring_Boot-3-black?style=for-the-badge&logo=spring-boot" alt="Spring Boot 3">
  <img src="https://img.shields.io/badge/Spring_Data_JPA-black?style=for-the-badge&logo=spring" alt="Spring Data JPA">
  <img src="https://img.shields.io/badge/Lombok-black?style=for-the-badge&logo=lombok" alt="Lombok">
  <img src="https://img.shields.io/badge/PostgreSQL-black?style=for-the-badge&logo=postgresql" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Swagger-black?style=for-the-badge&logo=swagger" alt="Swagger">
  <img src="https://img.shields.io/badge/Maven-black?style=for-the-badge&logo=apache-maven" alt="Maven">
</p>

<p align="center">
  <a href="https://www.java.com" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="45" height="45"/> 
  </a>
  <a href="https://spring.io/" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="spring" width="45" height="45"/> 
  </a>
  <a href="https://www.postgresql.org" target="_blank"> 
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" alt="postgresql" width="45" height="45"/> 
  </a>
  <a href="https://swagger.io/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/swagger/swagger-original.svg" alt="swagger" width="45" height="45"/>
  </a>
   <a href="https://maven.apache.org/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/maven/maven-original.svg" alt="maven" width="45" height="45"/>
  </a>
</p>

## 📖 Acessando a Documentação Swagger

Com a aplicação em execução, você pode acessar a interface do Swagger para visualizar e interagir com todos os endpoints disponíveis. Abra seu navegador e acesse:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 📡 Endpoints da API

A URL base para todos os endpoints é `http://localhost:8080/produtos`.

| Método HTTP | Endpoint        | Descrição                                                                      | Corpo da Requisição (Body) |
| :---------- | :-------------- | :----------------------------------------------------------------------------- | :------------------------- |
| `POST`      | `/`             | Busca a lista de produtos da `fakestoreapi.com` e salva no banco de dados local. | Vazio                      |
| `GET`       | `/`             | Retorna a lista de todos os produtos salvos no banco de dados local.             | Vazio                      |
| `GET`       | `/{nome}`       | Busca e retorna um produto específico pelo seu nome.                             | Vazio                      |
| `POST`      | `/api`          | Cria e salva um novo produto no banco de dados.                                  | `ProductsDTO`              |
| `PUT`       | `/?id={id}`     | Atualiza um produto existente no banco de dados, identificado pelo seu ID.       | `ProductsDTO`              |
| `DELETE`    | `/?nome={nome}` | Deleta um produto do banco de dados, identificado pelo seu nome.                 | Vazio                      |

### Exemplo de Objeto `ProductsDTO`

```json
{
  "title": "Produto de Exemplo",
  "price": 199.99,
  "description": "Esta é uma descrição do produto de exemplo.",
  "category": "eletronicos",
  "image": "url_da_imagem.jpg"
}
