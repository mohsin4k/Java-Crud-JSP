package com.example.crudselfdemo.employee;

import com.example.crudselfdemo.modal.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/update-employee.do")
public class UpdateEmployeeServlet extends HttpServlet {

    private EmployeeDao employeeDao = new EmployeeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("empId"));

        if(id > 0)
        {
            Employee employee = employeeDao.getEmployeeById(id);

            if(employee != null)
            {
                request.setAttribute("employee", employee);

                request.getRequestDispatcher("/WEB-INF/view/update-employee.jsp").forward(request, response);
            }
            else
            {
                handleError(request,response, "Employee not found with Id: [" + id + "]");
            }
        }
        else
        {
            handleError(request,response, "Invalid Employee Id");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));

        employeeDao.updateEmployee(new Employee(id, firstName,lastName, email));

        response.sendRedirect(request.getContextPath() + "/employee-list.do");

    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);

        request.setAttribute("employees", employeeDao.getEmployeeList());

        request.getRequestDispatcher("/WEB-INF/view/employee-list.jsp").forward(request, response);
    }
}
