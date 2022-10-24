package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Destinos")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "cidade")
	private String cidade;

	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;

	

	public Destino() {
		super();
	}



	



	public Destino(Long id, String cidade, Cliente cliente) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.cliente = cliente;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	



	public String getCidade() {
		return cidade;
	}







	public void setCidade(String cidade) {
		this.cidade = cidade;
	}







	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
