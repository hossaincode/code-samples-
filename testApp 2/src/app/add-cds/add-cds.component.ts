import { Component, OnInit } from '@angular/core';
import { TestConnectionService } from '../test-connection.service';
import { records } from 'src/assets/records.model';

@Component({
  selector: 'app-add-cds',
  templateUrl: './add-cds.component.html',
  styleUrls: ['./add-cds.component.css']
})
export class AddCdsComponent implements OnInit {

  constructor( private connceService: TestConnectionService) { }

  ngOnInit() {
  }

  SaveRecords(selectedRecord:records){
    this.connceService.saverecord(selectedRecord).subscribe(
    );
    this.ClearAll();
  }
  ClearAll(){
    this.connceService.selectedRecords={
      id: null,
      name: '',
      Artist:'',
      Gerne: '',
      year: null




    }
  }

}
