package es.eoi.ejercicios.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class LeerClientes {

    public static void main(String[] args){
        SessionFactory miFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Clientes.class)
                .buildSessionFactory();

        Session miSession = miFactory.openSession();

        try {
            //Comenzamos la transaccion de Hibernate
            miSession.beginTransaction();

            // consulta de clientes con HQL
            String hql = "from Clientes";
            List<Clientes> clientesLeidos = miSession.createQuery(hql).getResultList();

            System.out.println("- Hemos obtenido " + clientesLeidos.size() + " clientes de la base de datos!!");

            //Si ha ido bien nos mostraremos la lista de todos clientes
            for(Clientes clienteLeido: clientesLeidos) {
                System.out.println(clienteLeido);
            }

            //Ahora consulta con los que su apellido sea igual a Martinez
            hql = "from Clientes c1 where c1.apellidos='Martinez'";
            clientesLeidos = miSession.createQuery(hql).getResultList();
            System.out.println("- Hay " + clientesLeidos.size() + " con ese apellido");

            for(Clientes clienteLeido: clientesLeidos) {
                System.out.println(clienteLeido);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Cerramos sesión y factory");
            miSession.close();
            miFactory.close();
        }

    }
}
