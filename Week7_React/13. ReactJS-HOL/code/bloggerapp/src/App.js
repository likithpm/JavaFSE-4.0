import React from 'react';
import CourseDetails from './CourseDetails';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';

function App() {
  return (
    <div style={{ padding: '40px' }}>
      <h1 style={{ textAlign: 'center' }}>React App</h1>

      <div
        style={{
          display: 'flex',
          alignItems: 'stretch',
          justifyContent: 'space-between',
          marginTop: '40px',
          height: '100%'
        }}
      >
        {/* Column 1: Course Details */}
        <div style={{ flex: 1, padding: '0 20px' }}>
          <CourseDetails />
        </div>

        {/* Green Vertical Line 1 */}
        <div style={{
          width: '4px',
          backgroundColor: 'green',
          margin: '0 10px'
        }} />

        {/* Column 2: Book Details */}
        <div style={{ flex: 1, padding: '0 20px' }}>
          <BookDetails />
        </div>

        {/* Green Vertical Line 2 */}
        <div style={{
          width: '4px',
          backgroundColor: 'green',
          margin: '0 10px'
        }} />

        {/* Column 3: Blog Details */}
        <div style={{ flex: 1, padding: '0 20px' }}>
          <BlogDetails />
        </div>
      </div>
    </div>
  );
}

export default App;
