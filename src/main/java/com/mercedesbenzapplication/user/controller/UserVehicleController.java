package com.mercedesbenzapplication.user.controller;

import com.mercedesbenzapplication.user.DAO.VehicleFuelDAO;
import com.mercedesbenzapplication.user.service.UserVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserVehicleController {

    @Autowired
    private UserVehicleService userVehicleService;

    //For testing spring setup
    @RequestMapping(value="/test", method= RequestMethod.GET)
    public String test() {
        return "200 ok";
    }

    //Mandatory solution
    @RequestMapping(value="/v1/vehicle-fuel-status", method= RequestMethod.POST)
    public List<Integer> vehicleFuelStatus(@RequestBody VehicleFuelDAO vehicleFuelDAO) {
        List<Integer> data = userVehicleService.getVehicleStatus(vehicleFuelDAO);
        System.out.println(vehicleFuelDAO);
        return data;
    }

    //Mandatory solution
    @RequestMapping(value="/v1/vehicle-fuel-status-and-restaurants", method= RequestMethod.POST)
    public List<Integer> vehicleFuelStatusAndRestaurants(@RequestBody VehicleFuelDAO vehicleFuelDAO) {
        List<Integer> data = userVehicleService.getVehicleStatusAndRestaurants(vehicleFuelDAO);
        System.out.println(vehicleFuelDAO);
        return data;
    }

}
