import { createBrowserRouter } from "react-router-dom";
import { Login } from "../views/login/Login";
import { SingAuth } from "../views/register/SingAuth";
import { Home } from "../views/Home/Home";
import { ProtectedRoutes } from "./ProtectedRoutes";
import { Medication } from "../views/Medication/Medication";
import { AddMedication } from "../views/AddMedication/AddMedication";
import { AddStock } from "../views/addStock/AddStock";
import { Personal } from "../views/personal/Personal";
import { Reports } from "../views/reports/Reports";
import { Settings } from "../views/settings/Settings";

export const Rutas = createBrowserRouter([
  
  { path: "/", element: <Login /> },
  { path:'/login', element:<Login /> },
  { path:'/singauth', element:<SingAuth /> },
  { path: "/", element: (<ProtectedRoutes/> ),
    children:[
      { path:'/home', element:<Home/> },
      { path: '/medication', element:<Medication/>},
      { path: '/addmedication', element: <AddMedication/>},
      { path: '/addstock', element: <AddStock/>},
      { path: '/personal', element: <Personal/>},
      { path: '/reports', element: <Reports/>},
      { path: '/settings', element: <Settings/>},
    ]
  },  
]); 