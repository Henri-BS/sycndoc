import axios from "axios";
import { baseUrl } from "utils/requests";

export type ContactPlatform =
  | "PHONE" | "EMAIL" | "WEBSITE" | "SOCIAL_NETWORK" | "MESSENGER"
  | "WHATSAPP" | "TELEGRAM" | "INSTAGRAM" | "FACEBOOK" | "LINKEDIN"
  | "THREADS" | "BLUESKY" | "DISCORD" | "SIGNAL" | "OTHER";

export type Contact = {
  id?: string;
  sequenceNumber?: number;
  personId?: string;
  platform: ContactPlatform;
  value: string;
  label?: string;
  primaryContact?: boolean;
  active?: boolean;
};

export const PLATFORM_LABELS: Record<ContactPlatform, string> = {
  PHONE: "Telefone",
  EMAIL: "E-mail",
  WEBSITE: "Site",
  SOCIAL_NETWORK: "Rede social",
  MESSENGER: "Messenger",
  WHATSAPP: "WhatsApp",
  TELEGRAM: "Telegram",
  INSTAGRAM: "Instagram",
  FACEBOOK: "Facebook",
  LINKEDIN: "LinkedIn",
  THREADS: "Threads",
  BLUESKY: "Bluesky",
  DISCORD: "Discord",
  SIGNAL: "Signal",
  OTHER: "Outro",
};

class ContactService {
  async create(personId: string, contact: Contact): Promise<Contact> {
    const response = await axios.post(`${baseUrl}/persons/${personId}/contacts`, contact);
    return response.data;
  }
  async findAllByPerson(personId: string): Promise<Contact[]> {
    const response = await axios.get(`${baseUrl}/persons/${personId}/contacts`);
    return response.data;
  }
  async update(contactId: string, contact: Contact): Promise<Contact> {
    const response = await axios.put(`${baseUrl}/contacts/${contactId}`, contact);
    return response.data;
  }
  async remove(contactId: string): Promise<void> {
    await axios.delete(`${baseUrl}/contacts/${contactId}`);
  }
}

export const useContactService = () => new ContactService();