import axios from "axios";
import { baseUrl } from "utils/requests";

export type Address = {
  id?: string;
  sequenceNumber?: number;
  localityId: string;
  number?: string;
  complement?: string;
  latitude?: number;
  longitude?: number;
  directLink?: string;
  active?: boolean;
};

class AddressService {
  async create(personId: string, address: Address): Promise<Address> {
    const response = await axios.post(`${baseUrl}/persons/${personId}/addresses`, address);
    return response.data;
  }
  async findAllByPerson(personId: string): Promise<Address[]> {
    const response = await axios.get(`${baseUrl}/persons/${personId}/addresses`);
    return response.data;
  }
}

export const useAddressService = () => new AddressService();