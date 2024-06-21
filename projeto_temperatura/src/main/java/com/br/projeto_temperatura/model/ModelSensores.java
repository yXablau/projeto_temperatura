package com.br.projeto_temperatura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "sensores")
public class ModelSensores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idSensor")
	private Integer id;
	@Column(name="nome", length = 255, nullable = true)
	private String nome;
	@Column(name="latitude", length = 10, nullable = true)
	private String latitude;
	@Column(name="longitude",  length = 10, nullable = true)
	private String Longitude;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}







}
