package com.example.crudselfdemo.employee;

import com.example.crudselfdemo.dao.ConnectionManager;
import com.example.crudselfdemo.modal.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao
{
    private final static String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";

    private final static String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id=?";

    private final static String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=?";

    private final static String UPDATE_EMPLOYEE = "UPDATE employee SET first_name=?, last_name=?, email=? WHERE id=?";

    private final static String INSERT_EMPLOYEE = "INSERT INTO employee (first_name,last_name,email) VALUES (?,?,?)";


    public List<Employee> getEmployeeList()
    {
        Connection connection = null;

        List<Employee> employees = new ArrayList<>();

        try
        {
            connection = ConnectionManager.getConnection();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(SELECT_ALL_EMPLOYEE);

            while (rs.next())
            {
                int id = rs.getInt("id");

                String firstName = rs.getString("first_name");

                String lastName = rs.getString("last_name");

                String email = rs.getString("email");

                employees.add(new Employee(id, firstName, lastName, email));
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

        return employees;
    }

    public Employee getEmployeeById(int id)
    {
        Connection connection = null;

        Employee employee = null;

        try
        {
            connection = ConnectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next())
            {
                int empId = rs.getInt("id");

                String firstName = rs.getString("first_name");

                String lastName = rs.getString("last_name");

                String email = rs.getString("email");

                employee = new Employee(id, firstName, lastName, email);
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

        return employee;
    }

    public void insertEmployee(Employee employee)
    {
        Connection connection = null;

        try
        {
            connection = ConnectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE);

            statement.setString(1, employee.getFirstName());

            statement.setString(2, employee.getLastName());

            statement.setString(3, employee.getEmail());

            statement.executeUpdate();

            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            ConnectionManager.closeConnection(connection);
        }
    }

    public void updateEmployee(Employee employee)
    {
        Connection connection = null;

        try
        {
            connection = ConnectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);

            statement.setString(1, employee.getFirstName());

            statement.setString(2, employee.getLastName());

            statement.setString(3, employee.getEmail());

            statement.setInt(4, employee.getId());

            statement.executeUpdate();

            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            ConnectionManager.closeConnection(connection);
        }
    }

    public void deleteEmployee(int empId)
    {
        Connection connection = null;

        try
        {
            connection = ConnectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);

            statement.setInt(1, empId);

            statement.executeUpdate();

            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            ConnectionManager.closeConnection(connection);
        }
    }
}
