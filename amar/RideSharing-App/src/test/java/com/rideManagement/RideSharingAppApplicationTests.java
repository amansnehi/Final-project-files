package com.rideManagement;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.util.Assert;

import com.rideManagement.model.DTOs.DistanceDTO;
import com.rideManagement.service.DistanceService;

import junit.framework.Assert;

@SpringBootTest
class RideSharingAppApplicationTests {

	@InjectMocks
	private RideSharingAppApplicationTests rideController;

	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Mock
	private DistanceService distanceService;

	@Test
	public List<DistanceDTO> testGetAllDistancesDtos() {
		// Prepare test data
		DistanceDTO distanceDTO1 = new DistanceDTO();
		distanceDTO1.setId(1);
		distanceDTO1.setFrom("Location A");
		distanceDTO1.setTo("Location B");
		distanceDTO1.setDistanceInKMS(10);

		DistanceDTO distanceDTO2 = new DistanceDTO();
		distanceDTO2.setId(2);
		distanceDTO2.setFrom("Location B");
		distanceDTO2.setTo("Location C");
		distanceDTO2.setDistanceInKMS(20);

		List<DistanceDTO> expectedDistances = Arrays.asList(distanceDTO1, distanceDTO2);

		// Configure mock behavior
		Mockito.when(distanceService.getAllDistanceDetail()).thenReturn(expectedDistances);

		// Perform the API call
		List<DistanceDTO> actualDistances = rideController.testGetAllDistancesDtos();

		// Verify the result
		Assert.assertEquals(expectedDistances.size(), actualDistances.size());
		Assert.assertEquals(expectedDistances.get(0).getId(), actualDistances.get(0).getId());
		Assert.assertEquals(expectedDistances.get(1).getId(), actualDistances.get(1).getId());
		// Add additional assertions for other fields if necessary
		return actualDistances;
	}
}
