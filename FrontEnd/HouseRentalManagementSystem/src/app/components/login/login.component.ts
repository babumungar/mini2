import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,FormControlName, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AdminService } from 'src/app/services/admin.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  admins:any;
  registeredAdmin:any;
  submitted=false;
  loggedinAdmin:any;
  loginForm : any;
  constructor(private adminService:AdminService,private router: Router
  ) { }

  ngOnInit(): void {
    this.adminService.getAllAdmins().subscribe((result: any)=>{
      this.admins=result;
      //console.log(result);
    })

    this.loginForm=new FormGroup({
      adminEmail:new FormControl('',[Validators.required,Validators.email]),
      password: new FormControl('')
    })
  
    

  }
  
  get adminEmail(){
    return this.loginForm.get('adminEmail');
  }
  get password(){
    return this.loginForm.get('password');
  }
  
  public onSubmit(){
    this.submitted=true;
    //console.log(this.loginForm.value)
    if(this.loginForm.invalid){
      alert("form fields should not be empty");
    }
    else{
      this.registeredAdmin = this.admins.find((admin: { adminEmail: any; }) => admin.adminEmail  === this.loginForm.value.adminEmail)
    if(this.registeredAdmin!=undefined){
      if(this.registeredAdmin.password===this.loginForm.value.password){
        this.router.navigate(['signup'])
      }
    }
    }

    this.adminService.getAdmin(this.loginForm.value.adminEmail,this.loginForm.value.password).subscribe((data: any)=>{
      this.loggedinAdmin=data;
      console.log(data)
      console.log(this.loggedinAdmin)
      localStorage.setItem('LoggedinAdmin',JSON.stringify(this.loggedinAdmin))
    let ddd=localStorage.getItem('LoggedinAdmin');
  
     })  
    
    

  }

}
  // public onSubmit(){
  //   //console.warn(this.loginForm.value);
    
  //   this.adminService.getAdmin(this.adminEmail?.value,this.password?.value).subscribe(
  //     (result) => {
  //       this.router.navigate(['hospital']);
  //       console.log("success");
  //     },
  //     (error) => {
  //       //this.snack.open("Wrong credentials","ok",{duration:2000})
  //       console.warn(error.error);
  //       console.log("failure");
  //       alert("Wrong credentials try again");
  //     },

  //   )

  //   }

