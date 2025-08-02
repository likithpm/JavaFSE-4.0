import React, { useState } from 'react';

const CurrencyConverter = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState('');

  const handleSubmit = () => {
    const rate = 0.011; // Example conversion rate
    const converted = parseFloat(rupees) * rate;

    if (!isNaN(converted)) {
      const euroValue = converted.toFixed(2);
      setEuros(euroValue);
      alert(`Converted Amount: €${euroValue}`);
    } else {
      alert('Please enter a valid number');
    }
  };

  return (
    <div style={{ padding: '20px', border: '1px solid gray', borderRadius: '8px' }}>
      <h2>Currency Converter</h2>
      <label>Rupees: </label>
      <input
        type="number"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
        placeholder="Enter INR"
      />
      {' '}
      <button onClick={handleSubmit}>Convert</button>
      <p>Euros: €{euros}</p>
    </div>
  );
};

export default CurrencyConverter;
