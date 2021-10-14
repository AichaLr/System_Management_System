import { Component, OnInit } from '@angular/core';
import { Service1Service } from 'src/app/services/service1.service';
import { UserService } from 'src/app/services/user.service';
import { Order } from 'src/app/models/order';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { UpdateStatusComponent } from '../update-status/update-status.component';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  orders: Order[];
  dataSource = new MatTableDataSource<Order>();

  enableEdit = false;
  enableEditIndex = null;
  displayedColumns: string[] = [
    'productOrderId',
    'productName',
    'pricePerUnit',
    'orderedOn',
    'distributorName',
    'orderStatus',
  ];
  constructor(
    private service: Service1Service,
    private userservice: UserService,
    private dialogRef: MatDialog,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchAllUsers();
  }
  fetchAllUsers() {
    this.userservice.getlistorders().subscribe(
      (data) => {
        this.orders = data;
        this.dataSource.data = data;
      },
      (err) => {
        console.log('error!');
      }
    );
  }

  enableEditMethod(e, i) {
    this.enableEdit = true;
    this.enableEditIndex = i;
    console.log(i, e);
  }
  edit() {
    console.log('saved');
  }
  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  updateStatus(element) {
    const dialogRef = this.dialogRef.open(UpdateStatusComponent, {
      data: element,
    });
    dialogRef.afterClosed().subscribe((result) => {
      this.fetchAllUsers();
    });
  }
  logout() {
    this.tokenStorageService.signOut();
    this.router.navigate(['/login']);
  }
}
