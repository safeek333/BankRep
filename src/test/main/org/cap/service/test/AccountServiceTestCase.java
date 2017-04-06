package org.cap.service.test;

import static org.junit.Assert.*;

import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AccountServiceTestCase {
	
	private AcccountService accService;
	//Testing
	
	
	@BeforeClass
	public static void before_Class(){
		//System.out.println("Before Class Method");
	}
	@AfterClass
	public static void after_Class(){
		//System.out.println("After Class Method");
	}

	@Before
	public void setUp(){
		//System.out.println("Before Method");
		accService=new AccountServiceImpl();
	}

	@After
	public void tearDown(){
		//System.out.println("After Method");
		accService=new AccountServiceImpl();
	}
	
	
	@Test
	public void test_AddNumbers() {
		//accService=new AccountServiceImpl();
		assertEquals(32,accService.addNumbers(12, 20));
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void test_AddAccount_with_null_Customer() throws InvalidInitialAmountException{
		//accService=new AccountServiceImpl();
		Customer customer=null;
		
		accService.addAccount(customer, 1000);
		
	}
	
	
	@Test(expected=InvalidInitialAmountException.class)
	public void test_addAccount_with_invalid_amount() throws InvalidInitialAmountException{
		//accService=new AccountServiceImpl();
		Customer customer=new Customer();
		customer.setCustName("Tom");customer.setCustAddress(new Address());
		
		accService.addAccount(customer, 100);
		
	}
	
	
	@Ignore
	@Test(timeout=50)
	public void test_myLoop(){
		accService.myLoop();
	}
	

}
