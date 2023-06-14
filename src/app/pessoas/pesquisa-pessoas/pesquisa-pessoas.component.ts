import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pesquisa-pessoas',
  templateUrl: './pesquisa-pessoas.component.html',
  styleUrls: ['./pesquisa-pessoas.component.css']
})
export class PesquisaPessoasComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  pessoas = [
    {
      nome: "Manoel Pinheiro",
      cidade: "Uberlândia", 
      estado: "MG",
      ativo: true
    },
    {
      nome: "Sebastião da Silva",
      cidade: "São Paulo", 
      estado: "SP",
      ativo: false
    },
    {
      nome: "Carla Souza",
      cidade: "Florianópolis", 
      estado: "SC",
      ativo: true
    },
    {
      nome: "Luís Pereira",
      cidade: "Curitiba", 
      estado: "PR",
      ativo: true
    },
    {
      nome: "Vilmar Andrade",
      cidade: "Rio de Janeiro", 
      estado: "RJ",
      ativo: false
    },
  ];
}
