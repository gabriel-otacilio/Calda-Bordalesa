# Como funciona a servcie/Aplication no spring
- ## Recuperando dados do front-end:
    - De modo geral existem dois modos específicos no spring para recuperar dados do front-end: Utilizando json e form-data e utilizando um formulario html comum
    - Pode-se usar javascript e utilizar a função de fetch para recuperar os dados e enviar para o back-end no formato json e pra recuperar eu utilizo o @RequestBody
    - **@RequestBody já transforma o json em objeto usuario**
    - EX: 1°) No Front-end: 2°) No Back-end:
    - ```JavaScript
        fetch('http://localhost:8080/usuarios', {
        method: 'POST',
        body: JSON.stringify(usuario),
        headers: { 'Content-Type': 'application/json' }
        })
        ```
      ````java
        @RestController
        @RequestMapping("/usuarios")
        public class UsuarioController {
            @PostMapping
            public String cadUser(@RequestBody Usuario usuario){
                return "recebido" + usuario.getNome();
                  // aqui ele ja vai tranforma o meu json em objeto usuario        
            }
        }
        ````
      
    - Ou pode recuperar dados direto de um <form> html comum:
    - EX:
    - `````html
        <form action="/usuario/cadastrar" method="post">
            <input type="text" name="nome">
            <input type="number" name="idade">
            <button type="submit">Enviar</button>
        </form>
        `````
    - `````java
        @PostMapping("/usuario/cadastrar")
        public String cadastrar(@RequestParam String nome, @RequestParam int idade){
            return "nome: " + nome + " idade: " + idade;

        }
        `````
      aqui ele recupera os dados do formulario html comum que estao nos campos com os mesmos nomes que eu coloquei no @RequestParam

## Como eu vou mostrar os dados que o back-end me enviou? 
- é necessario um pouco de conhecimento do thymelef que eu tbm n tenho nesse momento entao vou ralar aqui
