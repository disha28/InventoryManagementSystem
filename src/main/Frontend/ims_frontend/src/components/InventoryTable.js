import React, { useEffect, useState } from 'react';
import { Table, Input, Button, Popconfirm, message } from 'antd';
import { fetchProducts, deleteProduct } from '../api'; // Ensure to import the correct API functions
import ProductForm from './ProductForm';

const InventoryTable = () => {
    const [products, setProducts] = useState([]);
    const [searchText, setSearchText] = useState('');
    const [editingProduct, setEditingProduct] = useState(null);

    useEffect(() => {
        const loadProducts = async () => {
            try {
                const data = await fetchProducts();
                setProducts(data);
            } catch (error) {
                message.error(error.message);
            }
        };
        loadProducts();
    }, []);

    const handleDelete = async (id) => {
        try {
            await deleteProduct(id);
            setProducts(products.filter(product => product.id !== id));
            message.success('Product deleted successfully');
        } catch (error) {
            message.error(error.message);
        }
    };

    const handleEdit = (product) => {
        setEditingProduct(product);
    };

    const handleSearch = (value) => {
        setSearchText(value);
    };

    const filteredProducts = products.filter(product =>
        product.name.toLowerCase().includes(searchText.toLowerCase())
    );

    const columns = [
        // Define your columns here as previously discussed
    ];

    return (
        <div>
            <Input.Search
                placeholder="Search products"
                onSearch={handleSearch}
                style={{ marginBottom: 16 }}
            />
            <Table
                columns={columns}
                dataSource={filteredProducts}
                rowKey="id"
                pagination={{ pageSize: 10 }}
            />
            <ProductForm editingProduct={editingProduct} setEditingProduct={setEditingProduct} />
        </div>
    );
};

export default InventoryTable;
