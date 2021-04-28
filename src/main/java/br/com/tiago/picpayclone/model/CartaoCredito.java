package br.com.tiago.picpayclone.model;

import br.com.tiago.picpayclone.enums.BandeiraCartao;
import lombok.*;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CARTAOCREDITO")
public class CartaoCredito extends Entidade {
    @Column(name= "CC_NUMERO", nullable=false)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name= "CC_Bandeira", nullable=false)
    private BandeiraCartao bandeira;

    @Column(name= "CC_Token")
    private String numeroToken;

    @ManyToOne(cascade={ CascadeType.MERGE })
    @JoinColumn(name="CC_Usuario_ID", nullable=false)
    private Usuario usuario;


}
