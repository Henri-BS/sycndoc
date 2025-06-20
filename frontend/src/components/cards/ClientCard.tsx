import moment from "moment";
import * as FaIcons from "react-icons/fa6";
import { Link } from "react-router-dom";
import { ClientProps } from "resources/client";
import * as GoIcons from "react-icons/go";

export const ClientCard = ({ client }: ClientProps) => {
    return (
        <Link to={`/clientes/${client.id}`} className="flex flex-row w-full items-center bg-white border border-gray-300 p-2 rounded-lg transition duration-500 hover:shadow-md hover hover:shadow-yellow-300">
            <div className="flex flex-col justify-between pl-2 text-gray-700">
                <div title={`${client.clientName} `} className="flex text-lg md:text-xl items-center gap-x-2 h-12 max-w-[400px]  font-semibold overflow-hidden">
                    <FaIcons.FaUser /> {client.clientName}

                </div>
                <div className="flex flex-col md:flex-row justify-start md:justify-between w-full text-lg font-medium text-gray-700 gap-x-10">
                    <p title={`CPF: ${client.clientCpf}`} className="flex gap-x-1 items-center text-center">
                        <FaIcons.FaIdCard /> {client.clientCpf}
                    </p>
                    <p title={`Data de nascimento: ${moment(client.clientBirthDate).format("DD/MM/yyyy")}`} className="flex gap-x-1 items-center text-center">
                        <FaIcons.FaCalendar /> {client.clientBirthDate ? moment(client.clientBirthDate).format("DD/MM/yyyy") : ""}
                    </p>
                    <p title="Endereço" className="flex gap-x-1 items-center text-center">
                        <FaIcons.FaLocationPin /> {client.clientAddress}, {client.clientResidentialNumber}, {client.clientDistrict}
                    </p>
                    <p title="Cidade - UF" className="flex gap-x-1 items-center text-center">
                        <FaIcons.FaCity /> {client.clientCity} - {client.clientUf}
                    </p>
                </div>
            </div>
        </Link>
    );
}