# E-Commerce Frontend (React + Vite)

A modern, responsive e-commerce web application built using **React 18**, **Vite**, **Bootstrap 5**, and **Axios**.

## Features
- **Live Product Browsing & Category Filtering**: Filter products dynamically across Laptop, Headphone, Mobile, Electronics, Toys, and Fashion categories.
- **Search Auto-Complete**: Real-time product search with immediate query feedback.
- **Product Management**:
  - Add new products with file upload (`multipart/form-data`).
  - Update existing products with image preview and replacement.
  - Delete products with real-time UI refresh.
- **Cart Management**: Add to cart, adjust quantities, calculate totals, and checkout simulation stored in `localStorage`.
- **Dark Mode**: Built-in toggle for dark/light themes.

## Prerequisites
- [Node.js](https://nodejs.org/) (version 18 or higher)
- Backend running on `http://localhost:8080`

## Installation & Startup
```bash
# Install dependencies
npm install

# Start development server
npm run dev
```
The frontend will launch at `http://localhost:5173`.

## Architecture & Communication
The application communicates with the Spring Boot backend via Axios configured in `src/axios.jsx`:
- Base URL: `http://localhost:8080/api`
- Content-Types: `application/json` and `multipart/form-data`
