package br.com.caixa.restCaixa.excecao;

public class ObjectoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
       public ObjectoNotFoundException(String msn) {
    	   super(msn);
       }
       public ObjectoNotFoundException(String msg, Throwable cause) {
   		super(msg, cause);
   	}
}
