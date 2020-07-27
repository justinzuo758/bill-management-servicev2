package com.code.assessment.billmanagementservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

//Friend entity
@Entity
@Table(
		name = "friends",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name"})}
	)
public class Friend {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	private String lastName;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "friends_bills", 
		joinColumns = { @JoinColumn(name = "friend_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "bill_id") })
	private Set<Bill> bills = new HashSet<>();

	public Friend() {
	}

	public Friend(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Bill> getBills() {
		return bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + firstName.hashCode();
		result = prime * result + lastName.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Friend))
			return false;
		Friend other = (Friend) obj;
		if ((!firstName.equals(other.firstName)) && (!lastName.equals(other.lastName)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
