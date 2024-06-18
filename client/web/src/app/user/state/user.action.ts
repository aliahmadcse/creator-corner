import { createActionGroup, props } from '@ngrx/store';
import { User } from '../user.types';

export const userPageActions = createActionGroup({
  source: 'User Detail API',
  events: {
    getUserByEmail: props<{email: string}>(),
    getUserSuccess: props<{ user: User }>(),
    getUserFailure: props<{ error: any }>(),

    saveUser: props<{ user: User }>(),
  },
});

