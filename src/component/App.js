import React from "react";
import OrderBookingForm, {UserData} from "./getUserData/orderBookingForm";
import calculate from "../logic/calculate";
import "./App.css";

export default class App extends React.Component {
  state = {
    total: null,
    next: null,
    operation: null,
  };

  handleClick = buttonName => {
    this.setState(calculate(this.state, buttonName));
  };

  render() {
    return (
      <div className="component-app">
        <OrderBookingForm/>
      </div>
    );
  }
}
