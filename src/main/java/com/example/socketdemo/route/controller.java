package com.example.socketdemo.route;

import com.example.socketdemo.dao.DeviceDao;
import com.example.socketdemo.entity.Device;
import com.example.socketdemo.service.PyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    @Autowired
    private PyService service;
    @Autowired
    private DeviceDao deviceDao;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/init")
    public @ResponseBody String start(@RequestParam("annoIndex")int index){
        service.start(index);
        return "start the device";
    }
    @RequestMapping("/stop")
    public @ResponseBody String stop(){
        service.stop();
        return "stop the device";
    }
    public @ResponseBody String write(String code){
        service.write(code);
        return "write the device";
    }
    @RequestMapping("/read")
    public @ResponseBody String read(){
        return  service.read();
//        while (true){
//            if(code!=null){
//                return code;
//                stop();
//                break;
//            }
//        }
    }
    @RequestMapping("/lent")
    public @ResponseBody String lent(){
        String rfid=read();
        Device device=deviceDao.findDeviceByRfid(rfid);
        device.lent();
        return "借出设备"+rfid;
    }
    @RequestMapping("/return")
    public @ResponseBody String back(){
        String rfid=read();
        Device device=deviceDao.findDeviceByRfid(rfid);
        device.back();
        return "还回设备"+rfid;
    }
    @RequestMapping("/create")
    public @ResponseBody String create(@RequestBody Device device){
        String rfid=read();
        if(rfid!=null)
            device.setRfid(rfid);
        deviceDao.save(device);
        return "设备信息已录入";
    }
}
