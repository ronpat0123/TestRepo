package com.Test.JunitTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestCalculator {
	
	
	Calculator cal = null;
	@Mock
	CalculatorService service; //= Mockito.mock(CalculatorService.class);
	
	
	@Rule public MockitoRule rule = MockitoJUnit.rule(); 
	
	
	@Before
	public void setUp() {
		
		cal = new Calculator(service);
	}
	
	
	@Test
	public void testPerform() {
		
		when(service.add(2, 3)).thenReturn(5);
		assertEquals(5,cal.perform(2, 3));
		verify(service).add(2, 3);
		
	}
	

}
