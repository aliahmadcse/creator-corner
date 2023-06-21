import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { User } from '../user.types';

export const ProductsPageActions = createActionGroup({
  source: 'User Page',
  events: {
    getUser: emptyProps(),

    saveUser: props<{ user: User }>(),
  },
});
