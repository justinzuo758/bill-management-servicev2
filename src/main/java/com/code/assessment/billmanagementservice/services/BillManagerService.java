package com.code.assessment.billmanagementservice.services;

import java.util.List;
import java.util.Set;

import com.code.assessment.billmanagementservice.model.Bill;
import com.code.assessment.billmanagementservice.model.Friend;

public interface BillManagerService {

		 /**
	     * Save a friend into database;
	     *
	     * @param Friend friend
	     * @return void.
	     *
	     */
		public Friend addAFriend(Friend friend) throws IllegalArgumentException;
	
		 /**
	     * Delete a friend from database.
	     *
	     * @param Friend friend
	     * @return void.
	     *
	     */
		public void deleteAFriend(Friend friend) throws IllegalArgumentException ;
		
	    /**
	     * A user case in which several friends share each bill.
	     *
	     * @param Set<Friend> friends.
	     * @param Set<Bill> bills.
	     * @return void.
	     * @throws database related error due to the unique constraints on Friend and Bill.
	     */
		public void saveFriendBill(Set<Friend> friends, Set<Bill> bills);
		
		/**
	     * Get a set of bills for a friend
	     *
	     * @param Friend friend.
	     * @return Set<Bill> or null.
	    */
	  	public Set<Bill> getBillsByFriend(Friend friend);
		
	  	/**
	     * Get a set of friends whom are associated with a bill.
	     *
	     * @param Bill bill.
	     * @return Set<Friend> or null.
	    */
		public Set<Friend> getFriendsByBill(Bill bill);

		/**
	     * After all friends associated with a bill have paid, we delete friends, then delete 
	     *    the bill.
	     *
	     * @param Bill bill.
	     * @return void.
	     * @throws database related error due to the constraints.
	    */
		public void removeFriendsAndBill(Friend bill);
		
}
