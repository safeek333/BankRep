package org.cap.service.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestWithMockito {

	
	private AcccountService accService;
	
	@Mock
	private AccountDao accountDao;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		//accService=new AccountServiceImpl();
		accService=new AccountServiceImpl(accountDao);
	}
	
	
	@Test
	public void test_findByAccountId() {
		
		Account account=new Account();
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAccountNo(1001);
		account.setAmount(2000);
		
		
		//Declaration
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		
		//Actual Logic
		Account receivedAccount=accService.findAccountById(1001);
		
		//Verify
		Mockito.verify(accountDao).findAccountById(1001);
		
		Assert.assertEquals(2000, receivedAccount.getAmount(),0.0);
		
	}
	
	
	@Test
	public void test_addAccount_with_Mockito() throws InvalidInitialAmountException{
		
		Account account=new Account();
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		//account.setAccountNo(1001);
		double amount=2500.00;
		account.setAmount(amount);
		
		
		//Declaration
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		
		//Actual Logic
		Account newAccount=accService.addAccount(customer, amount);
		
		//Verify
		Mockito.verify(accountDao).createAccount(account);
		
		Assert.assertNotNull(newAccount.getCustomer());
		Assert.assertEquals(2500.00, newAccount.getAmount(),0.0);
		
		
	}
	
	
	@Test
	public void test_deposit_with_Mockito() throws InvalidInitialAmountException{
		
		Account account=new Account();
		Customer customer=new Customer();
		customer.setCustName("Safeek");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAccountNo(1001);
		double amount=100.00;
		account.setAmount(amount);
		
		
		//Declaration
		Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
		
		
		//Actual Logic
		Account newAccount=accService.deposit(1001, 100.00);
		
		//Verify
		Mockito.verify(accountDao).findAccountById(1001);
		
		Assert.assertNotNull(newAccount.getCustomer());
		Assert.assertEquals(200.00, newAccount.getAmount(),0.0);
	}

}
