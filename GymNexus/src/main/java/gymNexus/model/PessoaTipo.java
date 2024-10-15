package gymNexus.model;

import gymNexus.enums.TipoPessoaEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "pessoaTipo")
public class PessoaTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private TipoPessoaEnum tipoPessoa;

    @Version
    private Integer versao;

}
