package gymNexus.model;

import gymNexus.enums.AtivoInativoEnum;
import gymNexus.utils.Validate.ValidateField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name ="plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ValidateField(message = "O nome do plano deve ser informado!")
    private String nome;

    @ValidateField(message = "O valor do plano deve ser informado!")
    private BigDecimal valor;


    @ValidateField(message = "Informe a data de início do plano.")
    @Temporal(TemporalType.DATE)
    private Date inicio;

    @Temporal(TemporalType.DATE)
    private Date fim;

    @ValidateField(message = "Informe a Situação do plano.")
    private AtivoInativoEnum situacao;

    @Version
    private Integer versao = 0;


}
