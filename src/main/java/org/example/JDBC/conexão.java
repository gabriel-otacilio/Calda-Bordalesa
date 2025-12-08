//package org.example.JDBC;
//
//import java.sql.*;
//// importando todas as manipulaçoes do Banco de dados
//public class conexão {
//    private static final String URL = "jdbc:mysql://localhost:3307/projeto_spring";
//    private static final String USER = "root";
//    private static final String PASSWORD = "root123";
//    // conectando as configurações do banco
//
//    private static Connection conn = null;
//    // se a conexão já existir ele reaproveita ??
//
//
//    public static Connection getConnection() throws SQLException{
//        if (conn == null || conn.isClosed()){
//            try {
//                conn = DriverManager.getConnection(URL, USER, PASSWORD);// cria a conexão
//                System.out.println("conexão estabelecida");
//                // tentar conectar
//            } catch (SQLException e ){
//                System.err.println("erro ao conectar"+e.getMessage());
//                // senao printa a mensagem e lança o erro
//                throw e;
//            }
//        }
//
//        return conn;
//        // retorna a conexão
//    }
//
//    public static  void closeConnection(){
//        if (conn != null){ // se a conexão existir
//            try {
//                conn.close();
//                System.out.println("conexão fechada");
//            } catch (SQLException e ){
//                System.err.println("erro a fechar conexão"+ e.getMessage());
//            }
//        }
//    }
//
//
//}
//
//
//// todo ver como mexer na aba database do intelijjei(1)(depois)
//// todo ver como salvar os dados do meu banco de dados usando o conceito de volumes do docker(0)
//
//todo ver muito mais sobre Spring boot]
//// todo continuar a implementação de planta ate adicionar no BD
// duplicação ?