import React from "react"
import { NavBar } from "../../componets/NavBar/NavBar"
import "./Reports.css"
import { TablesReportVentas } from "../../componets/tables/tablesReportVentas/TablesReportVentas"

export const Reports = () => {
    return (<>
        <NavBar/>
        <div className="stylesContentReports">
            <div className="styleContentReport-two">
                <div className="styleWindowsColumn">
                    <TablesReportVentas/>
                </div>
                <div className="styleWindowsColumn">
                    graficos
                </div>
            </div>
        </div>
    </>)
} 