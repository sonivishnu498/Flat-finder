package com.example.Flat_finder.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private double rent;
    private int rooms;
    private String status;
    
    @ManyToOne
    private User owner;

	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flat(Long id, String location, double rent, int rooms, String status, User owner) {
		super();
		this.id = id;
		this.location = location;
		this.rent = rent;
		this.rooms = rooms;
		this.status = status;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, location, owner, rent, rooms, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flat other = (Flat) obj;
		return Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(owner, other.owner)
				&& Double.doubleToLongBits(rent) == Double.doubleToLongBits(other.rent) && rooms == other.rooms
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Flat [id=" + id + ", location=" + location + ", rent=" + rent + ", rooms=" + rooms + ", status="
				+ status + ", owner=" + owner + "]";
	}

    
    
    
}
