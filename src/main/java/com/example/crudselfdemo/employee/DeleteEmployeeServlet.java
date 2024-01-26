package com.example.crudselfdemo.employee;

import com.example.crudselfdemo.modal.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-employee.do")
public class DeleteEmployeeServlet extends HttpServlet {

    private EmployeeDao employeeDao = new EmployeeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("empId"));

        if(id > 0)
        {
            Employee employee = employeeDao.getEmployeeById(id);

            if(employee != null)
            {
                employeeDao.deleteEmployee(id);

                response.sendRedirect(request.getContextPath() + "/employee-list.do");
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
        doGet(request, response);
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);

        request.setAttribute("employees", employeeDao.getEmployeeList());

        request.getRequestDispatcher("/WEB-INF/view/employee-list.jsp").forward(request, response);
    }
}
