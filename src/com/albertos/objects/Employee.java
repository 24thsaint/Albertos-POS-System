/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.objects;

import com.albertos.controllers.EmployeeJpaController;
import com.albertos.controllers.EMFactory;
import com.albertos.objects.enumerations.AccountType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author hero
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastname;
    private String firstName;
    private String gender;
    private String address;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    // @Temporal(TemporalType.TIMESTAMP)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AccessLog> logs = new ArrayList<>();

    public void employeeLogin() {
        AccessLog accessLog = new AccessLog();
        accessLog.setAccessType(com.albertos.objects.enumerations.AccessType.LOGIN);
        accessLog.setAccessTime(new Date());
        logs.add(accessLog);
    }

    public void employeeLogout() {
        AccessLog accessLog = new AccessLog();
        accessLog.setAccessType(com.albertos.objects.enumerations.AccessType.LOGOUT);
        accessLog.setAccessTime(new Date());
        logs.add(accessLog);
    }

    public List<AccessLog> getLogs() {
        return logs;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EMFactory.EmployeeRegistration[ id=" + id + " ]";
    }

}
