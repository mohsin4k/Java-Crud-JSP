package com.example.crudselfdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/crud";

    private static final String JDBC_USER = "root";

    private static final String JDBC_PASSWORD = "12345";

    static
    {
        //Load MYSQL Connector class
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();

            throw new RuntimeException("MYSQL Class not load");
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void closeConnection(Connection connection)
    {
        if(connection != null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
