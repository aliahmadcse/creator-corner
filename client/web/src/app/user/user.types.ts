export interface Role {
  id: number;
  name: string;
  createdOn: string;
}

export interface User {
  id: number;
  email: string;
  firstName: string;
  lastName: string;
  headline: string;
  bio: string;
  createdOn: string;
  role: Role;
}

export interface UserState {
  user: User;
}
