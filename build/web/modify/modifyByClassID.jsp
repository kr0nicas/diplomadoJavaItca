<%-- 
    Document   : modifyByClassID
    Created on : 05-05-2012, 04:24:53 PM
    Author     : DELL
--%>

<%@page import="PersistenceClass.Employees"%>
<%@page import="javax.persistence.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   <%
            
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
              EntityManager em = emf.createEntityManager();
              
              Employees emp = em.find(Employees.class, 2);
              
              
              em.getTransaction().begin();
              emp.setCountry("El Salvador");
              em.persist(emp);
              em.getTransaction().commit();
              em.close();
              emf.close();
              
              
              
              %>                

    </body>
</html>
