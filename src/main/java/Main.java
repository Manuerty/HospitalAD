import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de EntityManagerFactory y EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            // Crear objetos Planta
            Planta planta1 = new Planta("Planta 1");
            Planta planta2 = new Planta("Planta 2");

            // Persistir las plantas
            em.getTransaction().begin();
            em.persist(planta1);
            em.persist(planta2);
            em.getTransaction().commit();

            // Crear objetos Consulta y asignarles una planta
            consulta consulta1 = new consulta("Consulta 1", planta1);
            consulta consulta2 = new consulta("Consulta 2", planta2);

            // Persistir las consultas
            em.getTransaction().begin();
            em.persist(consulta1);
            em.persist(consulta2);
            em.getTransaction().commit();

            // Crear un objeto Medico
            Medico medico = new Medico("12345678A", "123456789", "Dr. Perez", "Calle Falsa 123", "912345678", consulta1, List.of(new Visita("Apendicitis", Date.from(Instant.now()))));

            // Crear un objeto Enfermero
            Enfermero enfermero = new Enfermero("23456789B", "987654321", "Ana Lopez", "Calle Real 456", "912345679", "Consulta 2", medico, List.of("Mañana", "Tarde"));

            // Crear un objeto Limpieza
            Limpieza limpieza = new Limpieza("34567890C", "123456788", "Carlos Ruiz", "Calle Falsa 789", "912345680", List.of("Planta 1", "Planta 2"), List.of("Mañana", "Noche"));

            // Crear un objeto Celador
            Celador celador = new Celador("45678901D", "112233445", "Javier Gómez", "Calle Verdadera 321", "912345681", List.of("Tarde", "Noche"));

            // Comenzar una transacción
            em.getTransaction().begin();

            // Persistir los objetos en la base de datos
            em.persist(medico);
            em.persist(enfermero);
            em.persist(limpieza);
            em.persist(celador);

            // Confirmar la transacción
            em.getTransaction().commit();

            System.out.println("Datos guardados con éxito!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
