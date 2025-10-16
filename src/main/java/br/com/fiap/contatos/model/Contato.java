package br.com.fiap.contatos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_CONTATOS")
public class Contato {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_ID_SEQ")
    @SequenceGenerator(
            name = "CONTATO_ID_SEQ",
            sequenceName = "CONTATO_ID_SEQ",
            allocationSize = 1
    )
    private Long id;
    private String nome;
    private String email;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "tipo_contato_id")
    private TipoContato tipoContato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tipoContato=" + (tipoContato != null ? tipoContato.getDescricao() : "null") +
                '}';
    }
}
