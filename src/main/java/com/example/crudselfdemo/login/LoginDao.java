package com.example.crudselfdemo.login;

import com.example.crudselfdemo.dao.ConnectionManager;
import com.example.crudselfdemo.modal.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao
{
    private final static String LOGIN_QUERY = "SELECT id,username,email FROM users WHERE username=? AND password=?";

    public User getUserByUsernameAndPasswod(String username, String password)
    {
        Connection connection = null;

        User dbUser = null;

        try
        {
            connection = ConnectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(LOGIN_QUERY);

            statement.setString(1, username);

            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if(rs.next())
            {
                int id = rs.getInt("id");

                String dbUsername = rs.getString("username");

                String email = rs.getString("email");

                dbUser = new User(id, dbUsername, email);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            ConnectionManager.closeConnection(connection);
        }

        return dbUser;
    }
}
