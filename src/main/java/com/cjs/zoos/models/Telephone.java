package com.cjs.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "telephone")
public class Telephone
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phoneid;

    private String phonetype;

    private String phonenumber;

    @ManyToOne
    @JoinColumn(name="zooid")
    private Zoo zooid;

    @OneToMany(mappedBy = "telephone")
    @JsonIgnoreProperties("telephone")
    private Set<Zoo> zoos = new HashSet<>();

    public Telephone()
    {
    }

    public long getPhoneid()
    {
        return phoneid;
    }

    public void setPhoneid(long phoneid)
    {
        this.phoneid = phoneid;
    }

    public String getPhonetype()
    {
        return phonetype;
    }

    public void setPhonetype(String phonetype)
    {
        this.phonetype = phonetype;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public Zoo getZooid()
    {
        return zooid;
    }

    public void setZooid(Zoo zooid)
    {
        this.zooid = zooid;
    }

    public Set<Zoo> getZoos()
    {
        return zoos;
    }

    public void setZoos(Set<Zoo> zoos)
    {
        this.zoos = zoos;
    }
}
