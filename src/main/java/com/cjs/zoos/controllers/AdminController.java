package com.cjs.zoos.controllers;

import com.cjs.zoos.models.Animal;
import com.cjs.zoos.models.Telephone;
import com.cjs.zoos.models.Zoo;
import com.cjs.zoos.repositories.AnimalRepository;
import com.cjs.zoos.repositories.TelephoneRepository;
import com.cjs.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/adim/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController
{
    @Autowired
    AnimalRepository animalrepos;

    @Autowired
    TelephoneRepository phonerepos;

    @Autowired
    ZooRepository zoorepos;


    //TODO Make Sure the PUT Endpoints are working properly
    @PutMapping("/zoos/{id}")
    public Zoo changeZooById(@RequestBody Zoo newzoo, @PathVariable long id) throws URISyntaxException
    {
        Optional<Zoo> updateZoo = zoorepos.findById(id);
        if (updateZoo.isPresent())
        {

            newzoo.setZooid(id);
            zoorepos.save(newzoo);

            return newzoo;
        }
        else
        {
            return null;
        }
    }


    @PutMapping("/phones/{id}")
    public Telephone changeTelephoneById(@RequestBody Telephone newphone, @PathVariable long id) throws URISyntaxException
    {
        Optional<Telephone> updatePhone = phonerepos.findById(id);
        if (updatePhone.isPresent())
        {

            newphone.setPhoneid(id);
            phonerepos.save(newphone);

            return newphone;
        }
        else
        {
            return null;
        }
    }

    @PutMapping("/animals/{id}")
    public Animal changeAnimalById(@RequestBody Animal newanimal, @PathVariable long id) throws URISyntaxException
    {
        Optional<Animal> updateAnimal = animalrepos.findById(id);
        if (updateAnimal.isPresent())
        {

            newanimal.setAnimalid(id);
            animalrepos.save(newanimal);

            return newanimal;
        }
        else
        {
            return null;
        }
    }

    //TODO make sure POST Endpoints work
   @PostMapping("/zoos")
    public Zoo newZoo(@RequestBody Zoo zoo) throws URISyntaxException
    {
        return zoorepos.save(zoo);
    }

    @PostMapping("/phones")
    public Telephone newTelephone(@RequestBody Telephone telephone) throws URISyntaxException
    {
        return phonerepos.save(telephone);
    }

    @PostMapping("/animals")
    public Animal newAnimal(@RequestBody Animal animal) throws URISyntaxException
    {
        return animalrepos.save(animal);
    }

    // TODO add post endpoint for ZOO/Animals
    // POST /admin/zoos/animals - add the zooid, animalid combination to the zoo animals relations table

    //TODO fix database/models so that list of phone numbers associated with zoo can be deleted
    @DeleteMapping("/zoos/{id}")
    public String deleteZooById(@PathVariable long id)
    {
        var foundZoo = zoorepos.findById(id);
        if (foundZoo.isPresent())
        {
            zoorepos.deleteZooFromAnimalAndTelephone(id);
            zoorepos.deleteById(id);

            return "{" + "\"id\":"   + foundZoo.get().getZooid() +
                    ",\"zooname\":" + "\"" + foundZoo.get().getZooname() + "\"" +
                    ",\"phones\":" + "\"" + foundZoo.get().getTelephone() + "\"" +
                    ",\"animals\":" + foundZoo.get().getAnimals() + "}";
        }
        else
        {
            return null;
        }
    }
//    DELETE /admin/phones/{id} - delete the phone number associated with this id
    @DeleteMapping("/phones/{id}")
    public String deletePhoneById(@PathVariable long id)
    {
        var foundPhone = phonerepos.findById(id);
        if (foundPhone.isPresent())
        {
            phonerepos.deleteById(id);

            return "{" + "\"id\":"   + foundPhone.get().getZooid() +
                    ",\"zooname\":" + "\"" + foundPhone.get().getZoos() + "}";
        }
        else
        {
            return null;
        }
    }
    //TODO add the remaining DELETE ENDPOINTS
//    DELETE /admin/animals/{id} - delete the animal associated with this id including all the appropriate zoo animal combinations
//    DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids.
}
