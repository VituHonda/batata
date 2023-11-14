package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionTest {

    public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();

        try (Connection connection = connectionManager.getConnection()) {
            if (connection != null) {
                System.out.println("Conexão com o banco de dados bem-sucedida.");

                // Exemplo: Execute uma consulta simples para verificar se a conexão está funcionando
                String sql = "SELECT 1 FROM DUAL";
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int result = resultSet.getInt(1);
                        System.out.println("Resultado da consulta: " + result);
                        // Você pode adicionar mais lógica conforme necessário
                    }
                }
            } else {
                System.out.println("A conexão com o banco de dados falhou.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
