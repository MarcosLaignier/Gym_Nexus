import {Pessoa} from "./pessoa";
import {TipoPessoaEnum} from "../enum/tipo.pessoa.enum";

export class PessoaTipo{

  id: number;

  pessoa: Pessoa;

  tipoPessoa: TipoPessoaEnum;

  versao: number;
}
