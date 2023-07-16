package com.rideManagement;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rideManagement.DAL.RideRepos2;
import com.rideManagement.model.Distance;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RideRepos2 distanceRepo;
    

    @Autowired
    public DataInitializer(RideRepos2 distanceRepo) {
        this.distanceRepo = distanceRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if vehicle types exist, if not, seed the data
        if (distanceRepo.count() == 0) {
            seedVehicleTypes();
        }
    }

    private void seedVehicleTypes() {
        Distance dist1 = new Distance();
        dist1.setDistanceInKMS(1560);
        dist1.setFrom("KOLKATA");
        dist1.setTo("DELHI");
        distanceRepo.save(dist1);
        
        Distance dist2 = new Distance();
        dist2.setDistanceInKMS(1800);
        dist2.setFrom("DELHI");
        dist2.setTo("BBSR");
        distanceRepo.save(dist2);
        
        Distance dist3 = new Distance();
        dist3.setDistanceInKMS(1870);
        dist3.setFrom("BANGALORE");
        dist3.setTo("KOLKATA");
        distanceRepo.save(dist3);
        
        Distance dist4 = new Distance();
        dist4.setDistanceInKMS(1870);
        dist4.setFrom("KOLKATA");
        dist4.setTo("BANAGLORE");
        distanceRepo.save(dist4);
        
        Distance dist5 = new Distance();
        dist5.setDistanceInKMS(1800);
        dist5.setFrom("BBSR");
        dist5.setTo("DELHI");
        distanceRepo.save(dist5);
        
        Distance dist6 = new Distance();
        dist6.setDistanceInKMS(1560);
        dist6.setFrom("DELHI");
        dist6.setTo("KOLKATA");
        distanceRepo.save(dist6);
        
        Distance dist7 = new Distance();
        dist7.setDistanceInKMS(2720);
        dist7.setFrom("DELHI");
        dist7.setTo("COCHIN");
        distanceRepo.save(dist7);
        
        Distance dist8 = new Distance();
        dist8.setDistanceInKMS(2720);
        dist8.setFrom("COCHIN");
        dist8.setTo("DELHI");
        distanceRepo.save(dist8);
        
        Distance dist9 = new Distance();
        dist9.setDistanceInKMS(2000);
        dist9.setFrom("DELHI");
        dist9.setTo("KARNATAKA");
        distanceRepo.save(dist9);
        
    }
}