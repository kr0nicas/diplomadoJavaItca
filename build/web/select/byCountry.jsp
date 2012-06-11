
<%@page import="PersistenceClass.Employees"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.persistence.* "%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find by Country</title>
        <link rel="stylesheet" href="../css/style.css" type="text/css">
    </head>
    <body>
        <h1>Search by country</h1>
        <div id="box1">
        <form action="byCountry.jsp" method="get">
            <label for="countryName">Ingrese el país a buscar</label>
            <input type="text" size="20" name="countryName" id="countryName" />
            <input type="submit" value="Enviar" name="buscar">
        </form>
            
           
                <% 
                if (request.getParameter("buscar")!= null){
                    String cn = request.getParameter("countryName");
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
                    EntityManager em = emf.createEntityManager();
                    Query resultado = em.createNamedQuery("Employees.findByCountry");
                    resultado.setParameter("country", cn);
                    java.util.List List = resultado.getResultList();
                    Iterator it =List.iterator();
                    out.println("<table border='0'>");
                    while(it.hasNext()){
                        Employees emp = (Employees)it.next();
                        out.println("<tr><td>"+ emp.getFirstName()+"</td>");
                        out.println("<td>"+ emp.getLastName()+"</td></tr>");
                    }
                    out.println("</table>");
                    em.close();
                    emf.close();
                }
                    
                %>
                </div> 
    </body>
</html>
