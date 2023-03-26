package br.com.coutrim.apostas.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.codehaus.jackson.annotate.JsonProperty;
import org.glassfish.grizzly.http.util.TimeStamp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "TB_APOSTAS")
public class Apostas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "data")
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-ddHH:mm:ss")
	private Date data;

	@Column(name = "erros")
	private Integer erros;

	@JsonProperty
	@Column(name = "acertos")
	private Integer acertos;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@JsonProperty
	@Column(name = "ganhos")
	private Double ganhos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Integer getErros() {
		return erros;
	}

	public void setErros(Integer erros) {
		this.erros = erros;
	}

	public Integer getAcertos() {
		return acertos;
	}

	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}

	public Double getGanhos() {
		return ganhos;
	}

	public void setGanhos(Double ganhos) {
		this.ganhos = ganhos;
	}


}

