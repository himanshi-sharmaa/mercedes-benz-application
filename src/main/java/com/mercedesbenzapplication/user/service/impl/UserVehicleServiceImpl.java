package com.mercedesbenzapplication.user.service.impl;

import com.mercedesbenzapplication.user.DAO.FuelList;
import com.mercedesbenzapplication.user.DAO.RestaurantDAO;
import com.mercedesbenzapplication.user.DAO.StatusDao;
import com.mercedesbenzapplication.user.DAO.VehicleFuelDAO;
import com.mercedesbenzapplication.user.service.UserVehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserVehicleServiceImpl implements UserVehicleService {

    private int journeyFeasibilty(List<Integer> array){
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

    private StatusDao journeyFeasibiltyWithoutFillUp(List<Integer> array){
        int totalJourney = array.size();
        int fuelCount = 0;
        boolean fuelFlag=false;
        int status=0;
        int kilometerCount = 0;
        for(int i=0;i< array.size();i++){
            if(fuelCount<totalJourney) {
                fuelFlag=true;
                fuelCount += array.get(i);
            }
            --fuelCount;
            --totalJourney;
            if (fuelCount < 0 && totalJourney > 0) {
                status = 400;
                break;
            }
        }
        if(status!=400){
            status = 200;
        }
        kilometerCount= fuelFlag? 0: totalJourney;
        StatusDao statusDao = new StatusDao(status, fuelFlag, kilometerCount);
        return statusDao;
    }
    //Advanced solution
    @Override
    public ArrayList getVehicleStatusAndRestaurants(VehicleFuelDAO vehicleFuelDAO) {
        ArrayList vehicleRestaurantList = new ArrayList();
        List<FuelList> vehicleFuelRequest = vehicleFuelDAO.getChargers();
        for(int i=0;i<vehicleFuelRequest.size() ;i++){
            FuelList fuelList = vehicleFuelRequest.get(i);
            StatusDao res = journeyFeasibiltyWithoutFillUp(fuelList.getArray());
            if(res.isFuelFlag()) {
                vehicleRestaurantList.add(res.getStatus());
            } else {
                List<RestaurantDAO> restaurantDAOS = new ArrayList<>();
                //TODO: Get data from mock and filter based on  res.getKilometersLeft()
                vehicleRestaurantList.add(restaurantDAOS);
            }
        }
        return vehicleRestaurantList;
    }
}
