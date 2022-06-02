import React, { Component } from "react";
import { BrowserRouter, Route } from "react-router-dom";

import SignIn from "../components/SignIn/SignIn";
import SignUp from "../components/SignUp/SignUp";
import ResetPassword from "../components/ResetPassword/ResetPassword";
import Chats from "../components/Chats/Chats";
import Friends from "../components/Friends/Friends";
import Account from "../components/Account/Account";

// Route component to manage app routes
class Routing extends Component {
  render() {
    return (
      <BrowserRouter>
        <Route path="/" component={SignIn} exact />
        <Route path="/registro" component={SignUp} exact />
        <Route path="/resetear-contrasena" component={ResetPassword} exact />
        <Route path="/inicio" component={Chats} />
        <Route path="/contactos" component={Friends} />
        <Route path="/perfil" component={Account} />
      </BrowserRouter>
    );
  }
}

export default Routing;
