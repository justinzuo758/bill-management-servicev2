package com.code.assessment.billmanagementservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.code.assessment.billmanagementservice.model.Bill;
import com.code.assessment.billmanagementservice.model.Friend;
import com.code.assessment.billmanagementservice.services.BillManagerService;

@SpringBootApplication
public class BillManagementServicev2Application implements CommandLineRunner{

	@Autowired
	BillManagerService BillManagerServiceImpl; 
	
	public static void main(String[] args) {
		SpringApplication.run(BillManagementServicev2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		//Save a friend
		BillManagerServiceImpl.addAFriend(new Friend("hongmei", "fan"));
		BillManagerServiceImpl.addAFriend(new Friend("hongmei", "fan"));
		
		//Delete a friend
//		BillManagerServiceImpl.deleteAFriend(new Friend("hongmei", "fan"));
		
		//Several friends share each bill in a bill list;
		Set<Friend> friends = new HashSet<>();
		Friend friend1 = new Friend("hongmei", "fan"); 
		Friend friend2 = new Friend("william", "luo");
		Friend friend3 = new Friend("ai", "chen");
		friends.add(friend1);
		friends.add(friend2);
		friends.add(friend3);
		
//		Set<Bill> bills = new HashSet<>();
//		Bill bill1 = new Bill("for lunch", 99.0f);
//		Bill bill2 = new Bill("for outing", 150.0f);
//		bills.add(bill1);
//		bills.add(bill2);
		
//		BillManagerServiceImpl.saveFriendBill(friends, bills);
		
		Set<Friend> friends1 = new HashSet<>();
		Friend friend6 = new Friend("Ankit", "fan"); 
		friends1.add(friend6);
		
		
		//Get bills by friend
		Set<Bill> billsForFriend = BillManagerServiceImpl.getBillsByFriend(new Friend("hongmei", "fan"));
		billsForFriend.stream().forEach(System.out::println);
		
		//Get friends by Bill
//		Set<Friend> friendsForBill = BillManagerServiceImpl.getFriendsByBill(new Bill("for lunch", 33.0f));
//		friendsForBill.stream().forEach(System.out::println);
		
		//Delete a bill
		BillManagerServiceImpl.removeFriendsAndBill(new Friend("hongmei", "fan"));
	}

}
