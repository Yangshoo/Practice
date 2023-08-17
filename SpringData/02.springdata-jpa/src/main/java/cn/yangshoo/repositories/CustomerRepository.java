package cn.yangshoo.repositories;

import cn.yangshoo.pojo.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 17/8/2023
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    // 增删查改

    // 查询
    @Query("FROM Customer WHERE custName=:custName")
    Customer findCustomerByCustName(@Param("custName") String custName);

    // 修改
    @Transactional
    @Modifying //通知SpringDataJpa 是增删改操作
    @Query("update Customer c set c.custName=:custName where c.custId=:id")
    int updateCustomerById(@Param("custName") String custName, @Param("id") Long id);

    // 删除
    @Transactional
    @Modifying
    @Query("delete from Customer where custId=:id")
    int deleteCustomerById(@Param("id") Long id);

    // 新增
    @Transactional
    @Modifying
    @Query("INSERT INTO Customer (custName) SELECT c.custName FROM Customer c where c.custId=?1")
    int insertCustomerBySelect(Long id);

    //原生sql查询
    @Query(nativeQuery = true, value = "select * from tb_customer")
    List queryAllByNative();
}
