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
  ];

  categorias = [
    { label: 'Alimentação', value: 1 },
    { label: 'Transporte', value: 2 }
  ];

  pessoas = [
    { label: 'João da Silva', value: 4 },
    { label: 'Sebastião Souza', value: 9 },
    { label: 'Maria Abadia', value: 3 },
  ];
}

export class MyModel {
  value: Date;
}
