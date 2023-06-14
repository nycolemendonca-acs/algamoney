import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'algamoney';
  nome = 'Margot Mendonça';
  dataAniversario = new Date(2016, 6, 1);
  preco = 12855.32;
  troco = 0.57392;
}
