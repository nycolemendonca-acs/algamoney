import { Directive, HostBinding, HostListener , Input} from '@angular/core';

@Directive({
  selector: '[appCampoColorido]',
  exportAs: 'campoColorido'
})
export class CampoColoridoDirective {
  @Input() cor = 'dodgerblue';

  @HostBinding('style.backgroundColor') backgroundColor: string;

  constructor() {  }

  @HostListener('focus') colorir() {
    this.backgroundColor = this.cor;
  }

  @HostListener('blur') descolorir() {
    this.backgroundColor = 'transparent';
  }

}
 