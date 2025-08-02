import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };

    // bind 'this' for non-arrow functions
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleSyntheticEvent = this.handleSyntheticEvent.bind(this);
  }

  increment() {
    this.setState(prevState => ({ count: prevState.count + 1 }));
    this.sayHello();
  }

  sayHello() {
    console.log("Hello from React Event Example!");
  }

  decrement = () => {
    this.setState(prevState => ({ count: prevState.count - 1 }));
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  handleSyntheticEvent(e) {
    alert("I was clicked");
    console.log("Synthetic event: ", e);
  }

  render() {
    return (
      <div style={{ padding: '20px', border: '1px solid gray', borderRadius: '8px', marginBottom: '20px' }}>
        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>{' '}
        <button onClick={() => this.sayWelcome("Welcome!")}>Say Welcome</button>{' '}
        <button onClick={this.handleSyntheticEvent}>Click on me</button>
      </div>
    );
  }
}

export default Counter;
