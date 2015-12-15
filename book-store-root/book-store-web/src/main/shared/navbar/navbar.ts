import {bootstrap, Component, CORE_DIRECTIVES, FORM_DIRECTIVES} from 'angular2/angular2';

@Component({
    selector: 'nav-bar',
    templateUrl: './webapp/template/navbar.html',
    directives: [CORE_DIRECTIVES, FORM_DIRECTIVES]
})
export class NavBar {}
