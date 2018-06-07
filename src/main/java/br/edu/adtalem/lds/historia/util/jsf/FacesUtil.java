package br.edu.adtalem.lds.historia.util.jsf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.adtalem.lds.historia.util.negocio.NegocioException;

public class FacesUtil {

	public static FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public static ExternalContext getExternalContext(){
		return getFacesContext().getExternalContext();
	}
	
	public static HttpServletRequest getRequest(){
		return (HttpServletRequest) getExternalContext().getRequest();
	}
	
	public static HttpServletResponse getResponse(){
		return (HttpServletResponse) getExternalContext().getResponse();
	}
	
	public static ServletContext getServletContext(){
		return (ServletContext) getExternalContext().getContext();
	}
	
    public static boolean isPostBack() {
        return getFacesContext().isPostback();
    }
    public static boolean isNotPostBack() {
        return !getFacesContext().isPostback();
    }	
	
	public static void addErrorMessage(String message){
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessage(String message){
		getFacesContext().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	public static String getUrlLogo(){
		return FacesUtil.getExternalContext().getRealPath("/resources/images/");
	}

    public static String getDiretorioRelatorios(){
        String diretorio = FacesUtil.getExternalContext().getRealPath("/relatorios/");
        return diretorio;
    }	
	
    public static String getDiretorioRemessa(){
        ServletContext servletContext = FacesUtil.getServletContext();
        String diretorio = servletContext.getRealPath("") + "resources" + File.separator + "uploads" +
                File.separator + "edi" + File.separator + "remessa" + File.separator;
        return diretorio;
    }
    
    public static String getDiretorioRetorno(){
        ServletContext servletContext = FacesUtil.getServletContext();
        String diretorio = servletContext.getRealPath("") + "resources" + File.separator + "uploads" +
                File.separator + "edi" + File.separator + "retorno" + File.separator;
        return diretorio;
    }    
	
	public static void gerarLog(String nomeArquivo, StringBuilder texto){		
		try {
			BufferedWriter arquivo = new BufferedWriter(new FileWriter(nomeArquivo));
			arquivo.write(texto.toString());
			arquivo.flush();
			arquivo.close();
		} catch (IOException e) {
			throw new NegocioException("Ocorreu um erro ao criar o log: "+nomeArquivo);
		}		
	}
	
	public static String getUrlFotoAluno(){
		return FacesUtil.getExternalContext().getRealPath("/resources/uploads/alunos/fotos/");
	}
	
}
