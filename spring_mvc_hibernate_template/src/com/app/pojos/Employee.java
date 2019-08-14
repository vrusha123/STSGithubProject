package com.app.pojos;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="employee")
public class Employee {
	private Integer empId;
	
	@Length(min=3,max=20,message="Invalid Name length")
	private String firstName;
	@Length(min=3,max=20,message="Invalid Name length")
	private String lastName;
	@NotEmpty(message="address must be supplied")
	private String adress;
	private Date dob;
	private String mobile;
	@NotEmpty(message="city must be supplied")
	private String city;
	private Manager managerId;
	public Employee() {
		System.out.println("in employee ctor");
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(length=10,unique=true)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="managerId")
	public Manager getManagerId() {
		return managerId;
	}
	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", adress=" + adress
				+ ", dob=" + dob + ", mobile=" + mobile + ", city=" + city + "]";
	}
	public Employee(Integer empId, String firstName, String lastName, String adress, Date dob, String mobile,
			String city) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.dob = dob;
		this.mobile = mobile;
		this.city = city;
	}
	

}
