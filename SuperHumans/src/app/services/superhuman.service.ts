import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})
export class SuperhumanService {
  allSuperHumans: string = 'http://localhost:8080/SuperHumans/super-human';
  singleSuperHuman: string = 'http://localhost:8080/SuperHumans/super-human/';
  constructor(private http: HttpClient) { }

  getSuperHumans(): Observable<SuperHuman[]> {
    return this.http.get<SuperHuman[]>(this.allSuperHumans);
  }

}
