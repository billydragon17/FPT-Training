import { Component, OnInit } from '@angular/core';
import { StudentService } from '../services/student.service';
import { Student } from '../student/student';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[] = [];

  constructor(private studentService: StudentService) { }

  ngOnInit(){
    this.studentService.findAll().subscribe(data =>{
      this.students = data
    });
  }

  

}
