package com.fintech.accounts.model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

/**
 *@author: Nathan
 *
 */

@Data
@NoArgsConstructor
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long customerID;
    @NotBlank(message = "firstname cannot be empty")
    private String firstName;

    private String otherNames;
    private String lastName;
    private String address;
    private String gender;
    private String phone;
    private String email;
    private long accountNo;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private boolean emailNotification;
    private boolean smsNotification;

    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Date createdDate;

}
