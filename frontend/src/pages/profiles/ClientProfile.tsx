import { CustomMarkdown } from "components/shared/Custom";
import { User } from "resources/user";
import { Props } from "resources";
import { baseUrl } from "utils/requests";


import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Client } from "resources/client";
import moment from "moment";
import { PoaPage } from "resources/document";
import { ClientCard } from "components/cards/ClientCard";
import { SearchBar } from "components/shared/Pagination";
import { removeAccents } from "components/shared/Template";
import { PoaCard } from "components/cards/PoaCard";

export function ClientProfile() {
    const params = useParams();

    return (
        <ClientDetails params={`${params.clientId}`} />
    );

    function ClientDetails({ params: clientId }: Props) {

        const [client, setClient] = useState<Client>();


        useEffect(() => {
            axios.get(`${baseUrl}/clients/${clientId}`)
                .then((response) => {
                    setClient(response.data);
                });
        }, [clientId]);



        const [query, setQuery] = useState("");
        const [poaPage, setPoaPage] = useState<PoaPage>({ content: [], size: 0, number: 0, totalElements: 0, totalPages: 0 });

        useEffect(() => {
            axios.get(`${baseUrl}/poas?clientId=${clientId}&size=10&sort=id`)
                .then((response) => {
                    setPoaPage(response.data);
                });
        }, [query]);


        return (
            <div>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 text-xl m-4 p-4 border-2 border-gray-300/70 rounded-lg">
                    <div className="col-span-1 md:col-span-3"><b>Nome:</b> {client?.clientName}</div>
                    <div><b>Data de Nascimento:</b> {moment(client?.clientBirthDate).format("DD/MM/yyyy")}</div>
                    <div><b>CPF:</b> {client?.clientCpf}</div>
                    <div><b>Rg:</b> {client?.clientRgNumber}</div>
                    <div><b>Data de emissão do rg:</b> {moment(client?.clientRgIssueDate).format("DD/MM/yyyy")}</div>
                    <div><b>Profissão:</b> {client?.clientProfession}</div>
                    <div><b>Estado Civil:</b> {client?.clientMaritalStatus}</div>
                    <div><b>Endereço:</b> {client?.clientAddress}</div>
                    <div><b>Número residencial:</b> {client?.clientResidentialNumber}</div>
                    <div><b>Bairro:</b> {client?.clientDistrict} </div>
                    <div><b>Cidade/UF:</b> {client?.clientCity}/{client?.clientUf} </div>
                    <div><b>Nacionalidade:</b> {client?.clientNationality} </div>
                    <div><b>CEP:</b> {client?.clientCep} </div>
                </div>


                <div className="px-4">
                    <SearchBar
                        pageTitle="Documentos"
                        value={query}
                        onChange={(e) => setQuery(e.target.value)}
                    />
                    <div className="grid grid-cols-1 grid gap-4 items-start mt-5">
                        {poaPage.content?.map(poa => (
                            <div key={poa.id} className="relative flex justify-center">
                                <PoaCard poa={poa} />
                            </div>
                        ))}
                    </div>
                </div>
            </div>

        );
    }
}
