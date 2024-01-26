package com.example.crudselfdemo.employee;

import com.example.crudselfdemo.modal.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/employee-list.do")
public class EmployeeListServlet extends HttpServlet {

    private EmployeeDao employeeDao = new EmployeeDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employees = employeeDao.getEmployeeList();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/WEB-INF/view/employee-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
