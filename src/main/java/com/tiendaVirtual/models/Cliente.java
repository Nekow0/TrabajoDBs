package com.tiendaVirtual.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente {
//Atributos
	@Id // primary key, este es un conjuro magico, de esta forma crea la tabla
		// automaticamente en la base
	// datos
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementable
	private Long id;

	private String rut;
	private String nombre;
	private int edad;
	private String sexo;
// Boolean != boolean
	private Boolean plan;
	private String celular;
	private Date createdAt;
	private Date updatedAt;
// manytomany
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "clientes_proveedores", // tabla intermedia
			joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
	private List<Cliente> proveedores;

//Constructores
	public Cliente() {
		super();
	}

	public Cliente(String rut, String nombre, int edad, String sexo, Boolean plan, String celular) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		edad = edad;
		sexo = sexo;
		plan = plan;
		this.celular = celular;
	}

//Metodos

	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", plan=" + plan
				+ ", celular=" + celular + "]";
	}

//Getters and Setters

	

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getPlan() {
		return plan;
	}

	public void setPlan(Boolean plan) {
		this.plan = plan;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Cliente> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Cliente> proveedores) {
		this.proveedores = proveedores;
	}
	

}
