package com.qulix.sitkinke.trainingtask.servlets;

import com.qulix.sitkinke.trainingtask.entities.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(2, "Array", "aaa", "sssss", "gfg"));
        employees.add(new Employee(3, "konstan", "dsd", "aaa", "gff"));
        employees.add(new Employee(4, "magicko", "aaa", "sssss", "gfg"));
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
    }
}