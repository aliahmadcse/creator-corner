export interface SignUpRequest {
  email: string;
  password: string;
}

export interface JwtResponse {
  email: string;
  token: string;
  role: string;
}

export interface AuthState {
  authResponse: JwtResponse,
  authError: {};
}
