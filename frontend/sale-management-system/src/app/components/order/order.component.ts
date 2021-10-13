import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { UserService } from 'src/app/services/user.service';
import { Fournisseur } from 'src/app/models/fournisseur';
import { Order, Status } from 'src/app/models/order';
import { Service1Service } from 'src/app/services/service1.service';
import { stringify } from 'querystring';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css'],
})
export class OrderComponent implements OnInit {
  productOrderRequest;
  fournisseurId: string;
  productId: number;
  orderStatus: string;
  products: Product[];
  fournisseurs: Fournisseur[];
  fournisseur: Fournisseur;
  product: Product;
  price: number;
  order: Order;
  validationDate = new Date();
  quantity: number;
  statuss: Status;
  constructor(
    private userService: UserService,
    private service: Service1Service
  ) {}
  form: any = {
    product: null,
    Fournisseur: null,
    qtt: null,
    price: null,
    totalprice: null,
  };
  async ngOnInit() {
    this.userService.getlistproduits().subscribe(
      (data) => {
        this.products = data;
      },
      (err) => {
        console.log('error!');
      }
    );
    this.userService.getlistfournisseurs().subscribe(
      (data) => {
        this.fournisseurs = data;
      },
      (err) => {
        console.log('error!');
      }
    );
  }

  getSelectedOptionText(id: string) {
    this.fournisseurId = id;
  }

  async placeOrder() {
    let form = document.getElementsByTagName('form')[0];

    console.log(form.product.value);
    console.log(form.Fournisseur.value);
    console.log(form.qtt.value);
    console.log(form.price.value);
    console.log(form.price.value * form.qtt.value);
    this.userService.getfournisseur(form.Fournisseur.value).subscribe(
      (data) => {
        this.fournisseur = data;
      },
      (err) => {
        console.log('error!');
      }
    );
    this.product = await this.getproduit(form.product.value);
    console.log(this.product + 'hhhhhh');
    this.fournisseur = await this.getfournisseur(form.Fournisseur.value);
    console.log(this.fournisseur + 'hhhhhh');

    console.log(this.getproduit(form.product.value));
    const order1: Order = {
      id: '1',
      date: this.validationDate,
      totale: form.price.value * form.qtt.value,
      produit: this.product,
      status: 'Processing',
      fournisseur: this.fournisseur,
    };
    console.log('produit' + form.product.value);
    this.service.addorder(order1).subscribe(
      (data) => {
        console.log(data);
        //    this.isSuccessful = true;
      },
      (err) => {
        //this.errorMessage = err.error.message;
      }
    );
  }
  selectProduct(productID) {
    this.productId = productID;
    this.price = this.products.find((p) => p.id == productID).prix_unitaire;
  }
  getfournisseur(id: string): Promise<Fournisseur> {
    return this.userService.getfournisseur(id).toPromise();
  }
  getproduit(id: string): Promise<Product> {
    return this.userService.getproduit(id).toPromise();
  }
}
