package com.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("NameExampleComponent") // con esto spring guarda en memoria cuando arranca
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

	public void sayHello() {
		LOG.info("Hello From ExampleComponent");
	}

}
