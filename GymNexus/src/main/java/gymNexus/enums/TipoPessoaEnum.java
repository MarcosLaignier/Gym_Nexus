package gymNexus.enums;

public enum TipoPessoaEnum {

    ALUNO("ALUNO"),
    ADMINISTRATIVO("ADMINISTRATIVO"),
    PROFESSOR("PROFESSOR"),
    PERSONAL_EXTERNO("PERSONAL EXTERNO");

    TipoPessoaEnum(String nome){
        this.nome = nome;
    }

    private String nome;
}
