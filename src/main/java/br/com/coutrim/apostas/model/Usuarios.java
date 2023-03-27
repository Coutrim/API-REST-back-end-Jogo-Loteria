package br.com.coutrim.apostas.model;


import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_USUARIOS")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    public Usuarios(Class<Usuarios> usuariosClass) {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty
    @Column(name = "username")
    private String username;

    @JsonProperty
    @Column(name = "senha")
    private String senha;

    @JsonProperty
    @Column(name = "email")
    private String email;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "imagem", nullable = false, columnDefinition = "longblob")
    private byte[] imagem;

    public Usuarios() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }


}
