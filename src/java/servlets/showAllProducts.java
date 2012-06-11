/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import PersistenceClass.Employees;
import PersistenceClass.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "showAllProducts", urlPatterns = {"/showAllProducts"})
public class showAllProducts extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
            EntityManager em = emf.createEntityManager();
            Query result = em.createNamedQuery("Products.findAll");
            java.util.List Lista = result.getResultList();
            Iterator ListaFinal = Lista.iterator();
            out.println("<table border='1' bgcolor='green'>");
            while(ListaFinal.hasNext()){
                Products product = (Products)ListaFinal.next();
             out.println("<tr>");
             out.println("<td>"+ product.getProductID() +"</td>");
             out.println("<td>"+ product.getProductName() +"</td>");
             out.println("<td>"+ product.getQuantityPerUnit() +"</td>");
             out.println("<td>"+ product.getUnitPrice() +"</td>");
             out.println("</tr>");
            }
            out.println("</table>");
            em.close();
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
