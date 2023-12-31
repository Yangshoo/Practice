package cn.yangshoo.practice.pojo;

import javax.persistence.*;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 16/8/2023
 */

@Entity     //作为hibernate 实体类
@Table(name = "tb_customer")   //映射的表明
public class Customer {

    /**
     * @Id: 声明主键的配置
     * @GeneratedValue: 配置主键的生成策略
     *      strategy
     *          GenerationType.IDENTITY : 自增, mysql
     *              * 底层数据库必须支持自动增长（底层数据库支持的自动增长方式，对id自增）
     *          GenerationType.SEQUENCE : 序列, oracle
     *              * 底层数据库必须支持序列
     *          GenerationType.TABLE : jpa提供的一种机制，通过一张数据库表的形式帮助我们完成
     *          GenerationType.AUTO : 由程序自动的帮助我们选择主键生成策略
     * @Column: 配置属性和字段的映射关系
     *      name: 数据库表中字段的名称
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
}
