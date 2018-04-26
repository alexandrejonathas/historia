package br.edu.adtalem.lds.historia.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class JsfExceptionHandlerFactory extends ExceptionHandlerFactory{

	private ExceptionHandlerFactory factory;
	
	public JsfExceptionHandlerFactory(ExceptionHandlerFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfExceptionHandler(this.factory.getExceptionHandler());
	}

}
