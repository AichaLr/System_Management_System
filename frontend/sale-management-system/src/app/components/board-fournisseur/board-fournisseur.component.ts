import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-board-fournisseur',
  templateUrl: './board-fournisseur.component.html',
  styleUrls: ['./board-fournisseur.component.css'],
})
export class BoardFournisseurComponent implements OnInit {
  content: any;
  isLoggedIn: boolean;

  constructor(
    private userService: UserService,
    private tokenStorageService: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    console.log('itss loged in !!!' + this.isLoggedIn);

    this.userService.getFournisseurBoard().subscribe(
      (data) => {
        this.content = data;
      },
      (err) => {
        this.content = JSON.parse(err.error).message;
      }
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
