package com.cjs.zoos.repositories;

import com.cjs.zoos.models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long>
{
}
