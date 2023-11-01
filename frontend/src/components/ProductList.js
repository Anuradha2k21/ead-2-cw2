import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    loadProducts();
  }, []);

  const loadProducts = async () => {
    const result = await axios.get("http://localhost:8888/products");
    setProducts(result.data);
  };

  const deleteProduct=async (productId)=>{
    await axios.delete(`http://localhost:8888/products/${productId}`)
    loadProducts()
  }

  return (
    <div className="container">
      <div className="py-4">
      <h1 class="display-4">Product Table</h1>
        <table className="table table-striped border shadow">
          <thead>
            <tr>
            <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Description</th>
              { <th scope="col">Quantity</th> }
              {<th scope="col">Category</th>}
              {<th scope="col">Price</th>}
            </tr>
          </thead>

          <tbody>
            {products.map((product, index) => (
              <tr>
                <th scope="row"key={index}>{index+1}</th>
                <td>{product.name}</td>
                <td>{product.description}</td>
                <td>{product.quantity}</td>
                <td>{product.category}</td>
                <td>{product.price}</td>
                <td>
                    <Link className="btn btn-outline-primary mx-2" to={`/products/${product.productId}`}>Edit</Link>
                    <button className="btn btn-danger mx-2" onClick={()=>deleteProduct(product.productId)}>Delete</button>
                </td>

              </tr>

            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
