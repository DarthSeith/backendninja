package com.backendninja.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "course") // indica que tabla corresponde
public class Course {

	@Id // primera key
	@GeneratedValue // Hibernate genera el valor por si mismo, no es necesario saber cual es el
					// siguiente digito con esto lo hace
	@Column(name = "idCourse") // nombre del campo
	private int idCourse;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private int price;
	@Column(name = "hours")
	private int hours;

	public Course() {
	}

	public Course(int idCourse, String name, String description, int price, int hours) {
		super();
		this.idCourse = idCourse;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", hours=" + hours + "]";
	}

}
