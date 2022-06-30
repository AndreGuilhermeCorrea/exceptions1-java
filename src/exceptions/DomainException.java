package exceptions;

//RuntimeException é uma exceção que o compilador nao obriga tratar
public class DomainException extends RuntimeException {
	
	//declaração da versão de uma classe serial
	private static final long serialVersionUID = 1L;
	
	//Construtor que recebe string como argumento
	public DomainException(String msg) {
		
		//repassando a mensagem para o construtor da super classe 
		
		//com a finalidadede permitir a instanciação da exceção personalizada pasando uma mensagem
		//fazendocom que a mensagem fique armazenada dentro da exceção 
		super(msg);
	}
}