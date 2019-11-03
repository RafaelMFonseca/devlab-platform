import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SigninComponent } from './pages/signin/signin.component';
import { LoginRoutingModule } from './login-routing.module';
import { SharedModule } from '../shared/shared.module';

@NgModule({
    declarations: [SigninComponent],
    imports: [
        CommonModule,
        SharedModule,
        LoginRoutingModule
    ]
})
export class LoginModule { }
