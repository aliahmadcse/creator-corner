import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { User } from '../user.types';

export const userPageActions = createActionGroup({
  source: 'User Detail API',
  events: {
    getUser: emptyProps(),
    getUserSuccess: props<{ user: User }>(),
    getUserFailure: props<{ error: any }>(),

    saveUser: props<{ user: User }>(),
  },
});

