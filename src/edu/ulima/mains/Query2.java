package edu.ulima.mains;

import edu.ulima.entidad.Departamento;
import edu.ulima.entidad.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Query2 {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    /*
        Uso de JP-QL
    */
    public static void main(String[] args) {
        Query2 q2 = new Query2();
        q2.cargaPU();
        
        q2.ejemplo2deJPQL();
    }
    
    private void cargaPU(){
        emf = Persistence.createEntityManagerFactory("Clase33PU");
        em = emf.createEntityManager();
    }
    
    private void ejemplodeJPQL(){
        String jpql = "Select e from Empleado e where e.apellido =?1 and e.ingreso >=?2";
        Query q = em.createQuery(jpql);
        q.setParameter(1, "UTONIO");
        q.setParameter(2, 1400);
        List l = q.getResultList();
        for ( Object element : l){
            Empleado e = (Empleado)element;
            System.out.println(e);
        }
        
    }
    private void ejemplo2deJPQL(){
        String jpql = "Select d,COUNT(e),MAX(e.ingreso) from Departamento d JOIN d.empleadoCollection e "
                + "Group by d";
        Query q = em.createQuery(jpql);
        List l = q.getResultList();
        for (int i=0;i<l.size();i++){
            Object [] element = (Object [])l.get(i);
            for (int j=0; j<element.length;j++){
                if ( element[j] instanceof Departamento){
                    System.out.println("DPTO ID: "+((Departamento)element[j]).getNombre());
                }
                if( element[j] instanceof Long){
                    System.out.println("Count: " + element[j]);
                }
                if( element[j] instanceof Integer){
                    System.out.println("Sueldo: " + element[j]);
                }
            }
        }
        
    }
    
}
