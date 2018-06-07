package br.edu.adtalem.lds.historia.util.jsf;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.edu.adtalem.lds.historia.util.negocio.NegocioException;



public class JsfExceptionHandler extends ExceptionHandlerWrapper {

	private static Log log = LogFactory.getLog(JsfExceptionHandler.class);
	
	private ExceptionHandler wrapped;
	
	public JsfExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}
	
	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable exception = context.getException();
			NegocioException negocioException = getNegocioException(exception);
			
			boolean handled = false;
			
			try{
				if(exception instanceof ViewExpiredException){
					handled = true;
					redirect("/");
				}else if(negocioException != null){
					handled = true;
					FacesUtil.addErrorMessage(negocioException.getMessage());
				}else{
					handled = true;
					SimpleDateFormat formatadorData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					log.error(String.format("%s - Error do sistema: %s", 
							formatadorData.format(new Date()), exception.getMessage()), exception);
					redirect("/Error.jsf");
				}
			}finally{
				if(handled)
					events.remove();
			}
		}
		//Terminei meu trabalho agora é com você 
		getWrapped().handle();
	}
	
	private void redirect(String page){
		try{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();
			
			externalContext.redirect(contextPath+page);
			
		}catch(IOException e){
			throw new FacesException(e);
		}
	}
	
	private NegocioException getNegocioException(Throwable exception){
		if(exception instanceof NegocioException){
			return (NegocioException) exception;
		}else if(exception.getCause() != null){
			getNegocioException(exception.getCause());			
		}
		return null;
	}
	
}
