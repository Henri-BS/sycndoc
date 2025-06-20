import { useState } from "react"
import * as FaIcons from "react-icons/fa6";
import { Button, Modal, Footer as FooterFR, Navbar, Flowbite, List, ListItem, Dropdown } from "flowbite-react";
import { useAuth } from "resources/auth";
import { Link } from "react-router-dom";
import { CustomMarkdown, customTheme } from "./Custom";

export const removeAccents = (str: any) => {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}

export const Header = () => {

    const auth = useAuth();
    const userSession = auth.getUserSession();
    const userId = userSession?.id;

    function logout() {
        auth.invalidateSession();
    }

    return (
        <>
            <Flowbite theme={{ theme: customTheme }}>
                <Navbar fluid rounded className="shadow bg-gradient-to-r from-zinc-900 to-zinc-800 text-white rounded-none">
                    <Link to={"/"}>
                        <Navbar.Brand>
                            <img src={require("assets/img/logo.png")} className="mr-3 h-12 sm:h-12" alt="Logo" />
                        </Navbar.Brand>
                    </Link>
                    <div className="flex flex-row gap-2 items-center text-gray-300 md:order-2">
                        <Link to="/" >
                            <Button color="yellow" >
                                <FaIcons.FaRightToBracket className="mr-2 my-1" /> Login
                            </Button>
                        </Link>
                        <Navbar.Toggle />
                    </div>

                    <Navbar.Collapse>
                        <Navbar.Link href="/" className="flex flex-row gap-x-1 items-center">
                            <FaIcons.FaUsers /> Clientes
                        </Navbar.Link>
                        <Navbar.Link href="/clientes/adcionar" className="flex flex-row gap-x-1 items-center">
                            <FaIcons.FaPlus /> Novo Cliente
                        </Navbar.Link>
                        {userSession ?
                            <Navbar.Link>
                                <Dropdown renderTrigger={() =>
                                    <div className="flex flex-row items-center gap-x-2 "><FaIcons.FaUser /> Perfil</div>}
                                    className="bg-zinc-900 cursor-pointer w-80  transition duration-300"
                                    trigger="hover"
                                >
                                    <Link to={`/usuarios/${userId}`}>
                                        <Dropdown.Item icon={FaIcons.FaUserPen} className="hover:bg-gray-800/50 focus:text-yellow-400">
                                            Meu Perfil
                                        </Dropdown.Item>
                                    </Link>
                                    <Link to="/login" onClick={logout} >
                                        <Dropdown.Item icon={FaIcons.FaRightFromBracket} className="hover:bg-gray-800/50 focus:text-yellow-400">
                                            Sair
                                        </Dropdown.Item>
                                    </Link>
                                </Dropdown>
                            </Navbar.Link>
                            : ""
                        }
                    </Navbar.Collapse>
                </Navbar>
                <div className="h-2 w-full bg-gradient-to-r from-yellow-400 to-yellow-500 order-3" />
            </Flowbite>
        </>
    );
}

