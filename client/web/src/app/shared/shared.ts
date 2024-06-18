export const getToken = () => {
  let auth = localStorage.getItem('auth');
  let parsedAuth, token = undefined;
  if (auth) {
    parsedAuth = JSON.parse(auth);
    token = parsedAuth.token;
  }
  return token;
}


