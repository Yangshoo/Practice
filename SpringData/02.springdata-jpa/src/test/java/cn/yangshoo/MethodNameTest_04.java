package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerMethodNameRepository;
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
public class MethodNameTest_04 {

    @Autowired
    CustomerMethodNameRepository repository;

    @Test
    public void testFindByName(){
        List<Customer> customers = repository.findByCustName("Candy");
        System.out.println(customers);
    }

    @Test
    public void testLike(){
        List<Customer> customers = repository.findByCustNameLike("Can%");
        System.out.println(customers);
    }

}
