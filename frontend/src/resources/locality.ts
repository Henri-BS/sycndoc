import axios from "axios";
import { baseUrl } from "utils/requests";

export type ZoneType = "URBAN" | "RURAL";

export type Locality = {
  id?: string;
  sequenceNumber?: number;
  country?: string;
  region?: string;
  state?: string;
  city?: string;
  district?: string;
  name: string;
  zoneType?: ZoneType;
  observations?: string;
  active?: boolean;
};

class LocalityService {
  async create(officeId: string, locality: Locality): Promise<Locality> {
    const response = await axios.post(`${baseUrl}/offices/${officeId}/localities`, locality);
    return response.data;
  }
  async findAllByOffice(officeId: string): Promise<Locality[]> {
    const response = await axios.get(`${baseUrl}/offices/${officeId}/localities`);
    return response.data;
  }
}

export const useLocalityService = () => new LocalityService();