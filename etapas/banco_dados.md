# Banco de dados

- ## Estrutura do MySQL:
     - Subo o server dentro dele tem **SCHEMAS** ou **DATABASES**
     - dentro de cada schema/ database tem **TABELAS**
     - uso uma **Tabela** para cada entidade do meu projeto
***
- **Veririfcar comandos sql em arquivo tutoras/mySQL**
***
- ## Criar o meu banco:
    - eu subi um banco mysql num container docker, mas se quiserem podem usar um metodo tradicional pelo mysql
      workbench;

---

- ## Preparar o ambiente:
    - Colcoar a extensão do mysql no java:
        - Levando em Consideração que o projeto foi criado com maven é adicionar a seguinte tag no ``pom.xml`` dele.
      ```xml
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>8.0.21</version>
      </dependency>
      ```

***
- ## Implementação
    - ### Criar uma classe java que vai ficar Responsavel pela a conexão, captura e guardar dados do banco:
        - olhar na pasta **JDBC**
        - **Conexão:**
            - oque é : A ponte entre a sua aplicação java e o banco de dados
            - Serve para : Estabelecer a comunicação com o MySQL
        - **Statement/PreparedStatement:**
            - O que é : o objeto que carrega seu comando SQL
            - Serve para: Executar comando no banco
            - Analogia: é como um 'carteiro' que vai levar a sua mensagem (SQL) para o banco
          ```java
          Statement stmt = conexao.createStatement();
            ```
        - **ResultSet**
            - O que é : o objeto que vai guardar os dados retornados de uma consulta
            - Serve para: Ler os dados que o banco te devolveu
            - Analogia: é como uma caixa com os resultados da sua busca
          ```java 
            ResultSet rs = stmt.executeQuery(); // executa e guarda os resultados
            ```
        - **prestar atenção nos campos de senha, user e data_base, eles vao mudar conforme o banco que vc vai usar;**

***

- ### Fluxo correto
  #### 1. Abrir conexão (Connection)
  #### 2. Criar comando SQL (PreparedStatement)
  #### 3. Executar comando SQL (Statement)
  #### 4. Receber dados do banco (ResultSet)
  #### 5. usar dados
  #### 6. Fechar dados
    - ##### exemplo :
```java      - 
public static void buscarUsuarios() {
    // 1️⃣ Declarar os recursos fora do try
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // 2️⃣ ABRIR a conexão
        conn = JDBC.getConnection();
        System.out.println("✅ Conexão aberta");

        // 3️⃣ CRIAR o comando SQL
        String sql = "SELECT id, nome, email FROM usuarios";
        stmt = conn.prepareStatement(sql);
        System.out.println("✅ Statement criado");

        // 4️⃣ EXECUTAR e receber os resultados
        rs = stmt.executeQuery(); // executeQuery() retorna ResultSet
        System.out.println("✅ Query executada");

        // 5️⃣ USAR os dados (navegar pelo ResultSet)
        while (rs.next()) { // next() move para a próxima linha
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");

            System.out.println("ID: " + id + " | Nome: " + nome + " | Email: " + email);
        }

    } catch (SQLException e) {
        System.err.println("❌ Erro: " + e.getMessage());

    } finally {
        // 6️⃣ FECHAR tudo (ordem inversa da criação!)
        if (rs != null) try { rs.close(); } catch (SQLException e) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
        if (conn != null) try { conn.close(); } catch (SQLException e) {}
        System.out.println("✅ Recursos fechados");
    }
}    
 ```