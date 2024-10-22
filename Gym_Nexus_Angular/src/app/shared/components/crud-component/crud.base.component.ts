import {Component, EventEmitter, Input, Output} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ModeEnum} from "../../enum/mode.enum";

@Component({
  selector: 'crud',
  templateUrl: './crud.base.component.html',
  styleUrls: ['./crud.base.component.scss']
})
export class CrudBaseComponent {

  modes: any = ModeEnum;

  @Input()
  mode:ModeEnum = ModeEnum.List

  @Input() editToolbarTitle:String;
  @Input() listToolbarTitle:String;


  /**
   * filter button
   */
  @Input() listToolbarFilterButtonIconClass = "fa fa-search";
  @Input() listToolbarFilterButtonText = "Filtrar";
  @Input() listToolbarFilterButtonShow = true;
  @Input() listToolbarFilterButtonDisabled = false;

  /**
   * new button
   */
  @Input() listToolbarNewButtonIconClass = "fa fa-plus-square";
  @Input() listToolbarNewButtonText = "Novo";
  @Input() listToolbarNewButtonShow = true;
  @Input() listToolbarNewButtonDisabled = false;

  /**
   * clear button
   */
  @Input() listToolbarClearButtonIconClass = "fa fa-eraser";
  @Input() listToolbarClearButtonText = "Limpar";
  @Input() listToolbarClearButtonShow = true;
  @Input() listToolbarClearButtonDisabled = false;


  /**
   * close button
   */
  @Input() listToolbarCloseButtonIconClass = "fa fa-times-circle";
  @Input() listToolbarCloseButtonText = "Fechar";
  @Input() listToolbarCloseButtonShow = true;
  @Input() listToolbarCloseButtonDisabled = false;



  @Output() filtrar = new EventEmitter();
  @Output() novoCadastro = new EventEmitter();
  @Output() salvar = new EventEmitter();
  @Output() deletar = new EventEmitter();
  @Output() clear = new EventEmitter();

  @Input() cadastro: boolean;

  @Input() desativarBotaoFechar: boolean;

  edit: boolean;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.edit = this.router.url.includes('edit/')
  }

  filtrarEnv(e: any) {
    this.filtrar.emit(e);
  }

  novoCadEnv(e: any) {
    this.novoCadastro.emit(e);
    this.mode = ModeEnum.Edit;
    this.navigateToEdit(true, null);


  }

  clearEnv(e: any) {
    this.clear.emit(e);
  }

  salvaEnv(e: any) {
    this.salvar.emit(e);
  }

  deleteEnv(e: any) {
    this.deletar.emit(e);
  }

  voltar() {
    window.history.back();
  }


  /** Metodo responsavel por navegar ate a rota de edit diante da rota atual
   *
   */
  navigateToEdit(novo:boolean, idEdicao:any) {
    // Obtendo a rota atual
    const currentRoute = this.activatedRoute.snapshot.url.map(segment => segment.path).join('/');
    // Montando a nova rota

    let newRoute = `${currentRoute}`
    if(!this.router.url.split('/').includes('edit')){
      newRoute += `/edit`;
    }


    // Navegando para a nova rota
    this.router.navigate([newRoute]);
  }

}
