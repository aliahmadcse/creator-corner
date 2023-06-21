import { createReducer } from '@ngrx/store';
import { Product } from '../product.types';

const initialProductState: Product = {
  name: '',
  type: '',
  upvotes: 0,
  comments: [],
};

export const productReducer = createReducer(initialProductState);
