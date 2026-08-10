import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Button, Badge } from "flowbite-react";
import { FaPlus, FaMapPin } from "react-icons/fa6";
import { Person, ROLE_LABELS } from "resources/person";
import { Address, useAddressService } from "resources/address";
import { baseUrl } from "utils/requests";
import axios from "axios";
import { FaPhone } from "react-icons/fa6";
import { Contact, PLATFORM_LABELS, useContactService } from "resources/contact";
import ContactForm from "pages/forms/ContactForm";

export default function PersonProfile() {
  const { personId } = useParams();
  const addressService = useAddressService();
  const navigate = useNavigate();

  const [person, setPerson] = useState<Person | null>(null);
  const [addresses, setAddresses] = useState<Address[]>([]);

  useEffect(() => {
    if (!personId) return;
    axios.get(`${baseUrl}/persons/${personId}`).then((r) => setPerson(r.data));
    addressService.findAllByPerson(personId).then(setAddresses);
  }, [personId]);

  if (!person) return <p className="text-center py-10 text-gray-400">Carregando...</p>;

  const contactService = useContactService();
  const [contacts, setContacts] = useState<Contact[]>([]);
  const [showContactForm, setShowContactForm] = useState(false);

  if (personId) contactService.findAllByPerson(personId).then(setContacts);

  return (
    <div className="max-w-2xl mx-auto px-4 py-10">
      <div className="flex items-center justify-between mb-6">
        <div>
          <h1 className="text-2xl font-semibold text-gray-900 tracking-tight">{person.name}</h1>
          <p className="text-sm text-gray-500 mt-1">{person.cpf || person.cnpj}</p>
        </div>
        {person.role && <Badge color="gray">{ROLE_LABELS[person.role]}</Badge>}
      </div>

      <div className="flex items-center justify-between mb-3">
        <h2 className="text-sm font-semibold text-gray-700">Endereços</h2>
        <Button size="xs" color="light" onClick={() => navigate(`/pessoas/${personId}/enderecos/novo`)}>
          <FaPlus className="mr-1" size={10} /> Novo endereço
        </Button>
      </div>

      {addresses.length === 0 && <p className="text-sm text-gray-400">Nenhum endereço cadastrado.</p>}

      <div className="flex flex-col gap-2">
        {addresses.map((a) => (
          <div key={a.id} className="flex items-center gap-3 border border-gray-200 rounded-lg px-4 py-3">
            <FaMapPin className="text-gray-400" />
            <p className="text-sm text-gray-700">Nº {a.number}{a.complement ? `, ${a.complement}` : ""}</p>
          </div>
        ))}
      </div>


      <div className="flex items-center justify-between mt-8 mb-3">
        <h2 className="text-sm font-semibold text-gray-700">Contatos</h2>
      </div>

      {showContactForm && personId && (
        <div className="mb-3">
          <ContactForm
            personId={personId}
            onCreated={(c) => { setContacts([...contacts, c]); setShowContactForm(false); }}
            onCancel={() => setShowContactForm(false)}
          />
        </div>
      )}

      {contacts.length === 0 && (
        <p className="text-sm text-gray-400">Nenhum contato cadastrado.</p>
      )}

      <div className="flex flex-col gap-2">
        {contacts.map((c) => (
          <div key={c.id} className="flex items-center gap-3 border border-gray-200 rounded-lg px-4 py-3">
            <FaPhone className="text-gray-400" size={12} />
            <div>
              <p className="text-sm text-gray-700">{c.value} {c.primaryContact && <span className="text-xs text-gray-400">(principal)</span>}</p>
              <p className="text-xs text-gray-400">{PLATFORM_LABELS[c.platform]}{c.label ? ` — ${c.label}` : ""}</p>
            </div>
          </div>
        ))}
      </div>

    </div>
  );
}