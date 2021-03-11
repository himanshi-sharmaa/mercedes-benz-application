package com.mercedesbenzapplication.user.service;

import com.mercedesbenzapplication.user.DAO.VehicleFuelDAO;

import java.lang.reflect.Array;
import java.util.List;

public interface UserVehicleService {
    public List<Integer> getVehicleStatus(VehicleFuelDAO vehicleFuelDAO);
    public List<Integer> getVehicleStatusAndRestaurants(VehicleFuelDAO vehicleFuelDAO);
}
