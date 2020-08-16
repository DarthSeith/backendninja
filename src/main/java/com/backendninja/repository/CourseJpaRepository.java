package com.backendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendninja.entity.Course;

/**
 * JpaRepository ya vienen por defecto los metodos que hacen de operaciones a la
 * Tabla Course
 * 
 * @author gigio
 *
 */
@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

	/**
	 * esta simple sentencia automaticamente nos retorna Cource con sentencia where
	 * price
	 * 
	 * @param price
	 * @return
	 */
	public abstract Course findByPrice(int price);

	/**
	 * esta simple sentencia automaticamente nos retorna Cource con sentencia where
	 * price y nombre
	 * 
	 * @param price
	 * @return
	 */
	public abstract Course findByPriceAndName(int price, String name);

	/**
	 * esta simple sentencia automaticamente nos retorna Cource con sentencia where
	 * nombre ordenados por hora
	 * 
	 * @param price
	 * @return
	 */
	public abstract List<Course> findByNameOrderByHours(String name);

	/**
	 * esta simple sentencia automaticamente nos retorna Cource con sentencia where
	 * nombre o price
	 * 
	 * @param name
	 * @param price
	 * @return
	 */
	public abstract Course findByNameOrPrice(String name, int price);

}
