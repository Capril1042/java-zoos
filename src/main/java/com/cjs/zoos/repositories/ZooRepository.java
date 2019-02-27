package com.cjs.zoos.repositories;

import com.cjs.zoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, Long>
{
    List<Zoo> findZooByZoonameLike(String name);
}
