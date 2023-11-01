import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddUser from "./users/AddUser";
import EditUser from "./users/EditUser";
import ViewUser from "./users/ViewUser";
import EditProduct from "./products/EditProduct";
import AddProduct from "./products/AddProduct";
import UserList from "./components/UserList";
import ProductList from "./components/ProductList";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <Routes>
          <Route path="/" element={<><UserList /> <ProductList /></>}  />

          <Route exact path="/users" element={<AddUser />} />
          <Route exact path="/users/:userId" element={<EditUser />} />
          {/* <Route exact path="/users/:userId" element={<ViewUser />} /> */}

          <Route exact path="/products" element={<AddProduct />} />
          <Route exact path="/products/:productId" element={<EditProduct />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
