import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/model/user.model';

@Component({
  selector: 'app-display-details',
  templateUrl: './display-details.component.html',
  styleUrls: ['./display-details.component.css']
})
export class DisplayDetailsComponent {
  @Input()
  user: User[];
}
