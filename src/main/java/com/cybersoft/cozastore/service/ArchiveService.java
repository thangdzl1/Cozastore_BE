package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.ArchiveEntity;
import com.cybersoft.cozastore.repository.ArchiveRepository;
import com.cybersoft.cozastore.service.Imp.ArchiveServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveService implements ArchiveServiceImp {
    @Autowired
    ArchiveRepository archiveRepository;

    @Override
    public List<ArchiveEntity> findAllArchive(){
        return archiveRepository.findAll();
    }

}
