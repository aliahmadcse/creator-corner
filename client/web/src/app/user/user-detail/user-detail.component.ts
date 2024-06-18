import { Component, OnDestroy, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { AppState } from 'src/app/state/app.state';
import { userPageActions } from '../state/user.action';
import { getAuthenticatedUserEmail, getToken } from 'src/app/shared/shared';
import { selectUserResponse } from '../state/user.selector';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.scss'],
})
export class UserDetailComponent implements OnInit, OnDestroy {
  subscription = new Subscription();

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    const email = getAuthenticatedUserEmail();
    if (email) {
      this.store.dispatch(userPageActions.getUserByEmail({ email }));
    }

    this.store.pipe(select(selectUserResponse)).subscribe((data) => {
      console.log(data);
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
