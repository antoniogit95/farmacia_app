import { useState } from 'react'
import './App.css'
import { AuthProvider } from './providerContext/AuthProvider';
import { Rutas } from './rutas/Rutas';
import { RouterProvider } from 'react-router-dom';

function App() {
  const [count, setCount] = useState(0)

  return (
    <AuthProvider>
        <RouterProvider router={Rutas} />
      </AuthProvider>
  );
}

export default App
