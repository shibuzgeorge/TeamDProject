// middleware for doing role-based permissions
module.exports = function permit(...permittedRoles) {
  // return a middleware
  let user = '';
  return (request, response, next) => {
    const axios = require('axios').default

    if (typeof localStorage === "undefined" || localStorage === null) {
      var LocalStorage = require('node-localstorage').LocalStorage;
      localStorage = new LocalStorage('./scratch');
    }
    if (localStorage.getItem("auth") === null) {
      return response.redirect("login")
    }
    axios({
      method: 'post',
      url: 'http://localhost:8080/api/login',
      headers: {
        'Authorization' : localStorage.getItem("auth")
      },
      responseType: 'json'
    }).then((res) => {
      user = res.data;
      if (user.role && permittedRoles.includes(user.role)) {
        request.user = user;
        next(); // role is allowed, so continue on the next middleware
      } else {
        response.render("error", {error: "You do not have the permission to view this page!", user: user});
      }
    }, (error) => {
      response.render("error", {error: "You do not have the permission to view this page!"});
    })
  }
}