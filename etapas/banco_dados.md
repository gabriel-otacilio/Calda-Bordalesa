# Banco de dados

- ## Criar o meu banco:
    - eu subi um banco mysql num container docker, mas se quiserem podem usar um metodo tradicional pelo mysql workbench;

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
    - Criar uma classe java que vai ficar Responsavel ela a conexão 
        - olhar no arquivo JDBC 
            - método de abrir conexão e fechar conexão
