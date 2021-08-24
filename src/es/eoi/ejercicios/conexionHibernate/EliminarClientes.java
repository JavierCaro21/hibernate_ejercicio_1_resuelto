package es.eoi.ejercicios.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EliminarClientes {

    public static void main(String[] args){
        SessionFactory miFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session miSession = miFactory.openSession();

        try {
            //Comenzamos la transaccion de Hibernate
            miSession.beginTransaction();

            // eliminación de clientes con HQL
            String hql = "delete Clientes where direccion LIKE 'G%' ";
            miSession.createQuery(hql).executeUpdate();

            miSession.getTransaction().commit();
            System.out.println("- Clientes eliminados");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Cerramos sesión y factory");
            miSession.close();
            miFactory.close();
        }

    }
}
