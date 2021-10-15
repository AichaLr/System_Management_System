import { Product } from './product';
import { Fournisseur } from './fournisseur';
export enum Status {
  'preparation',
  'prete',
  'acheminement',
  'livree',
}

export class Order {
  id: string;
  date: Date;
  totale: number;
  produit: Product;
  status: string;
  fournisseur: Fournisseur;
}
