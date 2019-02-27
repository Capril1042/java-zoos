package com.cjs.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    @ManyToOne
    @JoinColumn(name = "phoneid")
    @JsonIgnoreProperties("zoos")
    private Telephone telephone;

    @ManyToMany(mappedBy = "zoos")
    @JsonIgnoreProperties("zoos")
    private Set<Animal> animals = new HashSet<>();

    public Zoo()
    {
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public Telephone getTelephone()
    {
        return telephone;
    }

    public void setTelephone(Telephone telephone)
    {
        this.telephone = telephone;
    }

    public Set<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(Set<Animal> animals)
    {
        this.animals = animals;
    }
}
