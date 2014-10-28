package edu.ulima.mains;

import edu.ulima.entidad.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Query1 {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    /*
        Uso de JP-QL
    */
    public static void main(String[] args) {
        Query1 q1 = new Query1();
        q1.cargaPU();
        q1.usandoQuery();
        q1.usandoTypedQuery();
        q1.usandoNamedQuery();
    }
    
    private void cargaPU(){
        emf = Persistence.createEntityManagerFactory("Clase33PU");
        em = emf.createEntityManager();
    }
    
    private void usandoQuery(){
        System.out.println("********* Query ********");
        String jpql ="SELECT e from Empleado e where e.apellido=?1";
        Query q =em.createQuery(jpql);
        q.setParameter(1, "UTONIO");
        List l = q.getResultList();
        for (Object element : l){
            Empleado e = (Empleado)element;
            System.out.println(element);
        }
        
    }
    
    private void usandoNamedQuery(){
        System.out.println("\n\n********* Query NamedQuery ********");
        Query q = em.createNamedQuery("Empleado.findByApellido");
        q.setParameter("apellido", "UTONIO");
        List l = q.getResultList();
        for (Object element : l){
            Empleado e = (Empleado)element;
            System.out.println(element);
        }
    }
    
    private void usandoTypedQuery(){
        System.out.println("\n\n********* Query Typed ********");
        String jpql="SELECT e from Empleado e where e.apellido=?1";
        TypedQuery<Empleado> q = em.createQuery(jpql, Empleado.class);
        q.setParameter(1, "UTONIO");
        List<Empleado> l = q.getResultList();
        for (Empleado element : l){
            
            System.out.println(element);
        }
    }
    
    
    
}
