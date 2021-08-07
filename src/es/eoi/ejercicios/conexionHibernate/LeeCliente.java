package es.eoi.ejercicios.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LeeCliente {

    public static void main(String[] args){
        SessionFactory miFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session miSession = miFactory.openSession();

        try {
            //Comenzamos la transaccion de Hibernate
            miSession.beginTransaction();

            // Leemos el objeto de tipo cliente de nuestra base de datos
            Clientes clienteLeido = miSession.get(Clientes.class, 2);

            //Ahora o bien hacemos commit y lo persistimos en la BBDD o rollback y aquí no ha pasado nada :)
            miSession.getTransaction().commit();

            //Si ha ido bien nos mostrará el mensaje
            System.out.println("Cliente " +  clienteLeido.getNombre() + " obtenido de la base de datos!!");
            System.out.println(clienteLeido);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            miFactory.close();
        }

    }
}
