package br.com.coutrim.apostas.dto;

import org.glassfish.grizzly.http.util.TimeStamp;

public class ApostasDto {
    private static final long serialVersionUID = 1L;

    private Long id;
    private TimeStamp data;
    private Integer erros;
    private Integer acertos;
    private Double ganhos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TimeStamp getData() {
        return data;
    }

    public void setData(TimeStamp data) {
        this.data = data;
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
