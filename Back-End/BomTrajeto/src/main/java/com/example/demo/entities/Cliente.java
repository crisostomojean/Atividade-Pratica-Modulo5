package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Clientes")
public class Cliente {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "cpf")
	private float cpf;
	
	@Column(name = "nascimento")
	private float nascimento;
	
	@Column(name = "email")
	private String email;
	
	
	
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Destino> destinos = new ArrayList<Destino>();

	
	
	
	
	
	
	public List<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public Cliente() {
		super();
	}

	

	

	public Cliente(long id, String nome, float cpf, float nascimento, String email, List<Destino> destinos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
		this.destinos = destinos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getCpf() {
		return cpf;
	}

	public void setCpf(float cpf) {
		this.cpf = cpf;
	}

	
	public float getNascimento() {
		return nascimento;
	}

	public void setNascimento(float nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
}
