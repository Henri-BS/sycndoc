import { Pagination, SearchBar } from "components/shared/Pagination";
import { UserCard } from "components/cards/UserCard";
import { UserPage } from "resources/user";
import { useEffect, useState } from "react";
import { removeAccents } from "components/shared/Template";
import axios from "axios";
import { baseUrl } from "utils/requests";
import { FaUser } from "react-icons/fa6";

export default function Users() {
    const [query, setQuery] = useState("");
    const [pageNumber, setPageNumber] = useState(0);
    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }
    const [userPage, setUserPage] = useState<UserPage>({ content: [], size: 0, number: 0, totalElements: 0,  totalPages: 0 });

    useEffect(() => {
        axios.get(`${baseUrl}/users?page=${pageNumber}&size=12&sort=createdDate,DESC`)
            .then((response) => {
                setUserPage(response.data);
            });
    }, [pageNumber, query]);

    return (
        <div className="px-4">
            <SearchBar
                pageIcon={<FaUser />}
                pageTitle="Usuários"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
            />
            <Pagination pagination={userPage} onPageChange={handlePageChange} />
            <div className="grid grid-cols-1 md:grid-cols-3 gap-y-10 gap-x-6 items-start mt-5">
                {userPage.content?.filter((user) =>
                    user.username?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                    removeAccents(user.username)?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                    user.userLocation?.toUpperCase().includes(query.toLocaleUpperCase()) ||
                    removeAccents(user.userLocation)?.toUpperCase().includes(query.toLocaleUpperCase())
                ).map(user => (
                    <div key={user.id} className="relative flex jsutify-center">
                        <UserCard user={user} />
                    </div>
                ))}
            </div>
        </div>
    );
}