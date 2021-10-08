import { Component, OnInit } from '@angular/core';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-liste-fournisseurs',
  templateUrl: './liste-fournisseurs.component.html',
  styleUrls: ['./liste-fournisseurs.component.css'],
})
export class ListeFournisseursComponent implements OnInit {
  constructor(private service: Service1Service) {}
  context: any;
  ngOnInit(): void {
    this.service.getPublicContent().subscribe(
      (data) => {
        this.context = data;
      },
      (err) => {
        console.log('error!');
      }
    );
  }
}
