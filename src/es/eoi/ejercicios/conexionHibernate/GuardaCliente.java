package es.eoi.ejercicios.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GuardaCliente {

    public static void main(String[] args){
        SessionFactory miFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session miSession = miFactory.openSession();

        try {
            Clientes cliente1 = new Clientes("Maria", "Perez", 25, "Plaza Mayor");

            //Comenzamos la transaccion de Hibernate
            miSession.beginTransaction();

            // Guardamos el objeto de tipo cliente en nuestra base de datos
            miSession.save(cliente1);

            //Ahora o bien hacemos commit y lo persistimos en la BBDD o rollback y aquí no ha pasado nada :)
            miSession.getTransaction().commit();

            //Si ha ido bien nos mostrará el mensaje
            System.out.println("Cliente " +  cliente1.getNombre() + " almacenado en base de datos!!");

            // Lectura de registro
            miSession.getTransaction();

            System.out.println("Lectura del registro con id " + cliente1.getId()); //No veremos que es un 0, no lo estamos recuperando

            System.out.println(cliente1);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Cerramos sesión y factory");
            miSession.close();
            miFactory.close();
        }

    }
}
