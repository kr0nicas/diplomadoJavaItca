/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Annontations.myAnnotation;
import generalClass.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "showAnnotationEmployees", urlPatterns = {"/showAnnotationEmployees"})
public class showAnnotationEmployees extends HttpServlet {

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
           
            Employees emp = new Employees();
            emp.setSalary(500);
            Date bd = new Date();
            emp.setBirthDay(bd);
            
            //Se extraen campos de la clase
            Field props[] = Employees.class.getDeclaredFields();
            
            //se imprime anotacion completa de cada clase
            out.println(props[0].getAnnotations()[0]+"<br>");
            out.println(props[1].getAnnotations()[0]+"<br>");
            
            //truco programacional
            //se hace un cast con my Annotation para extraer las propiedades de la anotacion individualmente
            out.println(((myAnnotation)props[0].getAnnotations()[0]).id()+"<br>");
            out.println(((myAnnotation)props[0].getAnnotations()[0]).message()+"<br>");
            out.println(((myAnnotation)props[1].getAnnotations()[0]).id()+"<br>");
            out.println(((myAnnotation)props[1].getAnnotations()[0]).message());
            
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
