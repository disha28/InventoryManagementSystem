import * as api from '../api';

// Action Types
export const FETCH_PRODUCTS = 'FETCH_PRODUCTS';
export const ADD_PRODUCT = 'ADD_PRODUCT';
export const UPDATE_PRODUCT = 'UPDATE_PRODUCT';
export const DELETE_PRODUCT = 'DELETE_PRODUCT';
export const FETCH_SHELVES = 'FETCH_SHELVES';
export const ADD_SHELF = 'ADD_SHELF';
export const UPDATE_SHELF = 'UPDATE_SHELF';
export const DELETE_SHELF = 'DELETE_SHELF';
export const FETCH_VENDORS = 'FETCH_VENDORS';
export const ADD_VENDOR = 'ADD_VENDOR';
export const UPDATE_VENDOR = 'UPDATE_VENDOR';
export const DELETE_VENDOR = 'DELETE_VENDOR';
export const FETCH_CATEGORIES = 'FETCH_CATEGORIES';
export const ADD_CATEGORY = 'ADD_CATEGORY';
export const UPDATE_CATEGORY = 'UPDATE_CATEGORY';
export const DELETE_CATEGORY = 'DELETE_CATEGORY';

// Products Actions
export const fetchProducts = () => async (dispatch) => {
    try {
        const data = await api.fetchProducts();
        dispatch({ type: FETCH_PRODUCTS, payload: data });
    } catch (error) {
        console.error('Error fetching products:', error);
    }
};

export const addProduct = (product) => async (dispatch) => {
    try {
        const data = await api.addProduct(product);
        dispatch({ type: ADD_PRODUCT, payload: data });
    } catch (error) {
        console.error('Error adding product:', error);
    }
};

export const updateProduct = (product) => async (dispatch) => {
    try {
        const data = await api.updateProduct(product);
        dispatch({ type: UPDATE_PRODUCT, payload: data });
    } catch (error) {
        console.error('Error updating product:', error);
    }
};

export const deleteProduct = (id) => async (dispatch) => {
    try {
        await api.deleteProduct(id);
        dispatch({ type: DELETE_PRODUCT, payload: id });
    } catch (error) {
        console.error('Error deleting product:', error);
    }
};

// Shelves Actions
export const fetchShelves = () => async (dispatch) => {
    try {
        const data = await api.fetchShelves();
        dispatch({ type: FETCH_SHELVES, payload: data });
    } catch (error) {
        console.error('Error fetching shelves:', error);
    }
};

export const addShelf = (shelf) => async (dispatch) => {
    try {
        const data = await api.addShelf(shelf);
        dispatch({ type: ADD_SHELF, payload: data });
    } catch (error) {
        console.error('Error adding shelf:', error);
    }
};

export const updateShelf = (shelf) => async (dispatch) => {
    try {
        const data = await api.updateShelf(shelf);
        dispatch({ type: UPDATE_SHELF, payload: data });
    } catch (error) {
        console.error('Error updating shelf:', error);
    }
};

export const deleteShelf = (id) => async (dispatch) => {
    try {
        await api.deleteShelf(id);
        dispatch({ type: DELETE_SHELF, payload: id });
    } catch (error) {
        console.error('Error deleting shelf:', error);
    }
};

// Vendors Actions
export const fetchVendors = () => async (dispatch) => {
    try {
        const data = await api.fetchVendors();
        dispatch({ type: FETCH_VENDORS, payload: data });
    } catch (error) {
        console.error('Error fetching vendors:', error);
    }
};

export const addVendor = (vendor) => async (dispatch) => {
    try {
        const data = await api.addVendor(vendor);
        dispatch({ type: ADD_VENDOR, payload: data });
    } catch (error) {
        console.error('Error adding vendor:', error);
    }
};

export const updateVendor = (vendor) => async (dispatch) => {
    try {
        const data = await api.updateVendor(vendor);
        dispatch({ type: UPDATE_VENDOR, payload: data });
    } catch (error) {
        console.error('Error updating vendor:', error);
    }
};

export const deleteVendor = (id) => async (dispatch) => {
    try {
        await api.deleteVendor(id);
        dispatch({ type: DELETE_VENDOR, payload: id });
    } catch (error) {
        console.error('Error deleting vendor:', error);
    }
};

// Categories Actions
export const fetchCategories = () => async (dispatch) => {
    try {
        const data = await api.fetchCategories();
        dispatch({ type: FETCH_CATEGORIES, payload: data });
    } catch (error) {
        console.error('Error fetching categories:', error);
    }
};

export const addCategory = (category) => async (dispatch) => {
    try {
        const data = await api.addCategory(category);
        dispatch({ type: ADD_CATEGORY, payload: data });
    } catch (error) {
        console.error('Error adding category:', error);
    }
};

export const updateCategory = (category) => async (dispatch) => {
    try {
        const data = await api.updateCategory(category);
        dispatch({ type: UPDATE_CATEGORY, payload: data });
    } catch (error) {
        console.error('Error updating category:', error);
    }
};

export const deleteCategory = (id) => async (dispatch) => {
    try {
        await api.deleteCategory(id);
        dispatch({ type: DELETE_CATEGORY, payload: id });
    } catch (error) {
        console.error('Error deleting category:', error);
    }
};
