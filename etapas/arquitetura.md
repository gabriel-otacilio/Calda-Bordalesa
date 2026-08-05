# Arquitetura DAO patterns

Nesse minitrabalho estou a usar a arquitetura em camadas com a  DAO patterns, que separa as funcionalidades em : acessa o BD e não acessa o BD.

Ela é composta por teres elementos : Controler, Service, Entity e Repository/DAO.

## Camada de serviços:

- A camada de serviços / regras de negócio, chama um metodo na interface DAO/ repository.
Por padrão não tem nenhum metodo de interação com o banco de dados (CRUD) nessa camada.
EX: ``usuerDao.lerPorId(1)``.  Estou chamando um metodo dentro de userDao que vai ler por um ‘id’, provavelmente deve-me retornar um ‘user’.

- Ou seja : ``userService -> userDao -> BD`` 

## Camada de acesso a dados(DAO ou Repository):

- A implementação 'concreta' da DAO executa a operação necessaria no banco de dados. No caso
- ``SELECT * FROM users WHERE id = 1``
- A Dao por sua vez retorna os dados, geralmente empacotados como um 'objeto de negocio', ela retorna como se fosse um objeto mesmo

# E com o Spring? Como que fica?

## Mapemanto JPA/Spring VS Conceittos Dao Patterns

![img.png](img.png)

- A DAO acaba virando o repository, pq o Spring ja faz tudo pra gente.
