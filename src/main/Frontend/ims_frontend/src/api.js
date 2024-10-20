const API_BASE_URL = 'http://localhost:8080'; // Your Spring Boot backend

// Fetch all items
export const fetchItems = async () => {
  const response = await fetch(`${API_BASE_URL}/items`);
  if (!response.ok) {
    throw new Error('Failed to fetch items');
  }
  return response.json();
};

// Fetch a single item by ID
export const fetchItemById = async (id) => {
  const response = await fetch(`${API_BASE_URL}/items/${id}`);
  if (!response.ok) {
    throw new Error('Failed to fetch item');
  }
  return response.json();
};

// Create a new item
export const createItem = async (itemData) => {
  const response = await fetch(`${API_BASE_URL}/items`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(itemData),
  });
  if (!response.ok) {
    throw new Error('Failed to create item');
  }
  return response.json();
};

// Update an item by ID
export const updateItem = async (id, itemData) => {
  const response = await fetch(`${API_BASE_URL}/items/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(itemData),
  });
  if (!response.ok) {
    throw new Error('Failed to update item');
  }
  return response.json();
};

// Delete an item by ID
export const deleteItem = async (id) => {
  const response = await fetch(`${API_BASE_URL}/items/${id}`, {
    method: 'DELETE',
  });
  if (!response.ok) {
    throw new Error('Failed to delete item');
  }
  return response.json();
};

export default {
  fetchItems,
  fetchItemById,
  createItem,
  updateItem,
  deleteItem,
};
