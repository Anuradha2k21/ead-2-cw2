import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8888/users");
    setUsers(result.data);
  };

  const deleteUser=async (userId)=>{
    await axios.delete(`http://localhost:8888/users/${userId}`)
    loadUsers()
  }

  return (
    <div className="container">
      <div className="py-4">
      <h1 class="display-4">User Table</h1>
        <table className="table table-striped border shadow">
          <thead>
            <tr>
            <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">User ID</th>
              <th scope="col">Role</th>
              <th scope="col">E-mail</th>
              <th scope="col">Address</th>
              <th scope="col">Contact Number</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (

              <tr>
                <th scope="row"key={index}>{index+1}</th>
                <td>{user.userId}</td>
                <td>{user.name}</td>
                <td>{user.role}</td>
                <td>{user.email}</td>
                <td>{user.address}</td>
                <td>{user.telephoneNumber}</td>
                <td>
                    
                    <Link className="btn btn-outline-primary mx-2" to={`/users/${user.userId}`}>Edit</Link>
                    <button className="btn btn-danger mx-2" onClick={()=>deleteUser(user.userId)}>Delete</button>
                </td>

              </tr>

            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
