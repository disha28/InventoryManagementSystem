import React, { useEffect } from 'react';
import { Form, Input, Button, message } from 'antd';
import { useDispatch } from 'react-redux';
import { addVendor, updateVendor } from '../redux/actions';

const VendorForm = ({ editingVendor, setEditingVendor }) => {
    const [form] = Form.useForm();
    const dispatch = useDispatch();

    useEffect(() => {
        if (editingVendor) {
            form.setFieldsValue(editingVendor);
        } else {
            form.resetFields();
        }
    }, [editingVendor, form]);

    const onFinish = async (values) => {
        if (editingVendor) {
            await dispatch(updateVendor({ ...values, id: editingVendor.id }));
            message.success('Vendor updated successfully');
        } else {
            await dispatch(addVendor(values));
            message.success('Vendor added successfully');
        }
        form.resetFields();
        setEditingVendor(null);
    };

    return (
        <Form form={form} onFinish={onFinish} layout="vertical">
            <Form.Item name="name" label="Vendor Name" rules={[{ required: true, message: 'Please input vendor name!' }]}>
                <Input />
            </Form.Item>
            <Form.Item name="link" label="Vendor Link" rules={[{ required: true, message: 'Please input vendor link!' }]}>
                <Input />
            </Form.Item>
            <Form.Item>
                <Button type="primary" htmlType="submit">
                    {editingVendor ? 'Update Vendor' : 'Add Vendor'}
                </Button>
            </Form.Item>
        </Form>
    );
};

export default VendorForm;
