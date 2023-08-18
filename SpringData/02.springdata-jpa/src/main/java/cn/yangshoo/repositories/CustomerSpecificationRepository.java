package cn.yangshoo.repositories;

import cn.yangshoo.pojo.Customer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
public interface CustomerSpecificationRepository extends PagingAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

}
