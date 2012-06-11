<%@page import="javax.persistence.*"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>By ID And LastName</title>
    </head>
    <body>
          <%
            
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
              EntityManager em = emf.createEntityManager();
              
              Query nq = em.createNativeQuery("SELECT e.EmployeeID, e.LastName "
                      + "FROM employees e");
              java.util.List lista = nq.getResultList();
              
              for(Object obj: lista){
                    out.println(((Object[])obj)[0]);
                    out.println("-");
                    out.println(((Object[])obj)[1]);
                    out.println("<br>");
                    
              }
              em.close();
              emf.close();
              
              
              
              %>                

    </body>
</html>
