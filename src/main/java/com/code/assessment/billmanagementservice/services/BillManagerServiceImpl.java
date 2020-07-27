package com.code.assessment.billmanagementservice.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.assessment.billmanagementservice.model.Bill;
import com.code.assessment.billmanagementservice.model.Friend;
import com.code.assessment.billmanagementservice.repository.BillRepository;
import com.code.assessment.billmanagementservice.repository.FriendRepository;

@Service
public class BillManagerServiceImpl implements BillManagerService{
	
	@Autowired
	FriendRepository friendRepository;
	
	@Autowired
	BillRepository billRepository;
	
	
	/**
     * {@inheritDoc}
     */
	@Override
	@Transactional
	public Friend addAFriend(Friend friend) throws IllegalArgumentException {
		return friendRepository.save(friend);
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	@Transactional
	public void deleteAFriend(Friend friend) throws IllegalArgumentException {
		friendRepository.delete(friend);
		friendRepository.flush();
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	@Transactional
	public void saveFriendBill(Set<Friend> friends, Set<Bill> bills) {
		 /*
		  * For this case, these friends will share each bill
		  */
		 List<Friend> friendList = new ArrayList<>(friends);
		 List<Bill> billList = new ArrayList<>(bills);
		 
		 //split the bill amount
		 for (Bill bill : billList) {
			 float sharedAmount = bill.getAmount() / friendList.size();
			 bill.setAmount(sharedAmount);
		 }
		 
		 for (Friend friend : friendList) {
			 for (Bill bill : billList) {
				 friend.getBills().add(bill);
			 }
			 friendRepository.save(friend);
		 }
	
	}
	
	
	/**
     * {@inheritDoc}
     */
	@Override
	@Transactional
	public Set<Bill> getBillsByFriend(Friend friend) {
		Collection<Bill> bills = billRepository.findByFriend(friend.getFirstName(), friend.getLastName());
		Set<Bill> billSet = new HashSet<>();
		billSet.addAll(bills);
		return billSet;
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	@Transactional
	public Set<Friend> getFriendsByBill(Bill bill) {
		Collection<Friend> friends = friendRepository.findByBill(bill.getDescription(), bill.getAmount());
		Set<Friend> friendSet = new HashSet<>();
		friendSet.addAll(friends);
		return friendSet;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	@Transactional
	public void removeFriendsAndBill(Friend friend) {
//		bill.getFriends().removeAll(bill.getFriends());
		friendRepository.delete(friend);
	}
}
