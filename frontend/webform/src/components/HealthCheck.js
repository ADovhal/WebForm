// components/HealthCheck.js
import React, { useEffect, useState } from 'react'

const HealthCheck = () => {
	const [status, setStatus] = useState('Checking...')
	const [error, setError] = useState(null)

	useEffect(() => {
		const checkHealth = async () => {
			try {
				const response = await fetch('http://backend:9090/api/users') // Замените на ваш URL
				if (response.ok) {
					setStatus('Server is up and running!')
				} else {
					setStatus(`Server is down! Status: ${response.status}`)
				}
			} catch (err) {
				setStatus('Server is down!')
				setError(err.message)
			}
		}

		checkHealth()
	}, [])

	return (
		<div>
			<h2>Health Check</h2>
			<p>Status: {status}</p>
			{error && <p>Error: {error}</p>}
		</div>
	)
}

export default HealthCheck
