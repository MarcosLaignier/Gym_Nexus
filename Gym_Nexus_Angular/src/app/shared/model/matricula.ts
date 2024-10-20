import {Pessoa} from "./pessoa";
import {Plano} from "./plano";
import {AtivoInativoEnum} from "../enum/ativo.inativo.enum";

export class Matricula{

  id: number;

  pessoa: Pessoa;

  plano: Plano;

  inicio: Date;

  fim: Date;

  situacao: AtivoInativoEnum;

  versao: number;

}
