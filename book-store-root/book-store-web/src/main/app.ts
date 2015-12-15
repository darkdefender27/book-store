import {bootstrap, Component, CORE_DIRECTIVES, FORM_DIRECTIVES} from 'angular2/angular2';
import {NavBar} from './shared/navbar/navbar';

@Component({
    selector: 'my-app',
    template: '<nav-bar></nav-bar>',
    directives: [CORE_DIRECTIVES, FORM_DIRECTIVES, NavBar]
})
class AppComponent {

}

bootstrap(AppComponent);
