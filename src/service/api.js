import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080/api';

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export const apiService = {
  // Products
  getAllProducts: async () => {
    const response = await apiClient.get('/products');
    return response.data;
  },

  // Extras
  getAllExtras: async () => {
    const response = await apiClient.get('/extras');
    return response.data;
  },

  // Orders
  createOrder: async (orderData) => {
    const response = await apiClient.post('/orders', orderData);
    return response.data;
  },

  getOrderById: async (orderId) => {
    const response = await apiClient.get(`/orders/${orderId}`);
    return response.data;
  },

  getAllOrders: async () => {
    const response = await apiClient.get('/orders');
    return response.data;
  }
};

export default apiService;