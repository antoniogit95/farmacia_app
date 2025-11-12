import { createBrowserRouter } from "react-router-dom";
import { Login } from "../views/login/Login";
import { SingAuth } from "../views/register/SingAuth";
import { Home } from "../views/Home/Home";
import { ProtectedRoutes } from "./ProtectedRoutes";
import { Medication } from "../views/Medication/Medication";
import { AddMedication } from "../views/AddMedication/AddMedication";

export const Rutas = createBrowserRouter([
  
  { path: "/", element: <Login /> },
  { path:'/login', element:<Login /> },
  { path:'/singauth', element:<SingAuth /> },
  { path: "/", element: (<ProtectedRoutes/> ),
    children:[
      { path:'/home', element:<Home/> },
      { path: '/medication', element:<Medication/>},
      { path: '/addmedication', element: <AddMedication/>}
    ]
  },  
]); 