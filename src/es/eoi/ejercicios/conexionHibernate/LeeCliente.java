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

            //Si ha ido bien nos mostrará el mensaje
            System.out.println("Cliente " +  clienteLeido.getNombre() + " obtenido de la base de datos!!");
            System.out.println(clienteLeido);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Cerramos sesión y factory");
            miSession.close();
            miFactory.close();
        }

    }
}
