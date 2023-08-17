package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJpaPagingAndSortingTest_02 {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testPaging(){
        Page<Customer> all = repository.findAll(PageRequest.of(0,2));
        System.out.println(all.getTotalPages());
        System.out.println(all.getTotalElements());
        System.out.println(all.getContent());
    }

    @Test
    public void testSorting(){

        Sort sort = Sort.by("custId").descending();
        Iterable<Customer> all = repository.findAll(sort);
        System.out.println(all);

        Sort.TypedSort<Customer> sortType = Sort.sort(Customer.class);
        Sort newSort = sortType.by(Customer::getCustId).descending();
        Iterable<Customer> all1 = repository.findAll(newSort);
        System.out.println(all1);

    }


}
