import React, { useEffect, useState } from 'react';
import { Table, Input, Button, Popconfirm, message } from 'antd';
import { fetchItems, deleteItem } from '../api'; // Ensure to import the correct API functions
import ProductForm from './ProductForm';

const InventoryTable = () => {
    const [items, setItems] = useState([]);
    const [searchText, setSearchText] = useState('');
    const [editingItem, setEditingItem] = useState();

    useEffect(() => {
        const loadItems = async () => {
            try {
                const data = await fetchItems();
                setItems(data);
            } catch (error) {
                message.error(error.message);
            }
        };
        loadItems();
    }, []);

    const handleDelete = async (id) => {
        try {
            await deleteItem(id);
            setItems(items.filter(item => item.id !== id));
            message.success('Item deleted successfully');
        } catch (error) {
            message.error(error.message);
        }
    };

    const handleEdit = (item) => {
        setEditingItem(item);
    };

    const handleSearch = (value) => {
        setSearchText(value);
    };

    const filteredItems = items.filter(item =>
        item.productName.toLowerCase().includes(searchText.toLowerCase())
    );

    const columns = [
        {
            title: 'Product Name',
            dataIndex: 'productName',
            key: 'productName',
            render: (text) => <a>{text}</a>,
        },
        {
            title: 'Quantity',
            dataIndex: 'quantity',
            key: 'quantity',
        },
        {
            title: 'Category',
            dataIndex: 'category',
            key: 'category',
        },
        {
            title: 'Price per Unit',
            dataIndex: 'pricePerUnit',
            key: 'pricePerUnit',
            render: (text) => `$${text.toFixed(2)}`, // Format price
        },
        {
            title: 'Shelf Number',
            dataIndex: 'shelfNumber',
            key: 'shelfNumber',
        },
        {
            title: 'Vendor Link',
            dataIndex: 'vendorLink',
            key: 'vendorLink',
            render: (text) => <a href={text} target="_blank" rel="noopener noreferrer">Link</a>,
        },
        {
            title: 'Actions',
            key: 'actions',
            render: (text, item) => (
                <span>
                    <Button onClick={() => handleEdit(item)}>Edit</Button>
                    <Popconfirm
                        title="Are you sure to delete this product?"
                        onConfirm={() => handleDelete(item.id)}
                        okText="Yes"
                        cancelText="No"
                    >
                        <Button type="danger">Delete</Button>
                    </Popconfirm>
                </span>
            ),
        },
    ];

    return (
        <div>
            <Input.Search
                placeholder="Search items"
                onSearch={handleSearch}
                style={{ marginBottom: 16 }}
            />
            <Table
                columns={columns}
                dataSource={filteredItems}
                rowKey="id"
                pagination={{ pageSize: 10 }}
            />
            <ProductForm editingItem={editingItem} setEditingItem={setEditingItem} />
        </div>
    );
};

export default InventoryTable;