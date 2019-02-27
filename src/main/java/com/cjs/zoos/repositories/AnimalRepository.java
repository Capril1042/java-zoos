package com.cjs.zoos.repositories;

import com.cjs.zoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long>
{
    List<Animal> getAnimalByAnimaltypeEquals( String name);
}
