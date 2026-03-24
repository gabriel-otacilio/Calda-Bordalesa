[//]: # (todo implementar os tutoriais de comando MySQL, conforme eu aprender)

# MySQL:
- ## lembrando que o Spring já faz isso para você.
- ## arquivo pra auxiliar nos comandos SQL
    - Depois de subir seu server MySQL, e fazer conexão pela a aba database do intelijjei é possivel rodar comando pra aquele servior, cria-se um esquema(schema)
  que vai ser nosso banco de dados em si. Tanto é que é no schema/database que vamos criar as tabelas.
    - Clicando no seu database e utilizar o atalho Ctrl+Shift+Q vc abre o query console, onde podemos digitar os comandos SQL.
***
- ### Comandos SQL:
- Criar tabela: CREATE TABLE nome_tabela (coluna1 tipo_coluna, coluna2 tipo_coluna,...)
- Exemplo: 
- ```sql 
    CREATE TABLE alunos (nome VARCHAR(255), idade INT, email VARCHAR(255));
***
- listar tabelas: SHOW TABLES;
- listar colunas de uma tabela: DESCRIBE nome_tabela;
- Exemplo: 
- ```sql
  DESCRIBE alunos
***
- inserir dados: INSERT INTO nome_tabela (coluna1, coluna2,...) VALUES (valor1, valor2,...);
- Exemplo: 
- ```sql
  INSERT INTO alunos (nome, idade, email) VALUES ('Gabriel', 22, '')**
***
- selecionar dados: SELECT * FROM nome_tabela;
- Exemplo: 
- ```sql
  SELECT * FROM alunos**
***
- atualizar dados: UPDATE nome_tabela SET coluna1 = novo_valor WHERE condicao;
- Exemplo: 
- ```sql
  UPDATE alunos SET nome = 'Gabriel' WHERE idade = 22**
***
- deletar dados: DELETE FROM nome_tabela WHERE condicao;
- Exemplo: 
- ```sql
  DELETE FROM alunos WHERE idade = 22**
  
***
- É interessante saber os conceitos de Primary_key:
    - é uma coluna que identifica cada registro de uma tabela unicamente, tipo um ID.
- Exemplo: 
- ```sql
  CREATE TABLE alunos (id INT PRIMARY KEY, nome VARCHAR(255), idade INT, email VARCHAR(255));
***
Ver os vídeos abaixo que explicam um pouco sobre a database e como faz a ligação com um trabalho java+Spring
 

**[video de como usar a aba database do intelijjei](https://www.youtube.com/watch?v=r755XVedukQ&t=29s)**

**[video sobre como conectar a aplicação java com seu BD](https://www.youtube.com/watch?v=70s7JsiaBRc&t=7s)**
- antigo mas funcional tbm
- tambem mostra "mapenado" uma entidade para o BD utilizando o Spring boot +hibernate

