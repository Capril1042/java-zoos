package com.cjs.zoos.controllers;

import com.cjs.zoos.models.Zoo;
import com.cjs.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zoos/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController
{
    @Autowired
    ZooRepository zoorepos;

    //TODO Fix Zoo-Telephone relationship in Models so that the phone number shows
    @GetMapping("/zoos")
    public List<Zoo> getAllZoos()
    {
        return zoorepos.findAll();
    }

    //TODO Fix this so that name of zoo, telephone number and animals are returned
    @GetMapping("/{name}")
    public List<Zoo> getZooByName(@PathVariable String name)
    {
         List<Zoo> foundZoo = zoorepos.findZooByZoonameLike(name);
         if (foundZoo.isEmpty())
         {
             return null;
         }
         else
         {
             return foundZoo;
         }
    }

}
