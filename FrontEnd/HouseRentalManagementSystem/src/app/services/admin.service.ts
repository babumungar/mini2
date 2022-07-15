import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../model/admin';


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }
  
  private baseUrl = 'http://localhost:9090/admin';

   addAdmin(admin:Admin):Observable<Admin>{
    return this.http.post<Admin>(`${this.baseUrl}/create`,admin);
  }
   
  getAdmin(mail:string,password:string):Observable<any>{
    return this.http.get<any>(`${this.baseUrl}+/readbyid/${mail}/${password}`);
  }
  getAllAdmins(){
    return this.http.get(`${this.baseUrl}/readalladmins`);
  }



}
