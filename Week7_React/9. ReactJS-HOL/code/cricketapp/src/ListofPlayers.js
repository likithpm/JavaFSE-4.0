import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat Kohli", score: 85 },
    { name: "Rohit Sharma", score: 45 },
    { name: "KL Rahul", score: 75 },
    { name: "Shikhar Dhawan", score: 60 },
    { name: "Ravindra Jadeja", score: 95 },
    { name: "MS Dhoni", score: 70 },
    { name: "Rishabh Pant", score: 30 },
    { name: "Hardik Pandya", score: 90 },
    { name: "Jasprit Bumrah", score: 65 },
    { name: "Shreyas Iyer", score: 50 },
    { name: "Yuzvendra Chahal", score: 35 }
  ];

  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with score below 70:</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
