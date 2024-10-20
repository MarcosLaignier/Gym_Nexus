import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CrudServicePadrao} from "../utils/service/crud.service.padrao";
import {Plano} from "../model/plano";

@Injectable()
export class PlanoService extends CrudServicePadrao<Plano,any> {


  constructor(http: HttpClient) {
    super(http, 'plano');
  }

}
