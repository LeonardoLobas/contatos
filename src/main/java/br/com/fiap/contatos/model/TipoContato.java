package br.com.fiap.contatos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_TIPO_CONTATO")
public class TipoContato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPO_CONTATO_ID_SEQ")
    @SequenceGenerator(
            name = "TIPO_CONTATO_ID_SEQ",
            sequenceName = "TIPO_CONTATO_ID_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, length = 50)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoContato{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

