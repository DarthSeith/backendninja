package com.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Para dar de alta esta clase se tiene que crear en el WEB creando la clase WebMvcConfiguration de configuracion WebMvcConfigurer
 * @author gigio
 *
 */
@Component("requestTimeInterceptor") // con esto spring guarda en memoria cuando arranca
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	/**
	 * PRIMERO: este metodo se ejecuta ANTES que el metodo del controlador
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return Boolean.TRUE;
	}

	/**
	 * SEGUNDO: este metodo se ejecuta DESPUES que el metodo del controlador y antes
	 * de la vista del navegador
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '".concat(request.getRequestURL().toString()).concat("' -- TOTAL TIME: '")
				.concat(String.valueOf(System.currentTimeMillis() - startTime)).concat("'ms"));

	}

}
