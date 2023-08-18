package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerQBERepository;
import cn.yangshoo.repositories.CustomerSpecificationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import javax.swing.*;
import java.util.List;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecificationTest_06 {

    @Autowired
    CustomerSpecificationRepository repository;

    /**
     * 查询客户范围(in)
     * id 用 大于
     * 地址 为 精确
     */
    @Test
    public void test_01(){
        List<Customer> customers = repository.findAll(new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                // root : from Customer , 获取列
                // criteriaBuilder : where , 设置各种条件 ( > < in ..)
                // query : 组合(order by , where)

                //1.通过root拿到需要设置条件的字段
                Path<Long> custId = root.get("custId");
                Path<String> custName = root.get("custName");
                Path<String> custAddress = root.get("custAddress");

                //2.通过CriteriaBuilder设置不同类型条件
                //参数1：为哪个字段设置条件     参数2：值
                Predicate custAddressPredict = criteriaBuilder.equal(custAddress, "玫瑰城");
                Predicate custIdPredict = criteriaBuilder.greaterThan(custId, 0L);

                CriteriaBuilder.In<String> in = criteriaBuilder.in(custName);
                in.value("Candy").value("Yangshoo");

                //组合条件,有排序则通过query
                Predicate predicate = criteriaBuilder.and(custAddressPredict, custIdPredict, in);

                Order desc = criteriaBuilder.desc(custId);

                return query.where(predicate).orderBy(desc).getRestriction();
            }
        });

        System.out.println(customers);
    }

    /**
     * 通过匹配器 进行条件的限制
     */
    @Test
    public void test_02(){

    }

}
