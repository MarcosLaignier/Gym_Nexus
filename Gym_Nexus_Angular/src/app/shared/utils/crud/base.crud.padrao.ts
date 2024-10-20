import {
  AfterContentChecked,
  AfterContentInit, AfterViewChecked,
  AfterViewInit,
  Directive,
  DoCheck, Injector,
  OnChanges, OnDestroy,
  OnInit, SimpleChanges
} from "@angular/core";

@Directive()
export abstract class BaseCrudPadrao implements AfterViewInit, OnInit, OnChanges, DoCheck, AfterContentInit,
  AfterContentChecked, OnDestroy, AfterViewChecked {

  dateFormat = 'dd/MM/yyyy';
  currencyFormatPadrao = 'R$ ##,##0.00';
  diaHoje = new Date();

  ngAfterContentChecked(): void {
    this.doAfterChecked()
  }

  ngAfterContentInit(): void {
    this.doAfterInit()
  }

  ngAfterViewChecked(): void {
    this.doAfterViewChecked()
  }

  ngAfterViewInit(): void {
    this.doAfterViewInit()
  }

  ngDoCheck(): void {
    this.doDoCheck()
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.ngOnChanges(changes);
  }

  ngOnDestroy(): void {
    this.doOnDestroy()
  }

  ngOnInit(): void {
    this.doOnInit()
  }

  constructor(injector: Injector) {
  }

  protected doDoCheck() {
  }

  protected  doOnInit(){

  }

  protected doOnDestroy(){

  }

  protected doAfterInit(){

  }

  protected doAfterChecked(){

  }

  protected doAfterViewChecked(){

  }

  protected doAfterViewInit(){

  }
}
