import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Service1Service } from 'src/app/services/service1.service';
import { Order } from 'src/app/models/order';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css'],
})
export class UpdateStatusComponent implements OnInit {
  statuses = ['Delivered', 'Cancelled'];
  statusForm: FormGroup;
  order: Order;
  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data,
    private dialogRef: MatDialogRef<UpdateStatusComponent>,
    private service: Service1Service
  ) {
    console.log(data);
    this.initForm();
  }
  initForm() {
    this.statusForm = new FormGroup({
      newStatus: new FormControl('', Validators.required),
    });
  }
  ngOnInit(): void {}
  submitForm() {
    this.updateProductData();
  }

  updateProductData() {
    /*  let data = {
      orderId: this.data.id,
      status: this.statusForm.value.newStatus,
    };*/

    // console.log('iddd' + data.orderId);
    //console.log('status' + data.status,);

    this.service
      .updatestatus(this.data.id, this.statusForm.value.newStatus)
      .subscribe(
        (data) => {
          console.log(data);
          this.order = data;

          // this.dialogRef.close();
        },
        (err) => {
          console.log('error!');
        }
      );
  }
}
