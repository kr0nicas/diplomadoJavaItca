
<%@page import="javax.persistence.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select products and suppliers</title>
    </head>
    <body>
        <h1>Select products and suppliers</h1>
        
        <% 
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
              EntityManager em = emf.createEntityManager();
              
              Query nq = em.createNativeQuery("SELECT p.ProductName, s.CompanyName "
                      + "FROM products p INNER JOIN suppliers s on p.SupplierID = s.SupplierID");
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
