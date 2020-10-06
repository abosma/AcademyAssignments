package com.academy.atilla;

import com.academy.atilla.dto.WorkExperience;
import com.academy.atilla.service.WorkExperienceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AtillaApplicationTests {

	@Mock
	WorkExperienceService mockedService;

	@Test
	public void testGetDataFromService() {
		WorkExperience workExperience = new WorkExperience();
		workExperience.setId(1);

		mockedService.save(workExperience);
		Mockito.verify(mockedService).save(workExperience);
		Mockito.when(mockedService.find(1)).thenReturn(workExperience);

		assertEquals(workExperience, mockedService.find(1));
	}
}
