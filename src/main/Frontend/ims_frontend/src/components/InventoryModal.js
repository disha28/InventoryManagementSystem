import React, { useEffect } from 'react';
import { Modal, Form, Input, Button, message } from 'antd';
import { createItem, updateItem } from '../api'; // Import API functions

function InventoryModal({ visible, editingItem, onClose, onRefresh }) {
  const [form] = Form.useForm();

  useEffect(() => {
    if (editingItem) {
      form.setFieldsValue(editingItem);
    } else {
      form.resetFields();
    }
  }, [editingItem, form]);

  const handleSubmit = async () => {
    try {
      const formData = await form.validateFields();
      if (editingItem) {
        await updateItem(editingItem.id, formData);
        message.success('Item updated successfully');
      } else {
        await createItem(formData);
        message.success('Item created successfully');
      }
      onClose();
      onRefresh(); // Reload the items after the operation
    } catch (error) {
      message.error('Failed to save item');
    }
  };

  return (
    <Modal
      title={editingItem ? "Edit Product" : "Add New Product"}
      visible={visible}
      onOk={handleSubmit}
      onCancel={onClose}
    >
      <Form form={form} layout="vertical">
        <Form.Item
          label="Product Name"
          name={['product', 'name']}
          rules={[{ required: true, message: 'Please enter the product name' }]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          label="Quantity"
          name="quantity"
          rules={[{ required: true, message: 'Please enter the quantity' }]}
        >
          <Input type="number" />
        </Form.Item>
        <Form.Item
          label="Category"
          name={['category', 'name']}
          rules={[{ required: true, message: 'Please enter the category' }]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          label="Price per Unit"
          name="pricePerUnit"
          rules={[{ required: true, message: 'Please enter the price per unit' }]}
        >
          <Input type="number" />
        </Form.Item>
        <Form.Item
          label="Shelf Number"
          name={['shelf', 'id']}
          rules={[{ required: true, message: 'Please enter the shelf number' }]}
        >
          <Input type="number" />
        </Form.Item>
        <Form.Item
          label="Vendor Link"
          name={['vendor', 'link']}
          rules={[{ required: true, message: 'Please enter the vendor link' }]}
        >
          <Input />
        </Form.Item>
      </Form>
    </Modal>
  );
}

export default InventoryModal;
