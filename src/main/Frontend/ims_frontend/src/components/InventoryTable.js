import React, { useEffect, useState } from 'react';
import { Table, Input, Button, Popconfirm, message } from 'antd';
import { fetchItems, deleteItem } from '../api'; // Ensure to import the correct API functions
import ProductForm from './ProductForm';

const InventoryTable = () => {
    const [items, setItems] = useState([]);
    const [searchText, setSearchText] = useState('');
    const [editingItem, setEditingItem] = useState();
    const [sortedInfo, setSortedInfo] = useState({});

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
        // ... (unchanged)
    };

    const handleEdit = (item) => {
        // ... (unchanged)
    };

    const handleSearch = (value) => {
        // ... (unchanged)
    };

    const handleChange = (pagination, filters, sorter) => {
        setSortedInfo(sorter);
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
            sorter: (a, b) => a.productName.localeCompare(b.productName),
            sortOrder: sortedInfo.columnKey === 'productName' && sortedInfo.order,
        },
        {
            title: 'Quantity',
            dataIndex: 'quantity',
            key: 'quantity',
            sorter: (a, b) => a.quantity - b.quantity,
            sortOrder: sortedInfo.columnKey === 'quantity' && sortedInfo.order,
        },
        {
            title: 'Category',
            dataIndex: 'category',
            key: 'category',
            sorter: (a, b) => a.category.localeCompare(b.category),
            sortOrder: sortedInfo.columnKey === 'category' && sortedInfo.order,
        },
        {
            title: 'Price per Unit',
            dataIndex: 'pricePerUnit',
            key: 'pricePerUnit',
            render: (text) => `$${text.toFixed(2)}`,
            sorter: (a, b) => a.pricePerUnit - b.pricePerUnit,
            sortOrder: sortedInfo.columnKey === 'pricePerUnit' && sortedInfo.order,
        },
        {
            title: 'Shelf Number',
            dataIndex: 'shelfNumber',
            key: 'shelfNumber',
            sorter: (a, b) => a.shelfNumber - b.shelfNumber,
            sortOrder: sortedInfo.columnKey === 'shelfNumber' && sortedInfo.order,
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
                                <Button type="danger" style={{ marginLeft: 8 }}>Delete</Button>
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
                onChange={handleChange}
            />
            <ProductForm editingItem={editingItem} setEditingItem={setEditingItem} />
        </div>
    );
};

export default InventoryTable;