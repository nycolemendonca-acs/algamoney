import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-pessoas-grid',
  templateUrl: './pessoas-grid.component.html',
  styleUrls: ['./pessoas-grid.component.css']
})
export class PessoasGridComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() pessoas = [];
}
