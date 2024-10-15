package gymNexus.model;

import gymNexus.enums.AtivoInativoEnum;
import gymNexus.enums.TipoPessoaEnum;
import gymNexus.utils.Validate.ValidateField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name ="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ValidateField(message = "O Nome deve ser Informado!")
    private String nome;

    @Column(unique = true)
    @ValidateField(message = "O Documento deve ser Informado!")
    private String documento;

    @ValidateField(message = "A Data de Nascimento deve ser Informada!")
    @Temporal(TemporalType.DATE)
    private Date nascimento;


    @Enumerated(EnumType.STRING)
    private AtivoInativoEnum situacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pessoa")
    private List<PessoaTipo> pessoaTipoList;

    @Version
    private Integer versao = 0;


}
