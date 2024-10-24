import React from 'react';
import { Layout, Menu } from 'antd';
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
        <Provider store={store}>
            <Router>
                <Layout>
                    <Header style={{ display: 'flex', alignItems: 'center' }}>
                        <h1 style={{ color: 'white', marginRight: '20px' }}>Inventory Management</h1>
                        <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                            <Menu.Item key="1"><Link to="/">Inventory</Link></Menu.Item>
                            <Menu.Item key="2"><Link to="/products">Products</Link></Menu.Item>
                            <Menu.Item key="3"><Link to="/shelves">Shelves</Link></Menu.Item>
                            <Menu.Item key="4"><Link to="/vendors">Vendors</Link></Menu.Item>
                            <Menu.Item key="5"><Link to="/categories">Categories</Link></Menu.Item>
                        </Menu>
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
            </Router>
        </Provider>
    );
};

export default App;