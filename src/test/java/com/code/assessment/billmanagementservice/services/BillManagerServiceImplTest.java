package com.code.assessment.billmanagementservice.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.code.assessment.billmanagementservice.model.Bill;
import com.code.assessment.billmanagementservice.model.Friend;
import com.code.assessment.billmanagementservice.repository.BillRepository;
import com.code.assessment.billmanagementservice.repository.FriendRepository;

@RunWith(MockitoJUnitRunner.class)
public class BillManagerServiceImplTest {

	
//	private BillManagerServiceImpl billManagerServiceImpl;
//
//	
//	@Mock
//	private FriendRepository friendRepository;
//	
//    @Mock
//	private BillRepository billRepository;
//	 
//	 @Before
//	 public void initMocks(){
//	        MockitoAnnotations.initMocks(this);
//	        billManagerServiceImpl = new BillManagerServiceImpl();
//	 }
//	 
//	@Test
//    public void getBillsByFriendTest() throws Exception {
//		Set<Bill> bills = new HashSet<>();
//		bills.add(new Bill("for lunch", 10.34f));
//		ReflectionTestUtils.setField(billManagerServiceImpl, "billRepository", billRepository);
//		when(billRepository.findByFriend(any(), any())).thenReturn(bills);
//		assertEquals(1, billManagerServiceImpl.getBillsByFriend(new Friend("justin", "zuo")).size());
//	}
//	
//	@Test
//    public void getFriendsByBillTest() throws Exception {
//		Set<Friend> friends = new HashSet<>();
//		friends.add(new Friend("huang", "sheng"));
//		ReflectionTestUtils.setField(billManagerServiceImpl, "friendRepository", friendRepository);
//		when(friendRepository.findByBill(Mockito.anyString(), Mockito.anyFloat())).thenReturn(friends);
//		assertEquals(1, billManagerServiceImpl.getFriendsByBill(new Bill("for lunch", 11.4f)).size());
//	}
//	
//	@Test
//    public void saveFriendBillTest() throws Exception {
//		Set<Bill> bills = new HashSet<>();
//		bills.add(new Bill("for lunch", 12.4f));
//		Set<Friend> friends = new HashSet<>();
//		Friend tempFriend = new Friend("Hu", "nam");
//		friends.add(tempFriend);
//		
//		ReflectionTestUtils.setField(billManagerServiceImpl, "friendRepository", friendRepository);
//		when(friendRepository.save(new Friend())).thenReturn(tempFriend);
//		billManagerServiceImpl.saveFriendBill(friends, bills);
//		
//	}
//	
//	@Test(expected=Exception.class)
//    public void saveFriendBillExceptionTest() throws Exception {
//		Set<Bill> bills = new HashSet<>();
//		Bill bill = new Bill("for lunch", 12.4f);
//		bills.add(bill);
//		Set<Friend> friends = new HashSet<>();
//		ReflectionTestUtils.setField(billManagerServiceImpl, "friendRepository", friendRepository);
//		Mockito.doThrow(new Exception("Database connection issue"))
//        .when(friendRepository).save(any(Friend.class));
//		billManagerServiceImpl.saveFriendBill(friends, bills);
//	}
}
