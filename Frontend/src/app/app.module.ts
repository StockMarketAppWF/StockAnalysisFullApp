import { BrowserModule } from "@angular/platform-browser";
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { DataTablesModule } from "angular-datatables";
import { MatCardModule } from "@angular/material/card";
import { MatButtonModule } from "@angular/material/button";
import { MatToolbarModule } from "@angular/material/toolbar";
import { ChartsModule } from "ng2-charts";

import { CustomMaterialModule } from './core/material.module';
import { AddUserComponent } from "./Components/add-user/add-user.component";
import { UserLoginComponent } from "./Components/user-login/user-login.component";
import { DashboardComponent } from "./Components/dashboard/dashboard.component";
import { NoopAnimationsModule } from "@angular/platform-browser/animations";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { from } from "rxjs";
import { CompareCompanyComponent } from "./Components/compare-company/compare-company.component";
import { IpoListComponent } from "./Components/ipo-list/ipo-list.component";
import { IpoDetailsComponent } from "./Components/ipo-details/ipo-details.component";
import { AddIpoComponent } from "./Components/add-ipo/add-ipo.component";
import { CompanyListComponent } from "./Components/company-list/company-list.component";
import { CompanyDetailsComponent } from "./Components/company-details/company-details.component";
import { AddCompanyComponent } from "./Components/add-company/add-company.component";
import { ViewCompanyComponent } from "./Components/viewcompany/viewcompany.component";
import { ViewIpoComponent } from "./Components/viewipo/viewipo.component";
import { UploadExcelFileComponent } from "./Components/upload-excel-file/upload-excel-file.component";
import { ExchangeComponent } from "./Components/exchange/exchange.component";
import { ExchangeDetailsComponent } from "./Components/exchange-details/exchange-details.component";
import { AddStockExchangeComponent } from "./Components/add-stock-exchange/add-stock-exchange.component";
import { SectorComponent } from "./Components/sector/sector.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    UserLoginComponent,
    DashboardComponent,
    CompareCompanyComponent,
    AddIpoComponent,
    IpoDetailsComponent,
    IpoListComponent,
    AddCompanyComponent,
    CompanyDetailsComponent,
    CompanyListComponent,
    ViewCompanyComponent,
    ViewIpoComponent,
    UploadExcelFileComponent,
    ExchangeComponent,
    ExchangeDetailsComponent,
    AddStockExchangeComponent,
    SectorComponent
  ],
  imports: [
    CustomMaterialModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule,
    NoopAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    ChartsModule,
    Ng2SearchPipeModule,
    NgbModule,
    CustomMaterialModule
  ],
  exports: [MatButtonModule, MatCardModule],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
