package edu.ulima.mains;

import edu.ulima.entidad.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test01 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clase33PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Empleado.findAll");
        List <Empleado> li = q.getResultList();
        
        for (Empleado element : li){
            
            System.out.println(element);
            System.out.println(element.getParkingId().getLote());
        }
        
    }
    
}
