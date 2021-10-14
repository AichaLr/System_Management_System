import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Product } from 'src/app/models/product';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  constructor(
    private userService: UserService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}
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

  logout() {
    this.tokenStorageService.signOut();
    this.router.navigate(['/login']);
  }
  addproduct() {
    this.router.navigate(['/addproduct']);
  }
}
