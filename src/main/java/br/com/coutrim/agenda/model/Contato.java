package br.com.coutrim.agenda.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome")
	@NotNull
	@Size(min = 2, max = 200)
	@JsonProperty
	private String nome;
	
	@Column(name = "num_telefone")
	private String telefone;

	@JsonProperty
	@Column(name = "email")
	@Email
	private String email;
	
	@JsonbDateFormat(value = "yyyy-MM-dd")	
	@Column(name = "data_nascimento")	
	private LocalDate dataNascimento;	
	
	@Size(max = 500)
	@Column(name = "informacoes_extras")
	private String informacoesExtras;
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getInformacoesExtras() {
		return informacoesExtras;
	}
	
	public void setInformacoesExtras(String informacoesExtras) {
		this.informacoesExtras = informacoesExtras;
	}
	
}
