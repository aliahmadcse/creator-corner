import { AuthState, JwtResponse } from '../auth/auth.types';
import { Product } from '../product/product.types';
import { User } from '../user/user.types';

export interface AppState {
  user: User;
  products: Product;
  auth: AuthState;
}
