import { Component, Input, Output, EventEmitter, ElementRef } from 'angular2/core';

@Component({
    selector: 'autocomplete',
    host: {
        '(document:click)': 'handleClick($event)',
    },
    template: `<input id="{{id}}" type="text" autocomplete="off" placeholder="{{placeholder}}" class="form-control" [(ngModel)]="query" (keyup)="filter()">
    <ul class="dropdown-menu" [style.display]="suggestions?.length > 0 ? 'block': 'none'" role="menu" aria-labelledby="dLabel">
        <li *ngFor="#suggestion of suggestions">
            <a name="{{suggestion}}" (click)="select(suggestion)">{{suggestion}}</a>
        </li>
    </ul>`
})
export class AutoComplete {
    @Output() selected = new EventEmitter(true);

    @Input() id: string;
    @Input() placeholder: string = "";
    @Input() items: string[] = [];
    @Input() minLength: number = 3;

    query: string = "";
    suggestions: string[] = [];

    elementRef: ElementRef;

    constructor(element : ElementRef) {
        this.elementRef = element;
    }

    filter() {
        if (this.query.length > this.minLength) {
            var substrRegex = new RegExp(this.query, 'i');
            this.suggestions = this.items.filter(item => {
                return substrRegex.test(item);
            } );
        } else {
            this.suggestions = [];
        }
    }

    select(item) {
        this.query = "";
        this.suggestions = [];

        this.selected.emit(item);
    }

    handleClick(event){
        var clickedComponent = event.target;
        var inside = false;
        do {
            if (clickedComponent === this.elementRef.nativeElement) {
                inside = true;
            }
            clickedComponent = clickedComponent.parentNode;
        } while (clickedComponent);

        if(!inside) {
            this.suggestions = [];
        }
    }
}