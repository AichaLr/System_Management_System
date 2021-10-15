import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListeFournisseursComponent } from './components/liste-fournisseurs/liste-fournisseurs.component';
import { LoginComponent } from './components/login/login.component';
import { BoardFournisseurComponent } from './components/board-fournisseur/board-fournisseur.component';
import { HomeComponent } from './components/home/home.component';
import { OrderComponent } from './components/order/order.component';
import { OrderListComponent } from './components/order-list/order-list.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { AddProductComponent } from './components/add-product/add-product.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'fournisseur', component: BoardFournisseurComponent },
  { path: 'fournisseurs', component: ListeFournisseursComponent },
  { path: 'addproduct', component: AddProductComponent },

  { path: 'produits', component: ProductListComponent },
  { path: 'order', component: OrderComponent },
  { path: 'orderlist', component: OrderListComponent },

  { path: '', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
