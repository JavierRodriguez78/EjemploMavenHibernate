package com.geeekshubsacademy;

import com.geeekshubsacademy.domain.models.Clientes;
import com.geeekshubsacademy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
        Clientes cliente = new Clientes("Xavi","Rodriguez","xavidfdf");
        session.save(cliente);
        Clientes cliente1 = new Clientes("Juan","Fernandez","juan@geekshubs.com");
        session.save(cliente1);
        Clientes cliente2 = new Clientes("Quique","DeMiguel","quique@geekshubs.com");
        session.save(cliente2);



        session.getTransaction().commit();


        Query q = session.createQuery("From Clientes");
        List<Clientes> resultList = q.list();
        System.out.println("Numero de clientes" + resultList.size());
        for (Clientes clienteData: resultList)
        {
            System.out.println("Cliente -> "+ clienteData);
        }
    }
}
