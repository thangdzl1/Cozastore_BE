package com.cybersoft.cozastore.repository;

import com.cybersoft.cozastore.entity.ArchiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArchiveRepository extends JpaRepository<ArchiveEntity,Integer> {
    List<ArchiveEntity> findAllArchive();
}
