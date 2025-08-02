import React from 'react';

const BlogDetails = () => {
  const blogs = [
    {
      title: "React Learning",
      author: "Stephen Biz",
      content: "Welcome to learning React!"
    },
    {
      title: "Installation",
      author: "Schewzdenier",
      content: "You can install React from npm."
    }
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog, index) => (
        <div key={index} style={{ marginBottom: '20px' }}>
          <h3 style={{ fontWeight: 'bold' }}>{blog.title}</h3>
          <p><strong>{blog.author}</strong></p>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;
