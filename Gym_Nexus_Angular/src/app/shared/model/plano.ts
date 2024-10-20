import {AtivoInativoEnum} from "../enum/ativo.inativo.enum";

export class Plano{

  id: number;

  nome: string;

  valor: number;

  inicio:Date;

  fim: Date;

  situacao: AtivoInativoEnum;

  versao: number;
}
