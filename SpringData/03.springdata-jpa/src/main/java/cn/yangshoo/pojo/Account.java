package cn.yangshoo.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ： YangHaichuan
 * @version :  1.0.0
 * @date ： 18/8/2023
 */
@Entity
@Table(name = "tb_account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
