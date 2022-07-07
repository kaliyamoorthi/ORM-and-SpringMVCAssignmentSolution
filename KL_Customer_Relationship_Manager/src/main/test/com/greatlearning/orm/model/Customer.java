package com.greatlearning.orm.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String fname;
    String lname;
    String email;
	public String getId() {
		return null;
	}
	public String getFname() {
		return null;
	}
	public String getEmail() {
		return null;
	}
}

