import React from 'react';

const CourseDetails = () => {
  const courses = [
    { name: "Angular", date: "4/6/2025" },
    { name: "React", date: "6/7/2025" }
  ];

  return (
    <div>
      <h2>Course Details</h2>
      {courses.map((course, index) => (
        <div key={index} style={{ marginBottom: '15px' }}>
          <h3 style={{ fontWeight: 'bold' }}>{course.name}</h3>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;
