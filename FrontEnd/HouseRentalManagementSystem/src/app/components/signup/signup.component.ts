import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,FormControlName, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';
import { Admin } from 'src/app/model/admin';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  // adminForm!:adminForm;
  toast: any;
  admins!: Admin;
  newAdmin:any;
  //admin:Admin=new Admin("","",0,"");
  
  constructor(private snack:MatSnackBar,private router:Router, private adminservice: AdminService) { }


  ngOnInit(): void {
   
  }

  adminForm=new FormGroup({
    adminName:new FormControl('',[Validators.required]),
    adminEmail:new FormControl('',[Validators.required, Validators.minLength(1),Validators.email]),
    // adminMobileNo:new FormControl('',[Validators.required]),
    password:new FormControl('',[Validators.required]),
    // employeeId:new FormControl('',[Validators.required]),
   // hospitalCode:new FormControl('',[Validators.required])

  })

  get adminName(){
    return this.adminForm.get('adminName');
  }

  get adminEmail(){
    return this.adminForm.get('adminEmail');
  }

 
  get password(){
    return this.adminForm.get('password')
  }
  // get employeeId(){
  //   return this.adminForm.get('employeeId')
  // }
 


  onSubmit(){
    if(this.adminForm.invalid){
        return;
    }
  console.log(this.adminForm.value)

      //this.newAdmin = this.admins.find((admin: { adminEmail: any}) => admin.adminEmail === this.adminForm.value.adminEmail)
    //if(this.newAdmin==undefined){
      //  this.adminservice.addAdmin(this.adminForm.value).subscribe(response=>{
      //   console.log(this.adminForm.value)
      //   this.toast.success({detail:"Success",summary:"Admin SignedUp successfully",duration:5000})
      //    this.router.navigate(['login'])
      //   this.adminForm.reset();
      //  },(error: any)=>{
      //   alert("Already one admin exists for the given hospitalCode")
      //  })
      this.adminservice.addAdmin(this.adminForm.value).subscribe(
        response=>{
        console.log(response)
        // this.toast.success({detail:"Success",summary:"Admin SignedUp successfully",duration:5000})
         this.router.navigate(['login'])
        this.adminForm.reset();
       },error=>{
        console.log(error)
       })

    }
    //else{
    // alert("Admin already exists with Given mail id")
     //this.toast.error({detail:"Failure",summary:"Admin Already exists with the given Emailid",duration:5000})
     //this.router.navigate(['login'])
    //}

 // }

}






  // public onSubmit(){
  //   if(this.adminForm.valid){
  //     this.adminservice.addAdmin(this.adminForm.value).subscribe(

  //       (data)=>{
  //         console.log(data)
  //         //console.log(this.adminForm.value)
  //         Swal.fire("Signed up","","success")
  //         this.router.navigate(["login"]);
  //       },(error)=>{
  //         console.log(error);
  //         Swal.fire("check all fields unable to signup","","error")
          
  //       }

  //     )
  //   }
  //   else{
  //     alert("Some fields are empty please check once");
  //   }
   
  // }

