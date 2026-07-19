package com.student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.student.model.StudentDAO;
import com.student.model.Studentmod;

import javax.servlet.annotation.WebServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/ViewStudent")
public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{

        List<Studentmod> list = StudentDAO.getAllStudent();
        System.out.println("List :"+list);

        req.setAttribute("students",list);
        RequestDispatcher rd = req.getRequestDispatcher("ViewStudent.jsp");
        System.out.println("view page working");
        rd.forward(req,res);


    }
}