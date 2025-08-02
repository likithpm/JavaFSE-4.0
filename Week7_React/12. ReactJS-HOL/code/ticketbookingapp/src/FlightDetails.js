import React from 'react';

const FlightDetails = ({ canBook }) => {
  const flights = [
    { flightNo: 'AI202', from: 'Delhi', to: 'Mumbai', price: 5500 },
    { flightNo: '6E303', from: 'Bangalore', to: 'Kolkata', price: 4800 },
    { flightNo: 'SG505', from: 'Chennai', to: 'Hyderabad', price: 4300 },
  ];

  return (
    <div>
      <h3>Available Flights</h3>
      <ul>
        {flights.map((flight, index) => (
          <li key={index}>
            {flight.flightNo} - {flight.from} to {flight.to} - ₹{flight.price}
            {canBook && (
              <button style={{ marginLeft: '10px' }}>Book</button>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FlightDetails;
