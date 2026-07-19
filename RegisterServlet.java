package com.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException,IOException {

        System.out.println("calling register enpoint");


        String name = req.getParameter("name");
        String emailid = req.getParameter("emailid");
        String password = req.getParameter("password");

//        System.out.println("Name=" + name +
//                ", Email=" + emailid +
//                ", Password=" + password);

        try {
            Connection con = DBConnection.getConnection();

            String sql = "insert into tbl_student(name,emailid,password) Values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,emailid);
            ps.setString(3,password);

            int result = ps.executeUpdate();


            System.out.println("Rows inserted"+result);

            if(result>0){
                res.sendRedirect("success.jsp");
            }
            else{
                res.sendRedirect("failed.jsp");

            }
        }
        catch (Exception e){
            e.printStackTrace();
            res.sendRedirect("error.jsp");
        }
    }
}




