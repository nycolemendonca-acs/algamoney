import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pesquisa-lancamentos',
  templateUrl: './pesquisa-lancamentos.component.html',
  styleUrls: ['./pesquisa-lancamentos.component.css']
})
export class PesquisaLancamentosComponent {

  lancamentos = [
    {
      tipo: 'DESPESA',
      descricao: 'Compra de pão',
      vencimento: '30/06/2017',
      pagamento: null,
      valor: 4.55, 
      pessoa: 'Padaria do José'
    },
    {
      tipo: 'RECEITA',
      descricao: 'Venda de software', 
      vencimento: '10/06/2017', 
      pagamento: '09/06/2017', 
      valor: 80000, 
      pessoa: 'Atacado Brasil'
    },
    {
      tipo: 'DESPESA', 
      descricao: 'Impostos', 
      vencimento: '20/07/2017', 
      pagamento: null, 
      valor: 14312, 
      pessoa: 'Ministério da Fazenda'
    },
    {
      tipo: 'DESPESA', 
      descricao: 'Mensalidade escolar', 
      vencimento: '05/06/2017', 
      pagamento: '30/05/2017', 
      valor: 800, 
      pessoa: 'Escola Abelha Rainha'
    },
    {
      tipo: 'RECEITA', 
      descricao: 'Venda de carro', 
      vencimento: '18/08/2017', 
      pagamento: null, 
      valor: 55000, 
      pessoa: 'Sebastião Souza'
    },
    {
      tipo: 'DESPESA', 
      descricao: 'Aluguel', 
      vencimento: '10/07/2017', 
      pagamento: '09/07/2017', 
      valor: 1750, 
      pessoa: 'Casa Nova Imóveis'
    },
    {
      tipo: 'DESPESA', 
      descricao: 'Mensalidade musculação', 
      vencimento: '13/07/2017', 
      pagamento: null, 
      valor: 180, pessoa: 'Academia Top'
    }
  ];

}
