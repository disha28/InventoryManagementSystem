import React, { useState, useEffect } from 'react';
import { Table, Button, Space, message } from 'antd';
import { fetchItems, deleteItem } from '../api'; // Import the API functions

function InventoryTable() {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(false);

  // Fetch items when the component mounts
  useEffect(() => {
    loadItems();
  }, []);

  const loadItems = async () => {
    setLoading(true);
    try {
      const data = await fetchItems();
      setItems(data);
    } catch (error) {
      message.error('Failed to fetch items');
    } finally {
      setLoading(false);
    }
  };

  // Delete an item
  const handleDelete = async (id) => {
    try {
      await deleteItem(id);
      message.success('Item deleted successfully');
      loadItems(); // Reload the items after deletion
    } catch (error) {
      message.error('Failed to delete item');
    }
  };

  const columns = [
    {
      title: 'Product Name',
      dataIndex: ['product', 'name'],
      key: 'name',
    },
    {
      title: 'Quantity',
      dataIndex: 'quantity',
      key: 'quantity',
    },
    {
      title: 'Category',
      dataIndex: ['category', 'name'],
      key: 'category',
    },
    {
      title: 'Price per Unit',
      dataIndex: 'pricePerUnit',
      key: 'pricePerUnit',
      render: (price) => `$${price.toFixed(2)}`,
    },
    {
      title: 'Actions',
      key: 'actions',
      render: (_, record) => (
        <Space size="middle">
          <Button onClick={() => handleDelete(record.id)} danger>Delete</Button>
        </Space>
      ),
    },
  ];

  return (
    <Table
      columns={columns}
      dataSource={items}
      rowKey="id"
      loading={loading}
    />
  );
}

export default InventoryTable;
