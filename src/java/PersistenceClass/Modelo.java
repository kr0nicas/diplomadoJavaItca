/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenceClass;

import javax.persistence.*;

/**
 *
 * @author DELL
 */
public class Modelo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnitPersistence");
    EntityManager em = emf.createEntityManager();
    
    public int deleteByID(int id){
        
        Query query = em.createNativeQuery("DELETE e FROM Employees e WHERE e.employeeID = ?");
        query.setParameter(1, id);
        return query.executeUpdate();     
    }
}


