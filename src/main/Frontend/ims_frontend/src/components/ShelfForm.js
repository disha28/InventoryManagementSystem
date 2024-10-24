import React, { useEffect, useState } from 'react';
import { Form, Input, Button, message } from 'antd';
import { useDispatch } from 'react-redux';
import { addShelf, updateShelf } from '../redux/actions';

const ShelfForm = ( ) => {
    const [form] = Form.useForm();
    const dispatch = useDispatch();
    const [ editingShelf, setEditingShelf ] = useState(null);

    useEffect(() => {
        if (editingShelf) {
            form.setFieldsValue(editingShelf);
        } else {
            form.resetFields();
        }
    }, [editingShelf, form]);

    const onFinish = async (values) => {
        if (editingShelf) {
            await dispatch(updateShelf({ ...values, id: editingShelf.id }));
            message.success('Shelf updated successfully');
        } else {
            await dispatch(addShelf(values));
            message.success('Shelf added successfully');
        }
        form.resetFields();
        setEditingShelf(null);
    };

    return (
        <Form form={form} onFinish={onFinish} layout="vertical">
            <Form.Item name="shelfNumber" label="Shelf Number" rules={[{ required: true, message: 'Please input shelf number!' }]}>
                <Input />
            </Form.Item>
            <Form.Item>
                <Button type="primary" htmlType="submit">
                    {editingShelf ? 'Update Shelf' : 'Add Shelf'}
                </Button>
            </Form.Item>
        </Form>
    );
};

export default ShelfForm;
