package com.library.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fines")
public class Fine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "borrow_id", nullable = false)
	private Borrow borrow;
	
	private double fineAmount;
	private boolean paid;
	private Date fineDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Borrow getBorrow() {
		return borrow;
	}
	
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	
	public double getFineAmount() {
		return fineAmount;
	}
	
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public Date getFineDate() {
		return fineDate;
	}
	
	public void setFineDate(Date fineDate) {
		this.fineDate = fineDate;
	}
	
	
	
}
