package org.cap.service.test;

import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestCase {

	
	private AcccountService accService;
	
	private int input1;
	private int input2;
	private int output;
	
	
	public ParameterizedTestCase(int input1, int input2, int output) {
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
	}
	
	@Parameters
	public static List<Object[]> myParameters(){
		return Arrays.asList(new Object[][]{
			{2,2,4},
			{0,3,3},
			{-1,1,0},
			{10,-5,12}
		});
	}
	
	@Test
	public void test_Add_Number_with_various_inputs(){
		accService=new AccountServiceImpl();
		
		Assert.assertEquals(output, accService.addNumbers(input1, input2));
	}
	
	
	
}
