const API_ENDPOINT_PRODUCTS = 'http://localhost:8080/products';
const API_ENDPOINT_SHELVES = 'http://localhost:8080/shelves';
const API_ENDPOINT_VENDORS = 'http://localhost:8080/vendors';
const API_ENDPOINT_CATEGORIES = 'http://localhost:8080/categories';

// Products API
export const fetchProducts = async () => {
    const response = await fetch(API_ENDPOINT_PRODUCTS);
    if (!response.ok) throw new Error('Failed to fetch products');
    return await response.json();
};

export const addProduct = async (product) => {
    const response = await fetch(API_ENDPOINT_PRODUCTS, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(product),
    });
    if (!response.ok) throw new Error('Failed to add product');
    return await response.json();
};

export const updateProduct = async (product) => {
    const response = await fetch(`${API_ENDPOINT_PRODUCTS}/${product.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(product),
    });
    if (!response.ok) throw new Error('Failed to update product');
    return await response.json();
};

export const deleteProduct = async (id) => {
    const response = await fetch(`${API_ENDPOINT_PRODUCTS}/${id}`, {
        method: 'DELETE',
    });
    if (!response.ok) throw new Error('Failed to delete product');
};

// Shelves API
export const fetchShelves = async () => {
    const response = await fetch(API_ENDPOINT_SHELVES);
    if (!response.ok) throw new Error('Failed to fetch shelves');
    return await response.json();
};

export const addShelf = async (shelf) => {
    const response = await fetch(API_ENDPOINT_SHELVES, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(shelf),
    });
    if (!response.ok) throw new Error('Failed to add shelf');
    return await response.json();
};

export const updateShelf = async (shelf) => {
    const response = await fetch(`${API_ENDPOINT_SHELVES}/${shelf.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(shelf),
    });
    if (!response.ok) throw new Error('Failed to update shelf');
    return await response.json();
};

export const deleteShelf = async (id) => {
    const response = await fetch(`${API_ENDPOINT_SHELVES}/${id}`, {
        method: 'DELETE',
    });
    if (!response.ok) throw new Error('Failed to delete shelf');
};

// Vendors API
export const fetchVendors = async () => {
    const response = await fetch(API_ENDPOINT_VENDORS);
    if (!response.ok) throw new Error('Failed to fetch vendors');
    return await response.json();
};

export const addVendor = async (vendor) => {
    const response = await fetch(API_ENDPOINT_VENDORS, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(vendor),
    });
    if (!response.ok) throw new Error('Failed to add vendor');
    return await response.json();
};

export const updateVendor = async (vendor) => {
    const response = await fetch(`${API_ENDPOINT_VENDORS}/${vendor.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(vendor),
    });
    if (!response.ok) throw new Error('Failed to update vendor');
    return await response.json();
};

export const deleteVendor = async (id) => {
    const response = await fetch(`${API_ENDPOINT_VENDORS}/${id}`, {
        method: 'DELETE',
    });
    if (!response.ok) throw new Error('Failed to delete vendor');
};

// Categories API
export const fetchCategories = async () => {
    const response = await fetch(API_ENDPOINT_CATEGORIES);
    if (!response.ok) throw new Error('Failed to fetch categories');
    return await response.json();
};

export const addCategory = async (category) => {
    const response = await fetch(API_ENDPOINT_CATEGORIES, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(category),
    });
    if (!response.ok) throw new Error('Failed to add category');
    return await response.json();
};

export const updateCategory = async (category) => {
    const response = await fetch(`${API_ENDPOINT_CATEGORIES}/${category.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(category),
    });
    if (!response.ok) throw new Error('Failed to update category');
    return await response.json();
};

export const deleteCategory = async (id) => {
    const response = await fetch(`${API_ENDPOINT_CATEGORIES}/${id}`, {
        method: 'DELETE',
    });
    if (!response.ok) throw new Error('Failed to delete category');
};
