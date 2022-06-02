import React from "react";
import { Route } from "react-router-dom";
import EmptyChat from "./EmptyChat";
import UserChat from "./UserChat";
import GroupChat from "./GroupChat";

// Chat History with different Routing
function ChatHistory(props) {
  return (
    <>
      <Route path="/inicio" component={EmptyChat} exact />
      <Route path="/inicio/user1" component={UserChat} exact />
      <Route path="/inicio/group1" component={GroupChat} exact />
    </>
  );
}
export default ChatHistory;
