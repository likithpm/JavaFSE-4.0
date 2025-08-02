import React from 'react';
import Counter from './Counter';
import CurrencyConverter from './CurrencyConverter';

function App() {
  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h1>React Event Examples App</h1>
      <Counter />
      <CurrencyConverter />
    </div>
  );
}

export default App;
