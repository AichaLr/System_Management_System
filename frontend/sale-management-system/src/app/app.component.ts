import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  isLoggedIn: boolean = false;
  roles: any;
  showResponsableBoard: any;
  showFournisseurBoard: any;
  username: any;
  constructor(private tokenStorageService: TokenStorageService) {}
  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      console.log('iss it logged ?:' + this.isLoggedIn);
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showResponsableBoard = this.roles == 'ROLE_RESPONSABLE';
      this.showFournisseurBoard = this.roles == 'ROLE_FOURNISSEUR';

      this.username = user.username;
    }
  }
  logout() {
    this.tokenStorageService.signOut();
    //  window.location.reload();
  }
  title = 'sale-management-system';
}
