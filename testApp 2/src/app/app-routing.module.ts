import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestConnectionComponent } from './test-connection/test-connection.component';
import { AboutComponent } from './about/about.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { AddCdsComponent } from './add-cds/add-cds.component';


const routes: Routes = [
  
  {
    path:'Home',
    component: TestConnectionComponent

  },
  {
    path:'about',
    component: AboutComponent

  },
  {
    path:'privacy',
    component: PrivacyComponent
  },
  {
    path:'AddCD',
    component:AddCdsComponent

  },
  {  path: '', 
     redirectTo: '/home',
     pathMatch: 'full' 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
