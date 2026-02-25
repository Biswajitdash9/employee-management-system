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
@Entity
@Table(name = "Designation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Designation extends BaseAudit
{
	@Id
	@SequenceGenerator(sequenceName = "Designation_seq",name = "gen2",allocationSize = 5,initialValue = 5005)
//	@GeneratedValue(generator ="gen2",strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "gen2")
	private Long designationId;

	@Column(length = 30,nullable = false)
	private String designationName;
	
	@OneToMany(mappedBy = "designation")
	private List<Employee> employees=new ArrayList<Employee>();
}
