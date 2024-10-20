import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CrudServicePadrao} from "../utils/service/crud.service.padrao";
import {Matricula} from "../model/matricula";

@Injectable()
export class MatriculaService extends CrudServicePadrao<Matricula,any> {


  constructor(http: HttpClient) {
    super(http, 'matricula');
  }

}

