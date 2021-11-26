package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
	@Id // primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	//el column false manda que no se pueda cambiar la fecha de creacion
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	// relacion uno a muchos
	@OneToMany(mappedBy = "proyecto",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Usuario> lista_usuarios;
	
	 //ESTOS LLEVAN GETTER AND SETTERS

	//constructores
	public Proyecto() {
		super();
	}
	public Proyecto(String nombre, String descripcion, Date createAt, Date updateAt) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.createdAt = createAt;
		this.updatedAt = updateAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getCreateAt() {
		return createdAt;
	}
	public void setCreateAt(Date createAt) {
		this.createdAt = createAt;
	}
	public Date getUpdateAt() {
		return updatedAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updatedAt = updateAt;
	}
	public List<Usuario> getUsuarios() {
		return lista_usuarios;
	}
	public void setUsuarios(List<Usuario> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
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
