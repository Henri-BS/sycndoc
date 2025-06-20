import axios from "axios";
import { ClientCard } from "components/cards/ClientCard";
import { SearchBar, Pagination } from "components/shared/Pagination";
import { removeAccents } from "components/shared/Template";
import { Breadcrumb } from "flowbite-react";
import { useState, useEffect } from "react";
import { FaHouse, FaFolderClosed } from "react-icons/fa6";
import { Link } from "react-router-dom";
import { ClientPage } from "resources/client";
import { baseUrl } from "utils/requests";

export default function Home() {

    const [query, setQuery] = useState("");
    const [pageNumber, setPageNumber] = useState(0);
    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }
    const [clientPage, setClientPage] = useState<ClientPage>({ content: [], size: 0, number: 0, totalElements: 0, totalPages: 0 });

    useEffect(() => {
        axios.get(`${baseUrl}/clients?page=${pageNumber}&size=10&sort=id`)
            .then((response) => {
                setClientPage(response.data);
            });
    }, [query, pageNumber]);

    return (
        <div className="px-4">
                <SearchBar
                    pageTitle="Clientes"
                    value={query}
                    onChange={(e) => setQuery(e.target.value)}
                />
                <Pagination pagination={clientPage} onPageChange={handlePageChange} />
                <div className="grid grid-cols-1 grid gap-4 items-start mt-5">
                    {clientPage.content?.filter((client) =>
                        client.clientName?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientName)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientAddress?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientAddress)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientDistrict?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientDistrict)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientCity?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientCity)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientUf?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientUf)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientMaritalStatus?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientMaritalStatus)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientCpf?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientCpf)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        client.clientBirthDate?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                        removeAccents(client.clientBirthDate)?.toUpperCase().includes(query.toLocaleUpperCase())
                    ).map(project => (
                        <div key={project.id} className="relative flex justify-center">
                            <ClientCard client={project} />
                        </div>
                    ))}
                </div>
        </div>

    );
}