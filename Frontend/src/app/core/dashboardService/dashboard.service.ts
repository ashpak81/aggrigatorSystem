import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor( private http:HttpClient) { }

  private baseUrl = "http://localhost:8080";

  Dashboard(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/dashboard`, data).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error:any):Observable<any>{
    console.error('An error occurred:',error);
    return throwError(()=>error);
  }


}
