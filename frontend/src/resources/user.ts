import axios from "axios";
import { baseUrl } from "utils/requests";

export type User = {
  id?: number;
  username?: string;
  email?: string;
  password?: string;
  userRoles?: string;
  userBio?: string;
  userImage?: string;
  userCoverImage?: string;
  userLocation?: string;
  createdDate?: string;
};

export type UserPage = {
  content: User[];
  number: 0;
  totalPages: 0;
  size: 0;
  totalElements: 0;
  first?: true;
  last?: true;
  numberOfElements?: 0;
  sort?: [
    {
      direction: string;
      nullHandling: string;
      ascending: true;
      property: string;
      ignoreCase: true;
    }
  ];
  pageable?: {
    offset: 0;
    sort: [
      {
        direction: string;
        nullHandling: string;
        ascending: true;
        property: string;
        ignoreCase: true;
      }
    ];
    paged: true;
    pageSize: 0;
    pageNumber: 0;
    unpaged: true;
  };
  empty?: true;
};

export type UserProps = {
  user: User;
};

export type Credentials = {
  email?: string;
  password?: string;
}

export type AccessToken = {
  accessToken?: string;
}

export type UserSessionToken = {
  id?: number;
  username?: string;
  userImage?: string;
  userRoles?: string;
  email?: string;
  accessToken?: string;
  expiration?: number;
}

class UserService {
async updateUserInfo(user: User): Promise<void> {
  const response = await axios(`${baseUrl}/users/update`, {
    method: "PUT",
    data: JSON.stringify(user),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return await response.data;
}
}

export const useUserService = () => new UserService();

