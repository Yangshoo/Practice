package cn.yangshoo.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 16/8/2023
 */

@Entity     //作为hibernate 实体类
@Table(name = "tb_customer")   //映射的表明
@Data
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

    // 单向关联 一对一
    /**
     * Casecade:设置关联操作
     * ALL: 所有持久化操作
     * PERSIST: 只有插入才执行关联操作
     * MERGE: 只有修改才执行关联操作
     * REMOVE: 只有删除才执行关联操作
     *
     * fetch:设置是否懒加载
     * EAGER : 立即加载（默认）
     * LAZY : 懒加载（直到用到对象才加载） 懒加载需要配置事务
     *
     * orphanRemoval: 关联移除（通常在修改时用到）
     *      一旦把关联的数据设置Null，或者修改为其他的关联数据，若像删除关联数据，就可以设置true
     *
     * mappedBy: 将外键约束交给另一方维护（通常在双向关联关系中会放弃一方的外键约束）
     *      值 = 另一方的关联属性名
     */
    @OneToOne(mappedBy = "customer",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    // 设置外键字段名
    @JoinColumn(name = "account_id")
    private Account account;
}
