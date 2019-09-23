import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestConnectionComponent } from './test-connection/test-connection.component';
import { TestConnectionService } from './test-connection.service';
import { HttpClientModule } from '@angular/common/http';
import { AboutComponent } from './about/about.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { AddCdsComponent } from './add-cds/add-cds.component';
import { ModalModule } from './_modal';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    TestConnectionComponent,
    AboutComponent,
    PrivacyComponent,
    AddCdsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule,
    FormsModule
  ],
  providers: [TestConnectionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
