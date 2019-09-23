import { Component, OnInit } from '@angular/core';
import { TestConnectionService } from '../test-connection.service';
import { records } from 'src/assets/records.model';
import { ModalService } from '../_modal';

@Component({
  selector: 'app-test-connection',
  templateUrl: './test-connection.component.html',
  styleUrls: ['./test-connection.component.css']
})
export class TestConnectionComponent implements OnInit {


  allRecords:records[];
  constructor( private testconnectService: TestConnectionService,private modalService: ModalService) { }

  ngOnInit() {
    this.retrieveAllrecords();
  }
  retrieveAllrecords(){
    this.testconnectService.getAllrecords().subscribe(
      (data:records[])=>{
        this.allRecords=data;
        console.log(this.allRecords);

      }
    );
  }
  deleteRecords(id:number){
    this.testconnectService.deleterecord(id).subscribe(
      (data:records)=>{
          this.retrieveAllrecords();
      }
    );

  }
   edit(record:records){
   this.testconnectService.selectedRecords=  Object.assign({},record );

   }
   Update(record:records){
     console.log("update clicked");
     this.testconnectService.updateRecords(record).subscribe(
       (data: records)=>{
        this.retrieveAllrecords();
        
       }
     );
     this.ClearRecords();

   }
   ClearRecords(){
    this.testconnectService.selectedRecords={
      id: null,
      name: '',
      Artist:'',
      Gerne: '',
      year: null

   }
  }

   
  
  openModal(id: string) {
    this.modalService.open(id);
  }
  
closeModal(id: string) {
    this.modalService.close(id);
  }

}
