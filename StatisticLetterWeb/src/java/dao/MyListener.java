/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LetterModel;

/**
 * the class MyListener which is implement with ServletContextListener
 *
 * @author Rafał Miąsko
 * @version 4.0
 */
public class MyListener implements ServletContextListener {

    /**
     * connection variable
     */
    Connection con;

    /**
     * the model object
     */
    LetterModel lettermodel = new LetterModel();

    /**
     * method contextDestroyed for destroy the context servlet
     *
     * @param sce is the variable of servlet context listener
     *
     */
   
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {

            ex.getMessage();
        }
    }

    /**
     * method contextInitialized for init the servlet context
     *
     * @param sce is the variable of servlet context listener
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();
        
        //database url definied in web.xml "DBURL"
        String dburl = context.getInitParameter("DBURL");
        
        //database user definied in web.xml "DBUSER"
        String dbusername = context.getInitParameter("DBUSER");
        
        //database password definied in web.xml "DBPASS"
        String dbpassword = context.getInitParameter("DBPASS");
        
        //database driver definied in web.xml "DBDRIVER"
        String dbdriver = context.getInitParameter("DBDRIVER");

        try {
            if (Class.forName(dbdriver) != null) {
                con = DriverManager.getConnection(dburl, dbusername, dbpassword);

                if (con != null) {

                    //set the attribute context
                    context.setAttribute("mycon", con);
                    context.setAttribute("lettermodel", lettermodel);

                    // if table is'n exist create table
                    ResultSet res = con.getMetaData().getTables(null, null, "DANE", null);

                    if (res.next()) {

                        System.out.println("table is exists");

                    } else {

                        // create table
                        PreparedStatement pt = con.prepareStatement("CREATE TABLE Dane "
                                + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1),string VARCHAR(100), "
                                + " wynik FLOAT )");
                        pt.executeUpdate();

                    }

                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }

        System.out.println("Connection Establised.........");

    }

}
