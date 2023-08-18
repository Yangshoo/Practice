package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerQBERepository;
import cn.yangshoo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
public class QBETest_05 {

    @Autowired
    CustomerQBERepository repository;

    /**
     * 简单示例     客户名称    客户地址动态查询
     */
    @Test
    public void test_01(){

        //查询条件
        Customer customer = new Customer();
        customer.setCustName("Candy");
        customer.setCustAddress("玫瑰城");

        //通过Example进行构建
        Example<Customer> eg = Example.of(customer);

        List<Customer> customers = (List<Customer>) repository.findAll(eg);
        System.out.println(customers);
    }

    /**
     * 通过匹配器 进行条件的限制
     */
    @Test
    public void test_02(){

        //查询条件
        Customer customer = new Customer();
        customer.setCustName("Candy");
        customer.setCustAddress("port");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("custName")    //设置忽略属性
                .withIgnoreCase("custAddress")
                //.withStringMatcher(ExampleMatcher.StringMatcher.ENDING) //对所有条件字符串结尾匹配
                .withMatcher("custAddress", m -> m.endsWith()); //针对某个条件进行限制

        //通过Example进行构建
        Example<Customer> eg = Example.of(customer, matcher);

        List<Customer> customers = (List<Customer>) repository.findAll(eg);
        System.out.println(customers);
    }

}
