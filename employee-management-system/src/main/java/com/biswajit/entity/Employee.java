package com.biswajit.entity;

import java.time.LocalDate;
import java.util.List;

import com.biswajit.entity.base.BaseAudit;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseAudit{
	
	//employee data 
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "Emp_seq",initialValue=10001 ,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "gen1")
	private Long employeeId;
	
	@Column(length = 30,nullable = false)
	private String firstName;
	
	@Column(length = 30 ,nullable = false)
	private String lastName;
	
	@Column(length=10,nullable = false)
	private String gender;
	
	@Column(name = "Date_of_Birth" , nullable = false)
	@Past
    private LocalDate dob;
	
	@Column(length = 40,nullable = false)
	private String email;
	
	@Column(name = "phone_number", length = 15, nullable = false, unique = true)
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	private String phoneNumber;
	
	
	@Column(length=200,nullable = false)
	private String address;
	
	@Column(name="Date_of_Joining",nullable = false)
	private LocalDate doj;
	
	@Column(length = 30)
	private String status="active";
	
	
	//Relationships with other tables 
	
	//many employees ->one department
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Department_id")
	private Department department;
	
	//many employees ->one designation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Designation_id")
	private Designation designation;
	
	//one employee ->one user
    @OneToOne(mappedBy = "employee")
	private User user;
    
    
    //one Employee->Many attendance
    @OneToMany(mappedBy = "employee")
    private List<Attendance> attendance;
    
    //one Employee-> Many leaves 
    @OneToMany(mappedBy = "appliedBy")
    private List<Leave> leavesApplied;
    
    //one Employee->many approvers
    @OneToMany(mappedBy = "approvedBy")
    private List<Leave> leavesApproved;
	
	//one to Many . one employee->Many salary
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Salary> salary;	
	

}
