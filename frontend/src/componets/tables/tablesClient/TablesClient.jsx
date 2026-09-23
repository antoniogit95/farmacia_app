import React , { useState }from "react";
import { useQuery } from "@tanstack/react-query";
import { FaSpinner } from "react-icons/fa";
import { clientService } from "../../../services/clientServices";
import { EditClientModal } from "../../Modals/client/EditClientModal";
import { FiEdit } from "react-icons/fi";

export const TablesClient = () => {

    const [selectedClient, setSelectedClient] = useState(null);
    const [showEditModal, setShowEditModal] = useState(false);

    const {
        data: clients = [],
        isLoading,
        isError,
        error
    } = useQuery({
        queryKey: ["clients"],
        queryFn: clientService.getAll,
    });

    if (isError) {
        console.error(error);
    }

    return (
        <>
            <div>
                <h2 className="stylesH2Subtitule">
                    Lista de Clientes
                </h2>

                {isLoading && (
                    <div className="loading-spinner">
                        <FaSpinner className="spinner-icon" />
                    </div>
                )}

                <div className="styleContentTable">
                    <table className="styleTable">
                        <thead className="stylesHead">
                            <tr>
                                <th className="stylesTh-Td">
                                    Nit / Ci
                                </th>

                                <th className="stylesTh-Td">
                                    Compañia
                                </th>

                                <th className="stylesTh-Td">
                                    Telefono
                                </th>

                                <th className="stylesTh-Td">
                                    Notificaciones
                                </th>

                                <th className="stylesTh-Td">
                                    Opciones
                                </th>
                            </tr>
                        </thead>

                        <tbody className="styleBody">

                            {clients.map((data) => (
                                <tr
                                    className="stylesTr"
                                    key={data.id}
                                >
                                    <td className="stylesTh-Td">
                                        {data.nit}
                                    </td>

                                    <td className="stylesTh-Td">
                                        {data.companyName}
                                    </td>

                                    <td className="stylesTh-Td">
                                        {data.person.telefono}
                                    </td>

                                    <td className="stylesTh-Td">
                                        {data.notifications
                                            ? "si"
                                            : "no"
                                        }
                                    </td>

                                    <td>
                                        <div className="stylesContentButton">
                                            <button
                                                className="stylesButoon"
                                                onClick={() => {
                                                    setSelectedClient(data);
                                                    setShowEditModal(true);
                                                }}
                                                >
                                                    <FiEdit/>Editar
                                            </button>
                                        </div>
                                    </td>

                                </tr>
                            ))}

                        </tbody>
                    </table>
                </div>
            </div>
            <EditClientModal
                show={showEditModal}
                onHide={() => {
                    setShowEditModal(false);
                    setSelectedClient(null);
                }}
                client={selectedClient}
            />
        </>
    );
};