export const Footer = () => {

    const [aboutModal, setAboutModal] = useState(false);
    const [tutorialModal, setTutorialModal] = useState(false);

    return (
        <>
            <FooterFR className="mt-2 shadow bg-gradient-to-r from-zinc-900 to-zinc-800 rounded-none flex-col">
                <div className="h-2 w-full bg-gradient-to-r from-yellow-400 to-yellow-500" />
                <div className="w-full max-w-screen-xl mx-auto p-4 md:py-8">
                    <div className="sm:flex sm:items-center sm:justify-between">

                        <Link to="/" className="flex items-center sm:justify-between text-gray-200 text-xl">
                            <img src={require("assets/img/logo.png")} className="h-12 w-16" alt="logo" />
                            CMA Docs
                        </Link>

                        <div className="flex flex-wrap items-center mb-6 text-sm font-medium text-gray-100 sm:mb-0 space-x-6">
                            <span onClick={() => setAboutModal(true)} className="cursor-pointer hover:underline" title="Sobre o CMA Docs">Sobre o CMA Docs</span>
                            <span onClick={() => setTutorialModal(true)} className="cursor-pointer hover:underline" title="Tutorial do site" >Tutorial do site</span>
                        </div>
                    </div>
                    <hr className="my-6 border-gray-500 sm:mx-auto lg:my-8" />
                    <div className="sm:flex sm:items-center sm:justify-between">
                        <FooterFR.Copyright href="/" by="CMA Docs" year={2025} className="text-white" />
                        <div className="flex mt-4 lg:justify-center lg:mt-0 text-2x1 space-x-6">
                            <FooterFR.Icon href="mailto:hbsantos@gmail.com" icon={FaIcons.FaEnvelope} title="Email" className="hover:text-gray-100" />
                        </div>
                    </div>
                </div>
            </FooterFR>
            <Modal show={aboutModal} size="4xl" onClose={() => setAboutModal(false)}>
                <Modal.Header>Sobre o CMA Docs</Modal.Header>
                <Modal.Body>
                    <div className="space-y-6 p-6">
                        <p className="text-base leading-relaxed text-gray-500 dark:text-gray-400">
                            O CMA Docs é uma plataforma projetada para automatizar a criação de documentos jurídicos,
                            agilizando processos e reduzindo o tempo gasto na elaboração de contratos, procurações, termos, declarações e outros documentos legais.
                            A ferramenta funciona a partir de dados cadastrados pelos clientes,
                            garantindo a personalização e precisão das informações inseridas nos documentos.

                        </p>
                    </div>
                </Modal.Body>
                <Modal.Footer className="justify-end">
                    <Button gradientDuoTone="purpleToBlue" onClick={() => setAboutModal(false)}>
                        Ok
                    </Button>
                </Modal.Footer>
            </Modal>

            <Modal show={tutorialModal} size="4xl" onClose={() => setTutorialModal(false)}>
                <Modal.Header>Tutorial do site</Modal.Header>
                <Modal.Body>
                    <div className="space-y-6 p-6">
                        <p className="text-base leading-relaxed text-gray-500 dark:text-gray-400">
                            <p>Este tutorial fornece um guia passo a passo para utilizar o CMA Docs, uma plataforma inovadora para a geração automática de documentos jurídicos. Aqui estão os principais passos para navegar e operar o sistema:</p>
                            <List ordered>
                                <ListItem><b>Cadastro de um Novo Cliente: </b>
                                    Um usuário administrador pode registrar um novo cliente na plataforma. Esse cliente será a base para a criação de documentos jurídicos personalizados.
                                </ListItem>
                                <ListItem> <b>Adição de Dados Personalizados: </b>
                                    Durante o cadastro, é possível adicionar informações detalhadas sobre o cliente, incluindo:
                                </ListItem>
                                <List nested>
                                    <ListItem>Dados pessoais do outorgante/cliente (nome, nacionalidade, profissão, estado civil, CPF, RG, endereço).</ListItem>
                                    <ListItem>Informações sobre o ourtorgado/advogado responsável(nome, OAB, endereço e email).</ListItem>
                                    <ListItem>Detalhes do a rogo (pessoa que assina pelo cliente, caso aplicável).</ListItem>
                                    <ListItem>Identificação de testemunhas envolvidas.</ListItem>
                                </List>
                                <ListItem><b>Visualização e Busca de Clientes: </b>
                                    Após o cadastro, todos os clientes podem ser visualizados na lista paginada. Para facilitar a busca, a plataforma permite pesquisar clientes pelo nome ou outros critérios.
                                </ListItem>
                                <ListItem> <b>Acesso ao Perfil do Cliente e Documentos Relacionados</b>
                                    Ao acessar o perfil de um cliente cadastrado, é possível visualizar uma lista completa dos tipos de documentos relacionados a ele. Esses documentos foram gerados automaticamente no momento do cadastro.
                                </ListItem>
                                <ListItem><b>Visualização Detalhada de Documentos</b>
                                    Caso o usuário deseje examinar um documento específico, basta selecioná-lo na lista. Isso permite conferir os detalhes e formato do documento antes de utilizá-lo.
                                </ListItem>
                                <ListItem><b>Edição de Dados do Cliente</b>
                                    Um usuário administrador pode atualizar as informações de um cliente quando necessário. Essa modificação afeta todos os documentos previamente gerados, garantindo que os dados estejam sempre atualizados.
                                </ListItem>
                                <ListItem><b>Exclusão de um Cliente e Seus Documentos</b>
                                    Caso seja necessário remover um cliente, um usuário administrador pode deletá-lo da plataforma. Essa ação exclui permanentemente todos os documentos relacionados ao cliente, garantindo que não haja registros inconsistentes no sistema.
                                </ListItem>
                            </List>
                        </p>
                    </div>
                </Modal.Body>
                <Modal.Footer className="justify-end">
                    <Button gradientDuoTone="purpleToBlue" onClick={() => setTutorialModal(false)}>
                        Ok
                    </Button>
                </Modal.Footer>
            </Modal>

        </>
    );
}
