package com.biswajit.entity;

import java.util.List;
import java.util.Set;

import com.biswajit.entity.base.BaseAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseAudit
{
	@Id
	@SequenceGenerator(sequenceName = "Role_seq",name="gen5",initialValue = 60000,allocationSize = 1)
	@GeneratedValue(generator = "gen5",strategy = GenerationType.AUTO)
	private Long roleId;
	
	@Column(length = 15,nullable = false)
	private String roleName;
	
	//Relation with User table
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users; 
	

}
