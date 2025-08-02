import React from 'react';
import FlightDetails from './FlightDetails';

const GuestPage = () => {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>You can browse flight details below:</p>
      <FlightDetails canBook={false} />
    </div>
  );
};

export default GuestPage;
