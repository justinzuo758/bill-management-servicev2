package com.code.assessment.billmanagementservice.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity
@Table(
		name = "bills",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"description", "amount", "date"})}
	)
public class Bill {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(name = "description")
	@NotNull
	private String description;
	
	@Column(name = "amount")
	@NotNull
	private float amount;
	
	@Column(name = "date")
	@NotNull
	private Date billDate;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="bills")
    private Set<Friend> friends = new HashSet<>();
	
	public Bill(){
		
	}
	
	public Bill(String description, float amount, Date billDate){
		this.description = description;
		this.amount = amount;
		this.billDate = billDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + description.hashCode();
		result = prime * result + (int)(1000 * amount);
		result = prime * result + billDate.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Bill))
			return false;
		Bill other = (Bill) obj;
		if ((!description.equals(other.description)) && (amount != other.amount) && (!billDate.equals(other.billDate)))
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", description=" + description + ", amount=" + amount + "]";
	}

}