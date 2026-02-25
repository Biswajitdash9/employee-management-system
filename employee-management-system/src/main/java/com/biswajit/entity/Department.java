package com.biswajit.entity;

import java.util.ArrayList;
import java.util.List;

import com.biswajit.entity.base.BaseAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Department")
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Department extends BaseAudit{
	
	@Id
	@SequenceGenerator(sequenceName = "Department_seq",name = "gen2",allocationSize = 5,initialValue = 6000)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "gen2")
	private Long departmentId;
	
	
	@Column(length = 30,nullable = false)
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees=new ArrayList<Employee>();

}
