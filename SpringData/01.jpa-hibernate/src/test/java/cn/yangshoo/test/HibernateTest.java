package cn.yangshoo.test;

import cn.yangshoo.practice.pojo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 16/8/2023
 */
public class HibernateTest {

    private SessionFactory sf;

    @Before
    public void init(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();

        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void test_1(){
        //进行持久化操作
        try(Session session = sf.openSession()){
            Transaction transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustName("Candy");
            customer.setCustAddress("玫瑰城");
            session.save(customer);
            transaction.commit();

        }
    }

}
