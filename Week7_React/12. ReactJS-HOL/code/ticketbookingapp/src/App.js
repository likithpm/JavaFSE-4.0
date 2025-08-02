import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginLogout = () => {
    setIsLoggedIn(!isLoggedIn);
  };

  const buttonLabel = isLoggedIn ? 'Logout' : 'Login';

  return (
    <div style={{ padding: '20px', textAlign: 'center' }}>
      <h1>Ticket Booking App</h1>
      <button onClick={handleLoginLogout}>{buttonLabel}</button>
      <hr />
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
