import { Header, Footer } from "components/shared/Template";
import AddressForm from "pages/forms/AddressForm";
import LocalityForm from "pages/forms/LocalityForm";
import PersonForm from "pages/forms/PersonForm";
import { Login, UserEditProfile } from "pages/forms/UserForm";
import PersonList from "pages/lists/PersonList";
import Users from "pages/lists/UserList";
import Home from "pages/main/Home";
import PersonProfile from "pages/profiles/PersonProfile";
import { UserProfile } from "pages/profiles/UserProfile";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import { useAuth } from "resources/auth";

export default function PageRoutes() {
    const auth = useAuth();
    return (
        <>
            <BrowserRouter>
                <Header />
                <div>
                    <Routes>
                        <Route path="/login" element={<Login />} />
                        {!auth.isSessionValid ? <Login /> :
                            <>
                                <Route path="/" element={<Home />} />
                                <Route path="/usuarios" element={<Users />} />
                                <Route path="/usuarios/:userId" element={<UserProfile />} />
                                <Route path="/perfil/editar/:userId" element={<UserEditProfile />} />
                                <Route path="/pessoas" element={<PersonList />} />
                                <Route path="/pessoas/nova" element={<PersonForm />} />
                                <Route path="/pessoas/:personId" element={<PersonProfile />} />
                                <Route path="/pessoas/:personId/enderecos/novo" element={<AddressForm />} />
                                <Route path="/localidades/nova" element={<LocalityForm
                                 />} />
                            </>
                        }
                    </Routes>

                </div>
                <Footer />
                <ToastContainer position="top-right"
                    autoClose={8000}
                    hideProgressBar={false}
                    draggable={false}
                    closeOnClick={true}
                    pauseOnHover={true}
                />
            </BrowserRouter>
        </>
    );
}