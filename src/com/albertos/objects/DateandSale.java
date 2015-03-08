/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.objects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Lyn
 */
@Entity
public class DateandSale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double dailySalesTotal;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateofSale;

    public Date getDateofSale() {
        return dateofSale;
    }

    public void setDateofSale(Date dateofSale) {
        this.dateofSale = dateofSale;
    }

    public double getDailySalesTotal() {
        return dailySalesTotal;
    }

    public void setDailySalesTotal(double dailySale) {
        this.dailySalesTotal = dailySale;
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
        if (!(object instanceof DateandSale)) {
            return false;
        }
        DateandSale other = (DateandSale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dailysale.DateandSale[ id=" + id + " ]";
    }
}
