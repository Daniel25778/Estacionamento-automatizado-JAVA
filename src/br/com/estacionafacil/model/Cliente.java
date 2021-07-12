package br.com.estacionafacil.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Cliente {

	
	private String dataDeEntrada;
	private String horaDeEntrada;
	private String dataDeSaida;
	private String horaDeSaida;
	private String tempoEstacionado;
	private String valorDePagamento;
	private String codigo;
	private String placa;
	private String modelo;
	
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(String dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public String getHoraDeEntrada() {
		return horaDeEntrada;
	}

	public void setHoraDeEntrada(String horaDeEntrada) {
		this.horaDeEntrada = horaDeEntrada;
	}

	public String getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(String dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public String getHoraDeSaida() {
		return horaDeSaida;
	}

	public void setHoraDeSaida(String horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
	}

	public String getTempoEstacionado() {
		return tempoEstacionado;
	}

	public void setTempoEstacionado(String tempoEstacionado) {
		this.tempoEstacionado = tempoEstacionado;
	}

	public String getValorDePagamento() {
		return valorDePagamento;
	}

	public void setValorDePagamento(String valorDePagamento) {
		this.valorDePagamento = valorDePagamento;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	@Override
	public String toString() {
		return codigo + ";" + placa + ";" + modelo + ";" + horaDeEntrada + ";" + dataDeEntrada + ";"
				+ horaDeSaida + ";" + dataDeSaida + ";" + tempoEstacionado + ";" + valorDePagamento;
	}
	
	
}
