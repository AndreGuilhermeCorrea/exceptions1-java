package exceptions;

//RuntimeException � uma exce��o que o compilador nao obriga tratar
public class DomainException extends RuntimeException {
	
	//declara��o da vers�o de uma classe serial
	private static final long serialVersionUID = 1L;
	
	//Construtor que recebe string como argumento
	public DomainException(String msg) {
		
		//repassando a mensagem para o construtor da super classe 
		
		//com a finalidadede permitir a instancia��o da exce��o personalizada pasando uma mensagem
		//fazendocom que a mensagem fique armazenada dentro da exce��o 
		super(msg);
	}
}