import axios from 'axios';

const API_URL = 'http://backend:9090/api/users';

export const registerUser = async (userData) => {
    const response = await axios.post(`${API_URL}/register`, userData);
    return response.data;
};

export const loginUser = async (credentials) => {
    const response = await axios.post(`${API_URL}/login`, credentials);
    return response.data;
};


export const getToken = () => {
    return localStorage.getItem('token');
};


export const fetchProtectedData = async () => {
    const token = getToken();
    const response = await axios.get(`${API_URL}/protected`, {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    });
    return response.data;
};
