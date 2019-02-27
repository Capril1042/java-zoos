package com.cjs.zoos.controllers;

import com.cjs.zoos.models.Animal;
import com.cjs.zoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/animals/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController
{
    @Autowired
    AnimalRepository animalrepos;


    @GetMapping("/animals")
    public List<Animal> getAllAnimals()
    {
        return animalrepos.findAll();
    }
//    GET /animals/{name} - return the animal with a list of zoos where they can be found
    @GetMapping("/{name}")
    public List<Animal> getAnimalByName(@PathVariable String name)
    {
        List<Animal> foundAnimal = animalrepos.getAnimalByAnimaltypeEquals(name);
        if( foundAnimal.isEmpty())
        {
            return null;
        }
        else
        {
            return foundAnimal;
        }
    }
}
