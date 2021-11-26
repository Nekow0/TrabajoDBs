package com.nttdata.models;
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
@Entity //representacion de la entidad modelo
@Table(name="proveedores") // nombre de la tabla en la db

public class Proveedor {
	@Id // primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;
	private int edad;
	private Date createdAt;
	private Date updatedAt;
	//relacion manytomany LAZY OBLIGA PASAR TODA LA INFO CUANDO SE VA A BUSCAR
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(
			name="clientes_proveedores", //tabla intermedia que contiene las llaves las llaves foraneas
			joinColumns =@JoinColumn(name="proveedor_id"),
			inverseJoinColumns=@JoinColumn(name="cliente_id")
			)
	private List<Cliente> clientes;
	
	public Proveedor() {
		super();
	}

	public Proveedor(String nombre, String apellido, String email, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", edad=" + edad + "]";
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
}
