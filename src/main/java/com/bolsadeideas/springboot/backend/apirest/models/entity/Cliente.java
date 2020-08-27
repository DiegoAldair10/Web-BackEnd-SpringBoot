package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 2, max = 12, message = "el tamaño tiene que estar entre 4 y 12")
	@Column(nullable = false)
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	private String apellido;

	@NotEmpty(message = "no puede estar vacio")
	@Size(max = 8, message = "el tamaño tiene ser 8 digitos")
	private String dni;

	@NotEmpty(message = "no puede estar vacio")
	@Size(max = 9, message = "el tamaño tiene ser 9 digitos")
	private String telefono;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "fechacliente")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@NotNull(message = "la distrito no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "distrito_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Distrito distrito;

	@JsonIgnoreProperties(value = { "cliente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Alquiler> alquiler;

	public Cliente() {
		this.alquiler = new ArrayList<Alquiler>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Alquiler> getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(List<Alquiler> alquiler) {
		this.alquiler = alquiler;
	}

	private static final long serialVersionUID = 1L;

}
