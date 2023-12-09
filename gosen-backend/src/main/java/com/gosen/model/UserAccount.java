package com.gosen.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
	//TODO: Add user account entity.

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	
	/*
	@Column(unique=true)
	private Long userId;
	
	private String password;
	private String profileImgLink;
	
	@OneToMany(mappedBy="userAccount", cascade=CascadeType.ALL)
	@JsonBackReference
	private List<GraphData> graphData;
	*/
}
