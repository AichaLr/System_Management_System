import { Component, OnInit } from '@angular/core';
import { Service1Service } from 'src/app/services/service1.service';
import { UserService } from 'src/app/services/user.service';
import { Fournisseur } from 'src/app/models/fournisseur';

@Component({
  selector: 'app-liste-fournisseurs',
  templateUrl: './liste-fournisseurs.component.html',
  styleUrls: ['./liste-fournisseurs.component.css'],
})
export class ListeFournisseursComponent implements OnInit {
  constructor(
    private service: Service1Service,
    private userService: UserService
  ) {}
  context: Fournisseur[];
  ngOnInit(): void {
    this.userService.getlistfournisseurs().subscribe(
      (data) => {
        this.context = data;
      },
      (err) => {
        console.log('error!');
      }
    );
  }
}
