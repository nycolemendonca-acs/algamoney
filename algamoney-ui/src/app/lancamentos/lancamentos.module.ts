import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroLancamentosComponent } from './cadastro-lancamentos/cadastro-lancamentos.component';
import { LancamentosGridComponent } from './lancamentos-grid/lancamentos-grid.component';
import { PesquisaLancamentosComponent } from './pesquisa-lancamentos/pesquisa-lancamentos.component';import { FormsModule } from '@angular/forms';

import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { SelectButtonModule } from 'primeng/selectbutton';
import { DropdownModule } from 'primeng/dropdown';
import { MultiSelectModule } from 'primeng/multiselect';
import { InputMaskModule } from 'primeng/inputmask';
import { SharedModule } from "../shared/shared.module";

@NgModule({
    declarations: [
        CadastroLancamentosComponent,
        LancamentosGridComponent,
        PesquisaLancamentosComponent
    ],
    exports: [
        CadastroLancamentosComponent,
        PesquisaLancamentosComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        InputTextModule,
        ButtonModule,
        TableModule,
        TooltipModule,
        InputTextareaModule,
        SelectButtonModule,
        DropdownModule,
        MultiSelectModule,
        InputMaskModule,
        
        SharedModule
    ]
})
export class LancamentosModule { }
