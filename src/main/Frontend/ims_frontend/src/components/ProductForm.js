import React, { useEffect } from 'react';
import { Form, Input, Button, message } from 'antd';
import { addProduct, updateProduct } from '../api'; // Import updateProduct from api

const ProductForm = ({ editingProduct, setEditingProduct }) => {
    const [form] = Form.useForm();

    useEffect(() => {
        if (editingProduct) {
            form.setFieldsValue(editingProduct);
        } else {
            form.resetFields();
        }
    }, [editingProduct, form]);

    const onFinish = async (values) => {
        try {
            if (editingProduct) {
                await updateProduct({ ...values, id: editingProduct.id }); // Make sure to call updateProduct API function
                message.success('Product updated successfully');
            } else {
                await addProduct(values);
                message.success('Product added successfully');
            }
            form.resetFields();
            setEditingProduct(null);
        } catch (error) {
            message.error(error.message);
        }
    };

    return (
        <Form form={form} onFinish={onFinish} layout="vertical">
            <Form.Item name="name" label="Product Name" rules={[{ required: true, message: 'Please input product name!' }]}>
                <Input />
            </Form.Item>
            <Form.Item name="quantity" label="Quantity" rules={[{ required: true, message: 'Please input quantity!' }]}>
                <Input type="number" />
            </Form.Item>
            <Form.Item name="category" label="Category" rules={[{ required: true, message: 'Please input category!' }]}>
                <Input />
            </Form.Item>
            <Form.Item name="price" label="Price per Unit" rules={[{ required: true, message: 'Please input price!' }]}>
                <Input type="number" />
            </Form.Item>
            <Form.Item name="shelfNumber" label="Shelf Number" rules={[{ required: true, message: 'Please input shelf number!' }]}>
                <Input type="number" />
            </Form.Item>
            <Form.Item name="vendorLink" label="Vendor Link" rules={[{ required: true, message: 'Please input vendor link!' }]}>
                <Input />
            </Form.Item>
            <Form.Item>
                <Button type="primary" htmlType="submit">
                    {editingProduct ? 'Update Product' : 'Add Product'}
                </Button>
            </Form.Item>
        </Form>
    );
};

export default ProductForm;
