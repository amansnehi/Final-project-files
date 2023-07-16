package com.rideManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.rideManagement.DAL.RideRepos2;
import com.rideManagement.DAL.VehicleRepository;
import com.rideManagement.model.Distance;
import com.rideManagement.model.Vehicle;
import com.rideManagement.model.DTOs.DistanceDTO;

@Service
public class DistanceService {
	private final RideRepos2 distanceRepos;
	private final VehicleRepository vehicleRepos;
	private final ModelMapper modelMapper;
	@Autowired
	public DistanceService(RideRepos2 distanceRepos, VehicleRepository vehicleRepos, ModelMapper modelMapper) {
		this.distanceRepos = distanceRepos;
		this.vehicleRepos = vehicleRepos;
		this.modelMapper = new ModelMapper();
	}

	public Integer calculateDistance(String registrationNo, Integer id) {
		Vehicle vehicle = vehicleRepos.findById(registrationNo).orElse(null);
		Distance distance = distanceRepos.findById(id).orElse(null);

		if (vehicle == null || distance == null) {
			return null;
		}
		return vehicle.getFarePerKm() * distance.getDistanceInKMS();
	}
	
	public List<DistanceDTO> getAllDistanceDetail() {
		List<Distance> allDistance = distanceRepos.findAll();
		List<DistanceDTO> allDistanceDTO = new ArrayList<>();
		
		for(Distance singleDistance: allDistance) {
			DistanceDTO temp = modelMapper.map(singleDistance, DistanceDTO.class);
			allDistanceDTO.add(temp);
			
		}
		return allDistanceDTO;
		
		
	}
}
