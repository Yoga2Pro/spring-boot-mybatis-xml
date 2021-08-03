package com.neo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter

// Serializable for @Cacheable to use
public class User implements Serializable {

	private Long id;
	private String name;
	private Integer age;
	private String address;

	@Override
	public String toString() {
		return "name " + this.name + ", age " + this.age + ", address " + address;
	}

}