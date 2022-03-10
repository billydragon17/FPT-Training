import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from '../student/student';
import { Observable } from 'rxjs';

@Injectable()
export class StudentService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:7000/api/backend/items';
  }

  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.url);
  }

  public save(student: Student) {
    return this.http.post<Student>(this.url, student);
  }
}