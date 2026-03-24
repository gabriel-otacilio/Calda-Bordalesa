# Spring MVC -> Spring em API REST

Nas outras branches usamos a renderização de tela por parte do servidor. Ou seja, não tínhamos uma parte de front-end.
Essa branch está dedicada a transformar antes o que era nosso trabalho de Spring Boot numa API REST java+Spring.
Agora consumindo essa API usando o axios+react.

## Passos

### 1.

Agora que o React vai ficar responsive por consumir a API, ele também ficara responsável por pegar os dados recebidos da
API e renderizar na tela.
Ou seja, não usaremos mais o thymeleaf. Não retornaremos mais as telas nas nossas controllers e sim os dados

#### Classe DTO para que serve
- DTO
    - é uma classe simples sem regras de negócio que tem como finalidade apenas transportar os dados
    - desse modo é evitado a exposição da sua entidade direto do banco de dados
    - é manipulável quantos campos a rua API vai responder, a sua entidade pode ter 10 campos, mas você pode facilmente
      mandar apenas 3;
    - Cliente (React)<br>
      ↓<br>
      DTO (entrada)<br>
      ↓<br>
      Service / Regra de negócio<br>
      ↓<br>
      Entidade (Banco)<br>
      ↓<br>
      DTO (saída)<br>
      ↓<br>
      Cliente (React)<br>
      <br>
    - DTO serve pra:
      Controlar o que entra e sai da API<br>
      Proteger dados sensíveis<br>
      Evitar acoplamento com o banco<br>
      Melhorar organização do código <br>