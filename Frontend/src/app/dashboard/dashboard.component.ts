import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { LoginComponent } from '../login/login.component'
import { DashboardService } from '../core/dashboardService/dashboard.service';
import { User, Institute } from '../types/IUser';


@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [FormsModule, RouterOutlet, CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent {

  searchTerm: string = '';
  records: Array<any> = [];
  filteredRecords: Array<{ id: number; name: string; status: string; date: string }> = [];
  paginatedRecords: any[] = []; 
  recordCount: number = 0;
  currentPage: number = 1;
  itemsPerPage: number = 10;
  userid: string = '';

  // http = inject(HttpClient);

  constructor(private dashboarddata: DashboardService,htttp:HttpClient) {
    this.filteredRecords = this.records;
    this.getConsentDetails();
  }


  instituteName: string | null = localStorage.getItem("instituteName");

  institute: Institute = {
    instituteName: this.instituteName ? this.instituteName : "Unknown Institute"
  };

  getConsentDetails() {

    console.log('Fetching consent details for institute:', this.institute);

    this.dashboarddata.Dashboard(this.institute).subscribe({
      next: (res: any) => {
        console.log('Response:', res); 
        this.paginatedRecords = res;
        this.recordCount = this.paginatedRecords.length;
      },
      error: (err: any) => {
        console.error('Error fetching data:', err);
      }
    });
  }



  applySearch() {
    if (this.searchTerm) {
      this.filteredRecords = this.records.filter(record =>
        record.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    } else {
      this.filteredRecords = this.records;
    }
    this.recordCount = this.filteredRecords.length;
    this.currentPage = 1;
    this.updatePaginatedRecords();
  }
  

  get totalPages(): number {
    return Math.ceil(this.filteredRecords.length / this.itemsPerPage);
  }

  updatePaginatedRecords() {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    this.paginatedRecords = this.filteredRecords.slice(start, end);
  }

  changePage(page: number) {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
      this.updatePaginatedRecords();
    }
  }

}
