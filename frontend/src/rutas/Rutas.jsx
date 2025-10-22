import { createBrowserRouter } from "react-router-dom";
import { Login } from "../views/login/Login";
import { SingAuth } from "../views/register/SingAuth";




export const Rutas = createBrowserRouter([
  
  { path: "/", element: <Login /> },
  { path:'/login', element:<Login /> },
  { path:'/singauth', element:<SingAuth /> },

  
]); 