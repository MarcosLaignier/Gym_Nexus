package gymNexus.model;

import gymNexus.enums.AtivoInativoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name ="matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name="pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name="plano")
    private Plano plano;

    @Temporal(TemporalType.DATE)
    private Date inicio;

    @Temporal(TemporalType.DATE)
    private Date fim;

    private AtivoInativoEnum situacao;

    @Version
    private Integer versao = 0;


}
