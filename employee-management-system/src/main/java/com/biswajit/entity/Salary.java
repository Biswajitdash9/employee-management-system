package com.biswajit.entity;

import com.biswajit.entity.base.BaseAudit;

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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Salary",

		uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id","month" ,"year"})
		})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salary extends BaseAudit
{
	@Id
	@SequenceGenerator(sequenceName = "Salary_seq",name="gen6",initialValue = 700000,allocationSize = 1)
	@GeneratedValue(generator = "gen6",strategy = GenerationType.AUTO)
	private Long salaryId;
	
	
	@Column(nullable = false)
	private Double basicSalary;
	@Column(nullable = false)
	private Double bonus;
	@Column(nullable = false)
	private Double  deduction;
	@Column(nullable = false)
	private Double netSalary;
	@Column(nullable = false)
	private Integer month;
	@Column(nullable = false)
	private Integer year;
	
	//Relationship with employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee  employee;

}
