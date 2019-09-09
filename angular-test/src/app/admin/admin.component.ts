import { Component, OnInit } from '@angular/core';
import {CourseServiceClient} from "../service/course.service.client";
import {Course} from "../models/course.model.client";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  constructor(private service: CourseServiceClient){
    this.loadCourses();
  }
}
