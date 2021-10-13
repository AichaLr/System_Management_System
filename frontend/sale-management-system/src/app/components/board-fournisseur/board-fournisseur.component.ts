import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Order } from 'src/app/models/order';

@Component({
  selector: 'app-board-fournisseur',
  templateUrl: './board-fournisseur.component.html',
  styleUrls: ['./board-fournisseur.component.css'],
})
export class BoardFournisseurComponent implements OnInit {
  content: any;
  isLoggedIn: boolean;
  roles: string;
  currentuser: any;
  orders: Order[];
  constructor(
    private userService: UserService,
    private tokenStorageService: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    console.log('itss loged in !!!' + this.isLoggedIn);
    this.currentuser = this.tokenStorageService.getUser();

    this.roles = this.tokenStorageService.getUser().roles;

    this.userService.getfournisseurorders(this.currentuser.id).subscribe(
      (data) => {
        this.orders = data;
      },
      (err) => {}
    );
  }
  logout() {
    if (this.isLoggedIn) {
      this.tokenStorageService.signOut();
      window.location.reload();
      //  window.location.reload();
    }
  }
}
