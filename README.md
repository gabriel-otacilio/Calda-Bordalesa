#  Calda-Bordalesa

API para cálculo da dosagem de **calda bordalesa** (fungicida/bactericida natural à base de sulfato de cobre e cal) personalizada por **cultura agrícola**.

A proporção ideal de cada componente varia conforme a cultura (uva, tomate, café, citros, etc.) — usar uma receita genérica pode ser ineficaz ou até prejudicar a planta por excesso de cobre. Este projeto automatiza esse cálculo, recebendo a cultura e o volume desejado e retornando a dosagem correta de cada insumo.

## Stack

Java 21 · Spring Boot · Spring Data JPA · H2 · Maven

## Como rodar

```bash
git clone https://github.com/[seu-usuario]/Calda-Bordalesa.git
cd Calda-Bordalesa
./mvnw spring-boot:run
```

API aberta em `http://localhost:8080`.