import React, { useEffect } from 'react';
import { Form, Input, Button, message } from 'antd';
import { useDispatch } from 'react-redux';
import { addCategory, updateCategory } from '../redux/actions';

const CategoryForm = ({ editingCategory, setEditingCategory }) => {
    const [form] = Form.useForm();
    const dispatch = useDispatch();

    useEffect(() => {
        if (editingCategory) {
            form.setFieldsValue(editingCategory);
        } else {
            form.resetFields();
        }
    }, [editingCategory, form]);

    const onFinish = async (values) => {
        if (editingCategory) {
            await dispatch(updateCategory({ ...values, id: editingCategory.id }));
            message.success('Category updated successfully');
        } else {
            await dispatch(addCategory(values));
            message.success('Category added successfully');
        }
        form.resetFields();
        setEditingCategory(null);
    };

    return (
        <Form form={form} onFinish={onFinish} layout="vertical">
            <Form.Item name="name" label="Category Name" rules={[{ required: true, message: 'Please input category name!' }]}>
                <Input />
            </Form.Item>
            <Form.Item>
                <Button type="primary" htmlType="submit">
                    {editingCategory ? 'Update Category' : 'Add Category'}
                </Button>
            </Form.Item>
        </Form>
    );
};

export default CategoryForm;
