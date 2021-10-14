import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { Service1Service } from 'src/app/services/service1.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent implements OnInit {
  product: any;

  constructor(private service: Service1Service, private router: Router) {}

  ngOnInit(): void {
    this.product = new Product();
  }
  saveProduct(formData) {
    console.log(formData.productName);
    console.log(formData.quantity);
    console.log(formData.price);
    const produit: Product = {
      id: '1',
      qtt: formData.quantity,
      intitule: formData.productName,
      prix_unitaire: formData.price,
      montant: formData.price * formData.quantity,
    };

    this.service.addproduct(produit).subscribe(
      (data) => {
        console.log(data);
      },
      (err) => {
        console.log('errror');
      }
    );
    this.router.navigate(['/produits']);
  }
}
