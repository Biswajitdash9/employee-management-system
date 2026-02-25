package com.biswajit.entity;

import java.util.Set;

import com.biswajit.entity.base.BaseAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User_Table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseAudit
{
	@Id
	@SequenceGenerator(sequenceName = "User_seq",name = "gen3",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "gen3")
	private Long userId;
	
	@Column(length = 30,nullable =false)
	private String userName;
	
	@Column(length = 300,nullable=false)
	private String password;
	
	
   //Realtionship   with  employee table
	//one user->one employee
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_Id")
	private Employee employee;
	
	//Relationship with Role table.Many To Many 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="user_roles",
			joinColumns = @JoinColumn(name="user_id"),
		    inverseJoinColumns=@JoinColumn(name="role_id")
			)
	private Set<Role> roles;
	
	
}
