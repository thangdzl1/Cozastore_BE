package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
    CountryEntity findById(int id);
}
