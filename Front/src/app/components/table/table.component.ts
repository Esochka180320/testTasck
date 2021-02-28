
import {HttpClient} from '@angular/common/http';
import {Month} from '../../entity/month';
import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})




export class TableComponent implements OnInit {

  task: Month[];

  constructor(private http: HttpClient) {
  }





  isEdit1: boolean = false;
  isEdit2: boolean = false;
  isEdit3: boolean = false;
  isEdit4: boolean = false;

  ngOnInit(): void {

  }



  add() {
    this.isEdit1 = true;
    console.log('add');
  }

  update() {
    this.isEdit2 = true;
    console.log('update');
  }

  delete() {
    this.isEdit3 = true;
    console.log('delete');
  }
  op(){
    this.isEdit4 = true;
    console.log('op');
  }


  find(option) {

    if (option) {
      this.http.get<Month[]>('http://localhost:8080/findMonth/' + option
      ).subscribe(result => {
        this.task = result;
        console.log(result);
      });
    } else {
      this.http.get<Month[]>('http://localhost:8080/findAllMonth'
      ).subscribe(result => {
        this.task = result;
        console.log(result);
      });
    }

    return false;
  }

  // tslint:disable-next-line:variable-name
  addMonth(name, number, option) {
    if (name && number) {
      this.http.put<Month[]>('http://localhost:8080/addMonth', {
          'name': name,
          'number': number
        }
      ).subscribe(result => {
        this.task = result;
        console.log(result);
        this.find(option);
      });
    } else {
      console.log('eror');
    }

    return false;
  }

  // tslint:disable-next-line:variable-name
  updateMonth(number1, name, number2,option) {
    if (number1 && name && number2) {
      this.http.post<Month[]>('http://localhost:8080/updateMonth', {
          'newName': name+"",
          'number': number1,
          'newNumber': number2
        }
      ).subscribe(result => {
        this.task = result;
        console.log(result);
        this.find(option);
      });
    } else {
      console.log('eror');
    }
    return false;
  }

  deleteMonth(number, option) {

    this.http.delete('http://localhost:8080/deleteMonth/' + number
    ).subscribe(result => {
      console.log(result);
      this.find(option);
    });



    return false;
  }

  cancel() {
    this.isEdit1 = false;
    this.isEdit2 = false;
    this.isEdit3 = false;
    this.isEdit4 = false;
  }



}
