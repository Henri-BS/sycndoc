import { Header, Footer } from "components/shared/Template";
import { Login, UserEditProfile } from "pages/forms/UserForm";
import Users from "pages/lists/UserList";
import Home from "pages/main/Home";
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
                            {!auth.isSessionValid ? <Login/> :
                                <>
                                    <Route path="/" element={<Home />} />
                                    <Route path="/usuarios" element={<Users />} />
                                    <Route path="/usuarios/:userId" element={<UserProfile />} />
                                    <Route path="/perfil/editar/:userId" element={<UserEditProfile />} />

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