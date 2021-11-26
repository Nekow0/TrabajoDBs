package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="celulares")
public class Celular {
	@Id // primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable
	private Long id;
	
	private int numero;
	private String marca;
	//relacion 1 a 1 LAZY =cuando se consulta por usuario, trae toda la info y tambien la del celular
	//incluye tabla foraneas
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Celular() {
		super();
	}
	public Celular(int numero, String marca) {
		super();
		this.numero = numero;
		this.marca = marca;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
