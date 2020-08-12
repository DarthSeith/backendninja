package com.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.backendninja.model.Person;
import com.backendninja.service.ExampleService;

/**
 * los Services va toda la logica la aplicacion los Controller solo llama a los
 * servicios
 * 
 * @author gigio
 *
 */
@Service("exampleService") // con esto se genera un bean cuando arranque el servidor
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> lst = new ArrayList<Person>();
		lst.add(new Person("one", 1));
		lst.add(new Person("two", 2));
		lst.add(new Person("tree", 3));
		lst.add(new Person("forth", 4));
		lst.add(new Person("five", 5));
		lst.add(new Person("six", 6));
		LOG.info("HELLO FROM SERVICES");
		return lst;
	}

}
