package com.example.pontoeletronico.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Empresa implements Serializable {

    private static final long serialVersionUID = 4862991749577621407L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private Date dataCriacao;
    private Date dataAtualizacao;

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

}
