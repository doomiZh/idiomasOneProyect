import React, { Component } from "react";
import Routing from "./Routing/Routing";

class App extends Component {
  state = {
    themeColor: 1,
  };

  render() {
    return <Routing />;
  }
}

export default App;
