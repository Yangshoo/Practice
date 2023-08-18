package cn.yangshoo;

import cn.yangshoo.pojo.Customer;
import cn.yangshoo.repositories.CustomerQueryDslRepository;
import cn.yangshoo.repositories.CustomerSpecificationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryDslTest_07 {

    @Autowired
    CustomerQueryDslRepository repository;

    @Test
    public void test_01() {

    }

}
