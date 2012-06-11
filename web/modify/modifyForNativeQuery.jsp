
<%@page import="javax.persistence.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modify for a native query</h1>
        
        <%
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
              EntityManager em = emf.createEntityManager();
              
              em.getTransaction().begin();
              Query nq = em.createNativeQuery("UPDATE employees "
                      + "set LastName='PEREZ' WHERE employeeID=3 ");
              nq.executeUpdate();
              em.getTransaction().commit();
              em.close();
              emf.close();
              
        %>
        
    </body>
</html>
