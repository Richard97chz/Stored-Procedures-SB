package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity   //Genera la tabla en la BDs
public class Coche {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//Autoincremento
	private int id;
	private String marca;
	private String modelo;
	private int anyo;
	private int km;
	
	public Coche() {				//Constructor vacío
	}
	
	public Coche(String marca, String modelo, int anyo, int km) {	//Constructor con todo los campos
		this.marca=marca;
		this.modelo=modelo;
		this.anyo=anyo;
		this.km=km;
	}
	
	//Get set para todos
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca=marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	
	public int getAnyo() {
		return anyo;
	}
	
	public void setAnyo(int anyo) {
		this.anyo=anyo;
	}
	
	public int getKm() {
		return km;
	}
	
	public void setKm(int km) {
		this.km=km;
	}
}

