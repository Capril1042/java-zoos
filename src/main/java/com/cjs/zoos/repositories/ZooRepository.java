package com.cjs.zoos.repositories;

import com.cjs.zoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepository extends JpaRepository<Zoo, Long>
{
}
