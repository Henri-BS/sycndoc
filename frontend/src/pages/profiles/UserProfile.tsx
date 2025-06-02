import { CustomMarkdown } from "components/shared/Custom";
import { User } from "resources/user";
import { Props } from "resources";
import { baseUrl } from "utils/requests";


import { useEffect, useState } from "react";
import * as FaIcons from "react-icons/fa6";
import { useParams } from "react-router-dom";
import axios from "axios";

export function UserProfile() {
    const params = useParams();

    return (
        <UserDetails params={`${params.userId}`} />
    );

    function UserDetails({ params: userId }: Props) {

        const [user, setUser] = useState<User>();


        useEffect(() => {
            axios.get(`${baseUrl}/users/${userId}`)
                .then((response) => {
                    setUser(response.data);
                });
        }, [userId]);

        return (
            <div>
                <div>
                    <div className="flex flex-wrap items-center justify-center mb-4">
                        <div className="lg:w-full bg-white transform duration-200 easy-in-out">
                            <div className=" h-40 overflow-hidden" >
                                <img className="w-full" src={user?.userCoverImage ?? require("assets/img/user_cover.png")} alt={user?.username} />
                            </div>
                            <div className="flex  px-5 -mt-16 ">
                                <img className="h-32 w-32 bg-white border-2 border-gray-500 p-2 rounded-full" src={user?.userImage ?? require("assets/img/user_profile.png")} alt={user?.username} />
                            </div>
                            <div className="text-gray-600 text-center px-14">
                                <h2 className="text-gray-800 text-3xl font-bold">{user?.username}</h2>
                            </div>
                        </div>
                    </div>

                    <h2 className="flex flex-row items-center gap-2 text-xl text-slate-800 ">
                        <FaIcons.FaPencil />Cargo
                    </h2>
                    <p className="mt-2 text-md md:text-lg ">
                        <CustomMarkdown item={user?.userBio} />
                    </p>
                </div>
            </div>
        );
    }
}
