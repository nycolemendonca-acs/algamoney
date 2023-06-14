import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { InputMaskModule } from 'primeng/inputmask';

import { CadastroPessoasComponent } from './cadastro-pessoas/cadastro-pessoas.component';
import { PesquisaPessoasComponent } from './pesquisa-pessoas/pesquisa-pessoas.component';
import { PessoasGridComponent } from './pessoas-grid/pessoas-grid.component';
import { SharedModule } from 'primeng/api';



@NgModule({
  imports: [
    CommonModule,
    FormsModule,

    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    InputMaskModule,
    
    SharedModule
  ],

  declarations: [
    CadastroPessoasComponent,
    PesquisaPessoasComponent,
    PessoasGridComponent
  ],
  
  exports: [
    CadastroPessoasComponent,
    PesquisaPessoasComponent
  ]
})
export class PessoasModule { }
