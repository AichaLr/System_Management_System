import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListeFournisseursComponent } from './components/liste-fournisseurs/liste-fournisseurs.component';

const routes: Routes = [
  {
    path: 'list',
    component: ListeFournisseursComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
