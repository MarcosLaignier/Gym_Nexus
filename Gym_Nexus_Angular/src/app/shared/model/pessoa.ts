import {AtivoInativoEnum} from "../enum/ativo.inativo.enum";
import {PessoaTipo} from "./pessoa.tipo";

export class Pessoa{

  id: number;

  nome: string;

  documento: string;

  nascimento: Date;

  situacao: AtivoInativoEnum;

  pessoaTipoList: PessoaTipo[];

  versao: number;
}
