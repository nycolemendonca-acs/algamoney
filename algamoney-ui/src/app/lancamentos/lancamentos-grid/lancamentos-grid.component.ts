import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-lancamentos-grid',
  templateUrl: './lancamentos-grid.component.html',
  styleUrls: ['./lancamentos-grid.component.css']
})
export class LancamentosGridComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() lancamentos = [];

}
