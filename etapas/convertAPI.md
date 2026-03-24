# Spring MVC -> Spring em API REST

Nas outras branches usamos a renderização de tela por parte do servidor. Ou seja, não tínhamos uma parte de front-end.
Essa branch está dedicada a transformar antes o que era nosso trabalho de Spring Boot numa API REST java+Spring.
Agora consumindo essa API usando o axios+react.

## Passos

### 1.

Agora que o React vai ficar responsive por consumir a API, ele também ficara responsável por pegar os dados recebidos da
API e renderizar na tela.
Ou seja, não usaremos mais o thymeleaf. Não retornaremos mais as telas nas nossas controllers e sim os dados.
Retornaremos os dados em formato JSON da seguinte forma:
- GET: 
  - normalmente usamos o get pra pegar algo do banco de dados
  - retornaremos a lista, o dado em si ou algum comunicado de sucesso(após o sucesso)
````java
@GetMapping("/allPlantas")
public List<Planta> listarPlantas() {
    return user_service.listarPlantas();// o spring vai transformar automaticamente a lista em json
}
````
- POST:
  - normalmente usamos o post pra criar algo no banco de dados
  - retornaremos um comunicado do tipo "cadastrado com sucesso" ou se precisarmos retornar algo para o servidor o objeto DTO que precisarmos
````java
// primeiro exemplo de POST
//caldula a calda com certos parâmetros.
@PostMapping("/calcularCalda")
    public CaldaResponseDTO calcularCaldaPOST(@RequestBody CaldaRequestDTO request) {
        Planta planta = user_service.findById(request.idPlanta);

        double resultAgua=user_service.calcularCalda(
                request.idPlanta,
                request.volumeTotal,
                request.tipoConcentracao);

        double reagente = (request.volumeTotal*1000 - resultAgua)/2;
        return new CaldaResponseDTO(resultAgua, reagente, planta);

    }
// segundo exemplo de POST
//-------------------------------------------------------------------
    // cadastra uma planta
    @PostMapping("/cadPlanta")
    public String cadastrar(@RequestBody PlantaDTO planta) {
        user_service.cadPlanta(planta.nome, planta.concentracaoMax, planta.concentracaoMin, planta.descricao);
        return "planta cadastrada com sucesso!";
    }


````
- DELETE:
  -retornamos um aviso ou o objeto com o campo deletado.
````java
@DeleteMapping("/allPlantas/{id}")
    public String removerPlanta(@PathVariable int id) {
        user_service.removerPlanta(id);
        return "planta de id: " + id + " removida com sucesso!";

    }
````
---
- Pode-se observar que o que retornaremos vai depender muito do que estamos fazendo.
- Se precisamos voltar algum dado, retorna um objeto DTO com o campo
- Se precisamos receber algo recebe um objeto DTO com o campo com a tag `@RequestBody`
- Tudo vai depender do nosso desenvolvimento e a nossa necessidade.


___

#### Classe DTO para que serve

- DTO
    - é importante ir criando minhas classes DTO conforme as minhas controllers e as request/response que eu precisar
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