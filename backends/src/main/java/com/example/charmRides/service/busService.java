package com.example.charmRides.service;

import com.example.charmRides.modal.Bus;

import java.util.List;

public interface busService {

    Bus addBus(Bus busIns);

    List<Bus> getBus();

    Bus getBusByid(String buid);

    Bus updateBus(Bus busReq);

    String deleteBus(String buid);

}
