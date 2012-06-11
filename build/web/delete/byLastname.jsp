

<%@page import="PersistenceClass.Employees"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Row by Lastname</title>
    </head>
    <body>
        <h1>Eliminar Empleado por Apellido</h1>
        <form action="byLastname.jsp" method="GET">
            <%
            
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
              EntityManager em = emf.createEntityManager();
              Query resultado = em.createNamedQuery("Employees.findAll");
              java.util.List List1 = resultado.getResultList();
              Iterator itr = List1.iterator();
              %>
              <select name="lastname">
              <% while(itr.hasNext()){
                  Employees emp = (Employees) itr.next(); %>
                  <option value="<%=emp.getEmployeeID() %>"> <%= emp.getLastName() %> </option>
             <%  }  %>
            </select>
            <input type="submit" name="btnOK" value="Borrar">
        </form>
            <% 
                if (request.getParameter("btnOK")!=null){
                    
                    int id = Integer.parseInt(request.getParameter("lastname"));
                    Employees emp = em.find(Employees.class, id);
                    em.getTransaction().begin();
                    em.remove(emp);
                    em.getTransaction().commit();
                    
                      
                 em.close(); emf.close();   
                }
            %>
    </body>
</html>
