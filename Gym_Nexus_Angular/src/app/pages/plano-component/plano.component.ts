import {Component, Injector, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {ModeEnum} from 'src/app/shared/enum/mode.enum';
import notify from 'devextreme/ui/notify';
import {DxFormComponent} from 'devextreme-angular';
import {Observable} from "rxjs";
import {CrudPadrao} from "../../shared/utils/crud/crud.padrao";
import {CrudBaseComponent} from "../../shared/components/crud-component/crud.base.component";
import {AtivoInativoEnum} from "../../shared/enum/ativo.inativo.enum";
import {Plano} from "../../shared/model/plano";
import {PlanoService} from "../../shared/services/plano.service";
import {formatCurrency} from "@angular/common";


@Component({
  selector: 'plano-component',
  templateUrl: './plano.component.html',
  styleUrls: ['./plano.component.scss']
})
export class PlanoComponent extends CrudPadrao<Plano, any>{

  @ViewChild('formularioPlano', {static: false})
  formularioPlano: DxFormComponent;

  @ViewChild('crud', {static: false}) crud: CrudBaseComponent;

  mode: ModeEnum = ModeEnum.List;
  loadingVisible: boolean = false;
  plano: Plano;
  protected readonly ModeEnum = ModeEnum;
  ativoInativoEnum = Object.values(AtivoInativoEnum);

  constructor(injector: Injector,
              private mainService:PlanoService,
              private router:Router) {
    super(injector, "/plano");
  }

  protected override doOnInit() {
    let isEditing: boolean = this.router.url.split('/').includes('edit');
    if (isEditing) {
      this.mode = ModeEnum.Edit;
      this.model = new Plano();
      this.model.inicio = this.diaHoje;
      this.model.situacao = AtivoInativoEnum.ATIVO;
    }
  }


  override getMainService(): any {
    return this.mainService;
  }

  override validateSave() {
    if(this.model.nome == null){
      notify('Por favor, preencha o Nome do Plano', 'error', 3000);
      return false;
    }
    if(this.model.situacao == null){
      notify('Por favor, preencha a Situação do Plano', 'error', 3000);
      return false;
    }



    return true;
    super.validateSave();
  }

  override beforeDoSave(): Observable<any> | null {
    return super.beforeDoSave();
  }

  createPlano() {
    this.router.navigate(['pages', 'plano', 'edit']);
  }


  protected readonly AtivoInativoEnum = AtivoInativoEnum;
  protected readonly formatCurrency = formatCurrency;
}