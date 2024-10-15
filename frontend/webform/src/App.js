import React from 'react'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import RegistrationForm from './components/RegistrationForm'
import LoginForm from './components/LoginForm'
import Dashboard from './components/Dashboard'
import HealthCheck from './components/HealthCheck' // Импортируем HealthCheck

// Создаем роутер с маршрутами
const router = createBrowserRouter([
	{
		path: '/',
		element: <LoginForm />, // Главная страница - форма входа
	},
	{
		path: '/register',
		element: <RegistrationForm />, // Страница регистрации
	},
	{
		path: '/dashboard',
		element: <Dashboard />, // Страница панели управления
	},
	{
		path: '/health', // Новый маршрут для проверки доступности сервера
		element: <HealthCheck />,
	},
])

const App = () => {
	return (
		<RouterProvider router={router} /> // Передаем роутер в RouterProvider
	)
}

export default App
