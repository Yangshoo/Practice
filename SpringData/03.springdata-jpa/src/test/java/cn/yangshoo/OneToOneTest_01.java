package cn.yangshoo;

import cn.yangshoo.pojo.Account;
import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 18/8/2023
 */
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OneToOneTest_01 {

    @Autowired
    CustomerRepository repository;

    @Test
    public void test_insert(){
        //初始化数据
        Customer customer = new Customer();
        Account account = new Account();
        account.setUsername("Candy's account");
        customer.setCustName("Candy");
        customer.setAccount(account);

        repository.save(customer);
    }

    @Test
    //懒加载需要配置事务
    //当通过repository调用完查询方法，session会立即关闭，一旦session关闭就不能查询了
    //加了事务后，就能让session直到事务方法执行完毕后才会关闭
    @Transactional(readOnly = true)
    public void test_query(){
        Optional<Customer> customer = repository.findById(1L);
        System.out.println(customer.get());
    }

    @Test
    public void test_delete(){
        repository.deleteById(6L);
    }

    @Test
    public void test_update(){
        Customer customer = new Customer();
        customer.setCustName("Candy");
        customer.setCustId(7L);
        customer.setAccount(null);

        repository.save(customer);
    }

}
