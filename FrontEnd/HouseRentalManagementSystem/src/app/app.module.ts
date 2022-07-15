import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import{HttpClientModule}from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';

import {MatCardModule} from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule, MAT_DIALOG_DEFAULT_OPTIONS} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { LoginComponent } from './components/login/login.component';
import { MainPageComponent } from './main-page/main-page.component';





@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SignupComponent,
    LoginComponent,
    MainPageComponent
    
    ],
    
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,FormsModule,HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatDialogModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatAutocompleteModule,
    ReactiveFormsModule ,
    FormsModule
    
  ],
  providers: [
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: false}},
    
  ],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
