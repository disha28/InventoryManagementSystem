import React from 'react';
import { Layout } from 'antd';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import ProductsPage from './pages/ProductsPage';
import ShelvesPage from './pages/ShelvesPage';
import VendorsPage from './pages/VendorsPage';
import CategoriesPage from './pages/CategoriesPage';
import InventoryPage from './pages/InventoryPage';
import { Provider } from 'react-redux';
import store from './redux/store';

const { Header, Content } = Layout;


const App = () => {
    return (
        <Layout>
            <Header>
                <h1 style={{ color: 'white' }}>Inventory Management</h1>
                <nav>
                    <Link to="/products" style={{ margin: '0 10px', color: 'white' }}>Products</Link>
                    <Link to="/shelves" style={{ margin: '0 10px', color: 'white' }}>Shelves</Link>
                    <Link to="/vendors" style={{ margin: '0 10px', color: 'white' }}>Vendors</Link>
                    <Link to="/categories" style={{ margin: '0 10px', color: 'white' }}>Categories</Link>
                </nav>
            </Header>
            <Content style={{ padding: '20px' }}>
                <Routes>
                    <Route path="/products" element={<ProductsPage />} />
                    <Route path="/shelves" element={<ShelvesPage />} />
                    <Route path="/vendors" element={<VendorsPage />} />

                    <Route path="/categories" element={<CategoriesPage />} />
                    <Route path="/" element={<InventoryPage />} />
                </Routes>
            </Content>
        </Layout>
    );
};

export default App;
