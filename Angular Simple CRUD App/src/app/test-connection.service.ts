import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { records } from 'src/assets/records.model';

@Injectable({
  providedIn: 'root'
})


export class TestConnectionService {
  
  selectedRecords:records= {
      id: null,
      name: '',
      Artist:'',
      Gerne: '',
      year: null
  }

  testconnc=' http://localhost:4300/Records';
  constructor( private http:HttpClient) { }


  getAllrecords():Observable<records[]>{
   return this.http.get<records[]>(this.testconnc);

  }
  saverecord( record:records):Observable<records>{
    return this.http.post<records>(this.testconnc,record);

  }
   deleterecord(id:number):Observable<records>{
     return this.http.delete<records>(this.testconnc+'/' + id );

   }
   updateRecords(record1:records):Observable<records>{
     return this.http.put<records>(this.testconnc+'/'+record1.id,record1);

   }

}
