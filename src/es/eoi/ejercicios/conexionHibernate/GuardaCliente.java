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
            Clientes cliente1 = new Clientes("Jose", "Martinez", 18, "Plaza Mayor");

            //Comenzamos la transaccion de Hibernate
            miSession.beginTransaction();

            // Guardamos el objeto de tipo cliente en nuestra base de datos
            miSession.save(cliente1);

            //Ahora o bien hacemos commit y lo persistimos en la BBDD o rollback y aquí no ha pasado nada :)
            miSession.getTransaction().commit();

            //Si ha ido bien nos mostrará el mensaje
            System.out.println("Cliente " +  cliente1.getNombre() + " almacenado en base de datos!!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            miFactory.close();
        }

    }
}
