import React from 'react';
import OfficeCard from './OfficeCard';

function App() {
  const title = <h1 style={{ color: '#333', textAlign: 'center' }}>Office Space Rental App</h1>;

  const offices = [
    {
      name: "Green Tower",
      rent: 75000,
      address: "MG Road, Bengaluru",
      image: process.env.PUBLIC_URL + "/office1.jpg"
    },
    {
      name: "Blue Pearl",
      rent: 55000,
      address: "Banjara Hills, Hyderabad",
      image: process.env.PUBLIC_URL + "/office2.jpg"
    },
    {
      name: "WorkHub",
      rent: 60000,
      address: "Sector 18, Noida",
      image: process.env.PUBLIC_URL + "/office3.jpg"
    }
  ];

  return (
    <div style={{ padding: '20px', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      {title}
      {offices.map((office, index) => (
        <OfficeCard key={index} office={office} />
      ))}
    </div>
  );
}

export default App;
