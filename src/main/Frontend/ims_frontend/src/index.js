import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
//import 'antd/dist/antd.min.css'; // Ensure the correct import path for Ant Design styles

// Ensure you are using BrowserRouter
import { BrowserRouter } from 'react-router-dom';

ReactDOM.render(
    <BrowserRouter>
        <App />
    </BrowserRouter>,
    document.getElementById('root')
);
