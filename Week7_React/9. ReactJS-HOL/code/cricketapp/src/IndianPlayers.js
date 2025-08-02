import React from 'react';

const IndianPlayers = () => {
  const T20players = ["Kohli", "Rohit", "Rahul", "Pandya", "Bumrah"];
  const RanjiTrophyPlayers = ["Pujara", "Iyer", "Jadeja", "Ashwin", "Saha"];

  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  const oddTeam = [];
  const evenTeam = [];

  mergedPlayers.forEach((player, index) => {
    if (index % 2 === 0) {
      evenTeam.push(player);
    } else {
      oddTeam.push(player);
    }
  });

  return (
    <div>
      <h2>Merged Players:</h2>
      <p>{mergedPlayers.join(', ')}</p>

      <h2>Even Team:</h2>
      <ul>
        {evenTeam.map((player, index) => <li key={index}>{player}</li>)}
      </ul>

      <h2>Odd Team:</h2>
      <ul>
        {oddTeam.map((player, index) => <li key={index}>{player}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
