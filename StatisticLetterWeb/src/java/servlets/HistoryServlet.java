/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * the class of java servlet wich give information about history of calculating
 *
 * @author Rafał Miąsko
 * @version 4.0
 */
public class HistoryServlet extends HttpServlet {

    /**
     * statement variable
     */
    private Statement statement;
    /**
     *  con connection value
     */
    private Connection con;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * value for result from database
         */
        ResultSet result;

        try {

            /**
             * get attribute from context
             */
            ServletContext ctx = getServletContext();
            con = (Connection) ctx.getAttribute("mycon");
            if (con != null) {
                statement = con.createStatement();

                /**
                 * select history form database
                 */
                result = statement.executeQuery("SELECT ID,STRING,WYNIK  From Dane");

                /**
                 * show reults in jsp file
                 */
                request.setAttribute("bean", result);
                RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "You have the problem  with connect check your connect");
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
