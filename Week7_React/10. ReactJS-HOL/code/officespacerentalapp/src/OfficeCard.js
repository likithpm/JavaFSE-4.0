import React from 'react';

const OfficeCard = ({ office }) => {
  const rentStyle = {
    color: office.rent > 60000 ? 'green' : 'red',
    fontWeight: 'bold'
  };

  return (
    <div style={{
      border: '1px solid gray',
      borderRadius: '8px',
      padding: '10px',
      marginBottom: '10px',
      width: '300px',
      backgroundColor: '#f9f9f9'
    }}>
      <img
        src={office.image}
        alt={office.name}
        style={{ width: '100%', height: '200px', objectFit: 'cover', borderRadius: '5px' }}
      />
      <h3>{office.name}</h3>
      <p style={rentStyle}>Rent: ₹{office.rent}</p>
      <p>Address: {office.address}</p>
    </div>
  );
};

export default OfficeCard;
