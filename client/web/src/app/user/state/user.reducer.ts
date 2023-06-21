import { createReducer } from '@ngrx/store';
import { User } from '../user.types';



const initialUserState: User = {
  email: '',
  name: '',
};

export const userReducer = createReducer(initialUserState);
