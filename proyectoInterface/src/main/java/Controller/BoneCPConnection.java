package Controller;

import Connection.BoneCPImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian
 */

public class BoneCPConnection extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BoneCPConnection</title>");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"jumbotron text-center\">");
            out.println("<h1>Colores HTML</h1>");
            out.println("</div>");
            out.println("<div class=\"container-fluid\">");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-sm-3\"></div>");
            out.println("<div class=\"col-sm-6\">");
            out.println("<h3>Servlet BoneCPConnection at " + request.getContextPath() + "</h3>");
            Class.forName("com.mysql.jdbc.Driver");
            out.println("<h4>Conectando ... </h4>");
            BoneCPImpl oBone = new BoneCPImpl();
            Connection oConnection = oBone.newConnection();
            out.println("<h4>Conectado ... </h4>");
            PreparedStatement stmt = oConnection.prepareStatement("SELECT * FROM color");
            ResultSet resultSet = stmt.executeQuery();
            out.print("<table class=\"table table-striped\">");
            out.print("<tr><th>ID</th><th></th><th>Nombre</th><th>Código HTML</th><th>Código RGB</th></tr>");
            while (resultSet.next()) {
                out.print("<tr><td>" + resultSet.getInt("id") + "</td><td style=\"background-color:" + resultSet.getString("codHTML") + "\"></td><td>" + resultSet.getString("nombre") + "</td><td>" + resultSet.getString("codHTML") + "</td><td>" + resultSet.getString("codRGB") + "</td></tr>");
            }
            out.print("</table>");
            oBone.disposeConnection();
            out.println("<h4>Desconectando ... </h4>");
            out.println("</div>");
            out.println("<div class=\"col-sm-3\"></div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BoneCPConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BoneCPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BoneCPConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BoneCPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
