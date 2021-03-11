package com.mercedesbenzapplication.user.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDao {
 int status;
 boolean fuelFlag;
 int kilometersLeft;
}
