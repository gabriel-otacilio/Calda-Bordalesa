package org.example;

import java.sql.*;
// importando todas as manipulaçoes do Banco de dados
public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3307/projeto_spring";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";
    // conectando as configurações do banco

    private static Connection connection = null;
    // se a conecxão ja existir ele reaproveita ??


    public static Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()){
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("conexão estabelecida");
                // tentar conectar
            } catch (SQLException e ){
                System.err.println("erro ao conectar"+e.getMessage());
                // senao printa a mensagem e lança o erro
                throw e;
            }
        }

        return connection;
        // retorna a conexão
    }

    public static  void closeConnection(){
        if (connection != null){ // se a conexão existir
            try {
                connection.close();
                System.out.println("conexão fechada");
            } catch (SQLException e ){
                System.err.println("erro a fechar conexão"+ e.getMessage());
            }
        }
    }
}
