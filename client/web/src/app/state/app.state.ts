import { AuthState, JwtResponse } from '../auth/auth.types';
import { Product } from '../product/product.types';
import { User, UserState } from '../user/user.types';

export interface AppState {
  user: UserState;
  products: Product;
  auth: AuthState;
}
