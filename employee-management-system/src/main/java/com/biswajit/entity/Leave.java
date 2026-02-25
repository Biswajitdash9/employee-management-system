package com.biswajit.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employee_Leave")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Leave 
{
	@Id
	@SequenceGenerator(sequenceName = "Leave_seq",name="gen4",initialValue = 200000,allocationSize = 1)
	@GeneratedValue(generator = "gen4",strategy = GenerationType.AUTO)
	private Long leaveId;
	
	@Column(length =30)
	private String leaveType;

	@Column(length=300)
	private String reason;

	
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Column(length = 30)
	private String status;
	
	//Relationship 
	
	//foreign key .Many Leave->one Employee
	//Employee who applied for leave
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id",nullable = false)
	private Employee appliedBy;
	
	//foreign key . Many approver->one employee
	//Employee who approved the leave
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="approved_by")
	private Employee approvedBy;
	
	
	
}
