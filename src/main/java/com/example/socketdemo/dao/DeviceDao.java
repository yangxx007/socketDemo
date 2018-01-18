package com.example.socketdemo.dao;

import com.example.socketdemo.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeviceDao extends JpaRepository<Device,Integer> {
    Device findDeviceByRfid(String rfid);
}
