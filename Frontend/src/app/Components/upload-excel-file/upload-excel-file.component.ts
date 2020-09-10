import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as myGlobals from '../../global';
import { Router , Routes} from '@angular/router';




@Component({
  selector: 'app-upload-excel-file',
  templateUrl: './upload-excel-file.component.html',
  styleUrls: ['./upload-excel-file.component.css']
})
export class UploadExcelFileComponent implements OnInit {

  selectedFile:File= null;
  chooseFileMessage = "Choose File";
  jsonResponseData: any;
  jsonRespnseMessage: any;
  jsonInsertedDetails: [];

  showMsgBoolean: boolean = false;

  constructor(private http: HttpClient, private router: Router) {
    if(myGlobals.getStatus()==false){
      this.router.navigate(['/']);
    }
   }

  ngOnInit(): void {
  }

  onFileSelected(event) {
    this.jsonInsertedDetails = null;
    this.selectedFile = event.target.files[0];
    this.chooseFileMessage=this.selectedFile.name;
    console.log(event)
  }  

  downloadSample(){
    //window.open('/assets/images/sample_stock_data_check.xlsx', '_blank');
    let link = document.createElement("a");
    link.download = "sample_stock_data_check.xlsx";
    link.href = "assets/sample_stock_data_check.xlsx";
    link.click();
  }

  onUpload(){
    if(this.selectedFile===null)
    {
      alert("No file selected");
    }
    else
    {
      const fd = new FormData();
      fd.append('excel',this.selectedFile, this.selectedFile.name);
      this.http.post("http://localhost:8082/api/excel/upload", fd)
          .subscribe(res=>{
          if (res) {
              console.log(res);
              localStorage.setItem('currentData', JSON.stringify(res));
          }
          if(localStorage.getItem('currentData')) {
            this.jsonResponseData = JSON.parse(localStorage.getItem('currentData'));
            this.jsonRespnseMessage = this.jsonResponseData.message;
            alert(this.jsonRespnseMessage);
            this.jsonInsertedDetails = this.jsonResponseData.stockInsertedDetails;
            this.showMsgBoolean = true;
            this.selectedFile = null;
            this.chooseFileMessage = "Choose File";
          }
        }); 
    }
  }
}