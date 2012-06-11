
<%@page import="PersistenceClass.Employees"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.persistence.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DElete by Lastname Single</title>
    </head>
    <body>
        <%
            
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
              EntityManager em = emf.createEntityManager();
              Query resultado = em.createNamedQuery("Employees.findByLastName");
              resultado.setParameter("lastName", "fuller");
              Employees emp = (Employees) resultado.getSingleResult();
              em.getTransaction().begin();
              emp.setCountry("El Salvador");
              em.persist(emp);
              em.getTransaction().commit();
              em.close();
              emf.close();
              
              
              
              %>
    </body>
</html>
