import { Component, OnDestroy, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { AppState } from 'src/app/state/app.state';
import { userPageActions } from '../state/user.action';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.scss'],
})
export class UserDetailComponent implements OnInit, OnDestroy {
  subscription = new Subscription();

  constructor(private store: Store<AppState>) {}

  ngOnInit(): void {
    this.store.dispatch(userPageActions.getUser());

    this.store.select('user').subscribe((data) => {
      // console.log(data);
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
