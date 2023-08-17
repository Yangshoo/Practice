package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJpaTest_01 {

    @Autowired
    CustomerRepository repository;

    @Test
    public void test_query(){
        Optional<Customer> byId = repository.findById(1L);
        System.out.println(byId.get());
    }

    @Test
    public void test_add(){
        Customer customer = new Customer();
        customer.setCustName("Yangshoo");
        customer.setCustAddress("Airport");
        repository.save(customer);
    }

    @Test
    public void test_delete(){
        repository.deleteById(2L);
    }

    @Test
    public void test_update(){
        Customer customer = new Customer();
        customer.setCustId(3L);
        customer.setCustAddress("碧津");
        repository.save(customer);
    }
}
