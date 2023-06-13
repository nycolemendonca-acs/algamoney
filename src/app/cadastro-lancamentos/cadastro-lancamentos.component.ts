import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-lancamentos',
  templateUrl: './cadastro-lancamentos.component.html',
  styleUrls: ['./cadastro-lancamentos.component.css']
})
export class CadastroLancamentosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  tipos = [
    { label: 'Receita', value: 'RECEITA' },
    { label: 'Despesa', value: 'DESPESA' }
  ]
}

export class MyModel {
  value: Date;
}
