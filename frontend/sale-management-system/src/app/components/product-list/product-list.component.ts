import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  constructor(private userService: UserService) {}
  context: Product[];
  ngOnInit(): void {
    this.userService.getlistproduits().subscribe(
      (data) => {
        this.context = data;
      },
      (err) => {
        console.log('error!');
      }
    );
  }
}
