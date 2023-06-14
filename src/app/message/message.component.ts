import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-message',
  template: `
    <div 
      *ngIf="hasError()" class="p-message p-message-error">
      {{ text }}
    </div>
  `,
  styles: [
  ]
})

export class MessageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() error: string;
  @Input() control: FormControl;
  @Input() text: string;

  hasError(): boolean {
    return this.control.hasError(this.error) && this.control.dirty;
  }
}
