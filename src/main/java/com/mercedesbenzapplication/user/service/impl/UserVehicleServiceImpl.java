package com.mercedesbenzapplication.user.service.impl;

import com.mercedesbenzapplication.user.DAO.FuelList;
import com.mercedesbenzapplication.user.DAO.VehicleFuelDAO;
import com.mercedesbenzapplication.user.service.UserVehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserVehicleServiceImpl implements UserVehicleService {

    private int journeyFeasibilty(List<Integer> array){
        System.out.println(array);
        int totalJourney = array.size();
        int fuelCount = 0;
        for(int i=0;i< array.size();i++){
            fuelCount+=array.get(i);
            --fuelCount;
            --totalJourney;
            if (fuelCount < 0 && totalJourney>0) {
                return 400;
            }
        }
        return 200;
    }

    //Mandatory solution
    @Override
    public List<Integer> getVehicleStatus(VehicleFuelDAO vehicleFuelDAO) {
        List<Integer> vehicleStatus = new ArrayList<>();
        List<FuelList> vehicleFuelRequest = vehicleFuelDAO.getChargers();
        for(int i=0;i<vehicleFuelRequest.size() ;i++){
            FuelList fuelList = vehicleFuelRequest.get(i);
            int res = journeyFeasibilty(fuelList.getArray());
            vehicleStatus.add(res);
        }
        return vehicleStatus;
    }

    //Advanced solution
    @Override
    public List<Integer> getVehicleStatusAndRestaurants(VehicleFuelDAO vehicleFuelDAO) {
        return null;
    }
}
