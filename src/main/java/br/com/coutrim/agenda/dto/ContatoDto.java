package br.com.coutrim.agenda.dto;

import java.time.LocalDate;

public class ContatoDto {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String telefone;

    private String email;

    private LocalDate dataNascimento;

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
