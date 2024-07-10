package com.nitienit.accounts.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_account")
public class Account {
	
	@Id
	@Column(nullable = false)
	private Long accountNo;
	@Column(nullable = false)
	private Long customerId;
	@Column(nullable = false)
	private String accountType;
	@Column(nullable = false)
	private String branchName;
	@Column(nullable = false)
	private String branchAddress;

}
