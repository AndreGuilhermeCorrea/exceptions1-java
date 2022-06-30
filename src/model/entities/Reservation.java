package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	//formatar a data como desejada declarando internamente na classe utilizando a mascara abaixo("dd/MM/yyyy")
	//instanciado sdf como static para nao ser instanciado um novo SimpleDateFormat para cada objeto reservation que a aplicação tiver
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// implementação básica da reserva****************

	// construtores
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// implementação para calculo de duração em dias
	public long duration() {

		// método para calcular a diferença de datas por milisegundos(getTime dff)
		long diff = checkOut.getTime() - checkIn.getTime();

		// tipo complexo que tem algumas com algumas operações
		// conversao de milisegundos diff para dias e fazendo o método return o valor
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	//implementação da operação que recebe 02 novas datas e portanto atualizar o checkIn e checkOut
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		//checkin do objeto receber o checkin que veio como argumento método
		this.checkIn = checkIn;
		//checkout do objeto receber o checkout que veio como argumento método
		this.checkOut = checkOut;
	}
	

//toString pra imprimir no formato desejado
	//override pois o toString é uma sobreposição
	@Override
	public String toString() {
		//implementar a lógica do toString
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}
}