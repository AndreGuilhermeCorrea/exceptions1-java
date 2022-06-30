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
	//instanciado sdf como static para nao ser instanciado um novo SimpleDateFormat para cada objeto reservation que a aplica��o tiver
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// implementa��o b�sica da reserva****************

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

	// implementa��o para calculo de dura��o em dias
	public long duration() {

		// m�todo para calcular a diferen�a de datas por milisegundos(getTime dff)
		long diff = checkOut.getTime() - checkIn.getTime();

		// tipo complexo que tem algumas com algumas opera��es
		// conversao de milisegundos diff para dias e fazendo o m�todo return o valor
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	//implementa��o da opera��o que recebe 02 novas datas e portanto atualizar o checkIn e checkOut
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		//checkin do objeto receber o checkin que veio como argumento m�todo
		this.checkIn = checkIn;
		//checkout do objeto receber o checkout que veio como argumento m�todo
		this.checkOut = checkOut;
	}
	

//toString pra imprimir no formato desejado
	//override pois o toString � uma sobreposi��o
	@Override
	public String toString() {
		//implementar a l�gica do toString
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}
}