package br.com.ifpe.oxefood.util.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel extends EntidadeNegocio {
    
    @Version
    private Long versao;

    @CreatedDate
    private LocalDate dataCriacao;

    @LastModifiedDate
    private LocalDate dataUltimaModificacao;

   @JsonIgnore
   @Column
    private Long criadoPor; // Id do usuário que o criou
    
    @JsonIgnore
    @Column 
    private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração

}
