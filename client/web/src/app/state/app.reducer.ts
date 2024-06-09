import { isDevMode } from '@angular/core';
import { ActionReducer, ActionReducerMap, MetaReducer } from '@ngrx/store';
import { productReducer } from '../product/state/product.reducer';
import { userReducer } from '../user/state/user.reducer';
import { AppState } from './app.state';
import { authReducer } from '../auth/state/auth.reducer';

export const reducers: ActionReducerMap<AppState> = {
  products: productReducer,
  user: userReducer,
  auth: authReducer
};

/**
 * This method acts as a interceptor for all the actions dispatched in the application.
 *
 * @param reducer - The reducer function
 * @returns - A reducer function
 */
export function debug(reducer: ActionReducer<AppState>): ActionReducer<AppState> {
  return (state, action) => {
    // console.log('state', state);
    // console.log('action', action);

    return reducer(state, action);
  };
}

export const metaReducers: MetaReducer<AppState>[] = isDevMode() ? [debug] : [];
