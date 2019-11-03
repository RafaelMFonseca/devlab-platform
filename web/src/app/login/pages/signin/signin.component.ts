import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { DomBodyService } from 'src/app/shared/services/dom-body.service';

/**
 *
 * https://ux.stackexchange.com/questions/1080/using-sign-in-vs-using-log-in
 */
@Component({
    selector: 'app-signin',
    templateUrl: './signin.component.html',
    styleUrls: ['./signin.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class SigninComponent implements OnInit {

    private currentYear: number;

    constructor(private domBodyService: DomBodyService) { }

    ngOnInit() {
        this.currentYear = new Date().getFullYear();

        this.domBodyService.addClassToBody('signin-bg');
    }

}
