package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alquiler")
public class Alquiler implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 6, message = "el tamaño tiene que estar entre 4 y 6")
	@Column(name = "numero_Alquiler")
	private String numeAlqui;

	@NotEmpty(message = "la descripción debe ser oblicatoria")
	private String descrepcion;

	@NotNull(message = "Debes especificar el precio")
	@Min(value = 0, message = "El precio mínimo es 0")
	private Double preAlqui;

	@NotEmpty(message = "la fecha debe ser obligatoria")
	@Column(name = "fechaAlquiler")
	@Temporal(TemporalType.DATE)
	private Date fechaAlqui;

	@JsonIgnoreProperties(value = { "alquiler", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "alquiler_id")
	private List<ItemAlquiler> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeAlqui() {
		return numeAlqui;
	}

	public void setNumeAlqui(String numeAlqui) {
		this.numeAlqui = numeAlqui;
	}

	public String getDescrepcion() {
		return descrepcion;
	}

	public void setDescrepcion(String descrepcion) {
		this.descrepcion = descrepcion;
	}

	public Double getPreAlqui() {
		return preAlqui;
	}

	public void setPreAlqui(Double preAlqui) {
		this.preAlqui = preAlqui;
	}

	public Date getFechaAlqui() {
		return fechaAlqui;
	}

	public void setFechaAlqui(Date fechaAlqui) {
		this.fechaAlqui = fechaAlqui;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemAlquiler> getItems() {
		return items;
	}

	public void setItems(List<ItemAlquiler> items) {
		this.items = items;
	}

	private static final long serialVersionUID = 1L;

}
