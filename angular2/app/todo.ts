import { Component, bootstrap, NgFor, provide } from 'angular2/angular2';
import { AngularFire, FirebaseArray } from '../firebase/AngularFire';

@Component({
    selector: 'todo-app',
    providers: [
        AngularFire,
        provide(Firebase, { useValue: new Firebase('https://webapi.firebaseio-demo.com/test') })
    ],
    directives: [NgFor],
    templateUrl: 'todo.html'
})