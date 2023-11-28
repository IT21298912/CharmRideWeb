package com.example.charmRides.serviceImplement;

import com.example.charmRides.modal.Bus;
import com.example.charmRides.repo.busRepository;
import com.example.charmRides.service.busService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class busServiceImpl implements busService {

    @Autowired
    private busRepository busRepo;
    @Override
    public Bus addBus(Bus busIns) {
        String buid = UUID.randomUUID().toString().split("-")[0];
        busIns.setId(buid);

        return busRepo.save(busIns);
    }

    @Override
    public List<Bus> getBus() {
        return busRepo.findAll();

    }

    @Override
    public Bus getBusByid(String buid) {
        return  busRepo.findById(buid).orElse(null);
    }

    @Override
    public Bus updateBus(Bus busReq) {
        Bus existingBus = busRepo.findById(busReq.getId()).orElse(null);
        if (existingBus!=null){
            existingBus.setName(busReq.getName());
            existingBus.setBusType(busReq.getBusType());
            existingBus.setDriver(busReq.getDriver());
            existingBus.setPrice(busReq.getPrice());
            existingBus.setSeats(busReq.getSeats());
            existingBus.setShedule(busReq.getShedule());
            existingBus.setFromLocation(busReq.getFromLocation());
            existingBus.setToLocation(busReq.getToLocation());
            existingBus.setVehicleNum(busReq.getVehicleNum());

            return busRepo.save(existingBus);
        }

        return null;
    }

    @Override
    public String deleteBus(String buid) {
        busRepo.deleteById(buid);
        return buid+"patient deleted from the dashboard";
    }
}
