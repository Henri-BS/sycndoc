import moment from "moment";
import * as FaIcons from "react-icons/fa6";
import { Link } from "react-router-dom";
import { PoaProps } from "resources/document";
import { Accordion, Button, Modal } from "flowbite-react";
import { CustomMarkdown } from "components/shared/Custom";
import { useState } from "react";


export const PoaCard = ({ poa }: PoaProps) => {

    const [contentModal, setContentModal] = useState(false);

    return (
        <>
            <div className="my-6 w-full flex flex-col md:flex-row justify-between items-center  bg-white border border-gray-300 p-2 rounded-lg transition duration-500">
                <div title={`${poa.title} `} className=" flex text-lg md:text-xl items-center gap-x-2 h-12 font-semibold overflow-hidden">
                     {poa.title}
                </div>
                <div>
                    <FaIcons.FaFileLines title="Conteúdo da Procuração"
                        className="transition duration-500 cursor-pointer border border-[transparent] hover:border-yellow-400 hover:shadow-md hover hover:shadow-yellow-300 rounded-md p-1 text-3xl"
                        onClick={() => setContentModal(true)}
                    />
                </div>
            </div>

            <Modal show={contentModal} size="4xl" onClose={() => setContentModal(false)}>
                <Modal.Header>{poa.title}</Modal.Header>
                <Modal.Body>
                    <CustomMarkdown item={poa.content} />
                </Modal.Body>
                <Modal.Footer className="justify-end">
                    <Button gradientDuoTone="purpleToBlue" onClick={() => setContentModal(false)}>
                        Ok
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}