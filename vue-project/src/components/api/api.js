import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080', // mine бэкенд adress
});

export default api;