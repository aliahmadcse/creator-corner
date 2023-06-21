import { createReducer } from '@ngrx/store';

const initialProductState = {
  name: '',
  type: '',
  upvotes: 0,
  comments: [],
};

export const productReducer = createReducer(initialProductState);
