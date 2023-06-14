import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { TabViewModule } from 'primeng/tabview';
import { InputTextModule } from 'primeng/inputtext'; 
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { TooltipModule } from 'primeng/tooltip';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { SelectButtonModule } from 'primeng/selectbutton';
import { DropdownModule } from 'primeng/dropdown';
import { MultiSelectModule } from 'primeng/multiselect';
import { InputMaskModule } from 'primeng/inputmask';


import { AppComponent } from './app.component';
import { PesquisaLancamentosComponent } from './pesquisa-lancamentos/pesquisa-lancamentos.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PesquisaPessoasComponent } from './pesquisa-pessoas/pesquisa-pessoas.component';
import { FuncionarioCardComponent } from './funcionario-card/funcionario-card.component';
import { FuncionarioFormComponent } from './funcionario-form/funcionario-form.component';
import { CampoColoridoDirective } from './campo-colorido.directive';
import { CadastroLancamentosComponent } from './cadastro-lancamentos/cadastro-lancamentos.component';
import { CadastroPessoasComponent } from './cadastro-pessoas/cadastro-pessoas.component';
import { FormsModule } from '@angular/forms';
import { MessageComponent } from './message/message.component';
import { LancamentosGridComponent } from './lancamentos-grid/lancamentos-grid.component';
import { PessoasGridComponent } from './pessoas-grid/pessoas-grid.component';

@NgModule({
  declarations: [
    AppComponent,
    PesquisaLancamentosComponent,
    NavbarComponent,
    PesquisaPessoasComponent,
    FuncionarioCardComponent,
    FuncionarioFormComponent,
    CampoColoridoDirective,
    CadastroLancamentosComponent,
    CadastroPessoasComponent,
    MessageComponent,
    LancamentosGridComponent,
    PessoasGridComponent
  ],
  imports: [
    BrowserModule,
    TabViewModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    InputTextareaModule,
    SelectButtonModule,
    DropdownModule,
    MultiSelectModule,
    InputMaskModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
