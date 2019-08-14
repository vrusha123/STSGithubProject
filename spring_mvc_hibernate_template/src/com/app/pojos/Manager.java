package com.app.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="manager")
public class Manager {
	private Integer managerId;
	@NotEmpty
	@Email
	private String email;
	@Length(min=3,max=20,message="Invalid Name length")
	private String firstName;
	@Length(min=3,max=20,message="Invalid Name length")
	private String lastName;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Blank or Invalid Password")
	private String password;
	@NotEmpty(message="address must be supplied")
	private String adress;
	private Date dob;
	private String company;
	private Set<Employee> employee=new HashSet<>();
	public Manager() {
		System.out.println("In Manager Ctor");
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCompany() {
		return company;
	}
	@JsonIgnore
	@OneToMany(mappedBy="managerId",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Manager(Integer managerId, String email, String firstName, String lastName, String password, String adress,
			Date dob, String company) {
		super();
		this.managerId = managerId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.adress = adress;
		this.dob = dob;
		this.company = company;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", adress=" + adress + ", dob=" + dob + ", company=" + company
				+ "]";
	}
	

}
