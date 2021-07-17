package ar.edu.davinci.dvds20211cg2.exception;

public class BusinessException extends Exception {
	

	private static final long serialVersionUID = -8504067597687590455L;

	public BusinessException(String mensaje) {
		super(mensaje);
	}

}
