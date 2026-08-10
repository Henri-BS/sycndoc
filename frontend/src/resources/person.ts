import axios from "axios";
import { baseUrl } from "utils/requests";

export type PersonRole = "CLIENTE" | "AUTOR" | "TESTEMUNHA" | "REPRESENTANTE" | "A_ROGO" | "PARCEIRO" | "OUTRO";
export type Gender = "MALE" | "FEMALE" | "OTHER";
export type MaritalStatus = "SINGLE" | "MARRIED" | "DIVORCED" | "WIDOWED" | "STABLE_UNION";

export type Person = {
  id?: string;
  sequenceNumber?: number;
  name: string;
  cpf?: string;
  cnpj?: string;
  role?: PersonRole;
  gender?: Gender;
  birthDate?: string;
  maritalStatus?: MaritalStatus;
  profession?: string;
};

export const ROLE_LABELS: Record<PersonRole, string> = {
  CLIENTE: "Cliente",
  AUTOR: "Autor",
  TESTEMUNHA: "Testemunha",
  REPRESENTANTE: "Representante",
  A_ROGO: "A Rogo",
  PARCEIRO: "Parceiro",
  OUTRO: "Outro",
};

class PersonService {
  async create(officeId: string, person: Person): Promise<Person> {
    const response = await axios.post(`${baseUrl}/persons/office/${officeId}`, person);
    return response.data;
  }
  async findAllByOffice(officeId: string): Promise<Person[]> {
    const response = await axios.get(`${baseUrl}/persons/office/${officeId}`);
    return response.data;
  }
}

export const usePersonService = () => new PersonService();