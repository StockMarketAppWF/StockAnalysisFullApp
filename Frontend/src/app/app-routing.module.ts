import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AddUserComponent } from "./Components/add-user/add-user.component";
import { UserLoginComponent } from "./Components/user-login/user-login.component";
import { DashboardComponent } from "./Components/dashboard/dashboard.component";
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

const routes: Routes = [
  { path: "", redirectTo: "/user-login", pathMatch: "full" },
  { path: "add-user", component: AddUserComponent },
  { path: "user-login", component: UserLoginComponent },
  { path: "success", component: DashboardComponent },
  { path: "success/compare-company", component: CompareCompanyComponent },
  { path: "success/ipo", component: IpoListComponent },
  { path: "success/editipo/:id", component: IpoDetailsComponent },
  { path: "success/addipo", component: AddIpoComponent },
  { path: "success/company", component: CompanyListComponent },
  { path: "success/editcompany/:id", component: CompanyDetailsComponent },
  { path: "success/addcompany", component: AddCompanyComponent },
  { path: "success/viewcompany", component: ViewCompanyComponent },
  { path: "success/viewipo", component: ViewIpoComponent },
  { path: "success/uploadexcel", component: UploadExcelFileComponent },
  { path: "success/exchange", component: ExchangeComponent },
  { path: "success/details/:id", component: ExchangeDetailsComponent },
  { path: "success/addstock", component: AddStockExchangeComponent },
  { path: "success/sector", component: SectorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
