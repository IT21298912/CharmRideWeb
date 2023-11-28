package com.example.charmRides.serviceImplement;

import com.example.charmRides.dto.MloginDto;
import com.example.charmRides.modal.Manager;
import com.example.charmRides.repo.managerRepository;
import com.example.charmRides.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class managerServiceImpl implements managerService {
    @Autowired
    private managerRepository mrepo;

    @Override
    public Manager register(Manager manager) {
        String aid = UUID.randomUUID().toString().split("-")[0];
        manager.setId(aid);
        return mrepo.save(manager);
    }

    @Override
    public Optional<Manager> findManager(String email) {
        Optional<Manager> resManager = mrepo.findByEmail(email);
        return resManager;
    }

    @Override
    public Optional<MloginDto> loginManager(String email, String password) {
        Optional<MloginDto> resLoginOptional = mrepo.findByEmailAndPassword(email, password);
        return resLoginOptional;
    }
}
