package com.cjs.zoos.repositories;

import com.cjs.zoos.models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, Long>
{
    List<Zoo> findZooByZoonameLike(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM telephone, animal WHERE zooid = :id", nativeQuery = true)
    void deleteZooFromAnimalAndTelephone(long id);
}
