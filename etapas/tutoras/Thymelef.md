[//]: # (Arquivo de apoio – Thymeleaf)

# Thymeleaf – Guia de Funcionamento e Principais Atributos

Este documento apresenta uma visão geral do **Thymeleaf**, explicando como ele funciona em aplicações **Spring Boot** e listando seus **principais atributos (tags)** com exemplos práticos.

---

## 1. O que é o Thymeleaf?

O **Thymeleaf** é um **template engine** para Java, muito utilizado com **Spring Boot**, que permite criar páginas HTML dinâmicas no servidor.

Ele processa arquivos HTML, substituindo expressões e atributos especiais (`th:*`) por dados enviados pelo backend.

📌 Diferente de outras engines, o HTML do Thymeleaf é **válido mesmo sem processamento**, facilitando testes e manutenção.

---

## 2. Funcionamento Geral com Spring Boot

Fluxo básico:

1. O navegador faz uma requisição (GET ou POST)
2. O **Controller** do Spring recebe a requisição
3. O Controller adiciona dados ao `Model`
4. O Spring chama o template Thymeleaf
5. O Thymeleaf processa o HTML
6. O HTML final é enviado ao navegador

---
## ⚙️ Configuração Básica (Spring Boot)

```xml
<!-- No pom.xml -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### Exemplo de Controller
```java
@GetMapping("/alunos")
public String listarAlunos(Model model) {
    model.addAttribute("nome", "Gabriel"); // aqui eu jogo essa variavel pra dentro do html
    return "alunos"; // alunos.html
} 
```

Localização dos arquivos HTML: src/main/resources/templates/

# Principais tags:
- substituição de texto:
````html
<p th:text="${mensagem}">Texto padrão que aparece no preview</p>
<span th:text="'Olá, ' + ${nome}">Olá, visitante</span>
````
- iteração:
````html
<ul>
    <li th:each="item : ${listaItens}" th:text="${item.nome}">Item exemplo</li>
</ul>

<!-- Com status da iteração -->
<table>
    <tr th:each="produto, status : ${produtos}">
        <td th:text="${status.index}">0</td>
        <td th:text="${produto.nome}">Nome produto</td>
        <td th:text="${produto.preco}">99.99</td>
    </tr>
</table>
````
- condicionais:
````html
<p th:if="${usuario.logado}">Bem-vindo de volta!</p>
<p th:unless="${usuario.logado}">Por favor, faça login</p>

<!-- th:switch / th:case -->
<div th:switch="${usuario.tipo}">
    <p th:case="'admin'">Acesso administrativo</p>
    <p th:case="'user'">Acesso de usuário</p>
    <p th:case="*">Acesso desconhecido</p>
</div>
````
- bind de objetos:
````html
<form th:object="${usuario}" th:action="@{/salvar}" method="post">
    <input type="text" th:field="*{nome}" placeholder="Nome">
    <input type="email" th:field="*{email}" placeholder="E-mail">
    <button type="submit">Salvar</button>
</form>
````

- URL's:
````html
<a th:href="@{/produtos/{id}(id=${produto.id})}">Ver produto</a>
<a th:href="@{/produtos(id=${produto.id}, page=1)}">Produtos página 1</a>
<img th:src="@{/imagens/logo.png}">
<form th:action="@{/login}" method="post">
````
- atributos dinamicos:
````html
<img th:attr="src=@{/img/${imagem.nome}}, alt=${imagem.descricao}">
<div th:attr="data-id=${produto.id}, data-categoria=${produto.categoria}"></div>
````

- varivaies locais:
````html
<div th:with="precoTotal=${produto.preco * quantidade}">
    Total: <span th:text="${precoTotal}">0</span>
</div>
````




