package com.cjs.zoos.repositories;

import com.cjs.zoos.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long>
{
}
