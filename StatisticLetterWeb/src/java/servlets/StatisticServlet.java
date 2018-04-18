/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.StatisticDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import model.LetterModel;
import model.WrongArgumentsException;

/**
 * the Servlet StatisticServlet return paramaters with the score of the
 * statistic and save to the database
 *
 * @author Rafał Miąsko
 * @version 4.0
 */
public class StatisticServlet extends HttpServlet {

    /**
     * private variable con
     */
    private Connection con;

    /**
     * object StatisticDAO 
     */
    StatisticDAO art = new StatisticDAO();

    /**
     * the method processRequest for doing something in servlets Processes
     * requests for both HTTP <code>GET</code> and <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     * @throws ServletException if a servlet-specific error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            ServletContext ctx = getServletContext();
            
             //get connection attribute
             
            con = (Connection) ctx.getAttribute("mycon");

            if (con != null) {

                PrintWriter out = response.getWriter();

                
                 //get parameters from input
                 
                String texts = request.getParameter("type");

                if (!texts.isEmpty()) {
                    String temp = texts.toUpperCase().replace(" ", "");

                    
                     // get attribute (Object) LetterModel from servlet context listener
                     
                    LetterModel letter = (LetterModel) ctx.getAttribute("lettermodel").getClass().newInstance();
                    letter.hashmap(temp);
                    letter.resultOfSum(temp);

                    //write calculate  database
                    art.setString(texts);
                    art.setScore(letter.getSumResult());

                    //if string is null get error
                    if (art.getString() == null) {
                        request.setAttribute("error", "Your string text is null check your data");
                        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                        rd.forward(request, response);

                    } else {
                        // insert to table  
                        Statement statement = con.createStatement();
                        statement.executeUpdate("INSERT INTO Dane(STRING,WYNIK) VALUES ( '" + art.getString() + "'," + art.getScore() + ")");
                    }
                }

                //Cookies
                Cookie text = new Cookie("text", art.getString());
                String textss;
                response.addCookie(text);
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {

                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("text")) {
                            //get cookies
                            textss = cookie.getValue();
                            out.println("  your previous string is  " + textss);

                        }
                    }
                } else {
                    out.println(" our previous string is empty " + "<br/>");

                }

                // print message in browser
                out.println(" Your string now is " + " [ " + art.getString() + " ] " + " and score " + " [ " + art.getScore() + " ] ");

            } else {

                //print error in browser
                request.setAttribute("error", "You have the problem  with connect check your connect");
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }

        } catch (WrongArgumentsException ex) {

            request.setAttribute("error", "You must change the data and insert string text without digit or other characters");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);

        } catch (SQLException | InstantiationException | IllegalAccessException ex) {

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
