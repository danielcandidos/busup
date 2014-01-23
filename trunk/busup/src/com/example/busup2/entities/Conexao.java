package com.example.busup2.entities;

public class Conexao {
	
	private Ponto origem;
	private Ponto destino;
	private double distancia;
	
	public Conexao() {
		// TODO Auto-generated constructor stub
	}

	public Ponto getOrigem() {
		return origem;
	}

	public void setOrigem(Ponto origem) {
		this.origem = origem;
	}

	public Ponto getDestino() {
		return destino;
	}

	public void setDestino(Ponto destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	

}
