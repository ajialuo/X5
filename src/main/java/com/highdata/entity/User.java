package com.highdata.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_user")
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5927908541432372896L;
    
    @Id
    @Column(name = "id", nullable = false)    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name = "";
    private String pwd = "";
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}
