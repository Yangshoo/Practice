package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpqlTest_03 {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testQuery(){
        Customer customer = repository.findCustomerByCustName("Candy");
        System.out.println(customer);
    }

    @Test
    public void testUpdate(){
        int row = repository.updateCustomerById("Yangshoo", 3L);
        System.out.println(row);
    }

    @Test
    public void testDelete(){
        int row = repository.deleteCustomerById(3L);
        System.out.println(row);
    }

    @Test
    public void testInsert(){
        int row = repository.insertCustomerBySelect(4L);
        System.out.println(row);
    }

    @Test
    public void testQueryByNative(){
        List<Customer> result = repository.queryAllByNative();
        System.out.println(result);
    }


}
