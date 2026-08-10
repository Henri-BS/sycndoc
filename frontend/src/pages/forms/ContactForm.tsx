import { useState } from "react";
import { Button, Label, Select, TextInput, Checkbox } from "flowbite-react";
import { Contact, PLATFORM_LABELS, useContactService } from "resources/contact";
import { useNotification } from "components/shared/Notification";

type Props = {
  personId: string;
  onCreated: (contact: Contact) => void;
  onCancel: () => void;
};

export default function ContactForm({ personId, onCreated, onCancel }: Props) {
  const contactService = useContactService();
  const notification = useNotification();

  const [platform, setPlatform] = useState<Contact["platform"]>("WHATSAPP");
  const [value, setValue] = useState("");
  const [label, setLabel] = useState("");
  const [primaryContact, setPrimaryContact] = useState(false);

  async function handleSubmit() {
    if (!value.trim()) {
      notification.notify("Preencha o valor do contato", "error");
      return;
    }
    try {
      const created = await contactService.create(personId, {
        platform, value, label, primaryContact, active: true,
      });
      notification.notify("Contato adicionado!", "success");
      onCreated(created);
    } catch {
      notification.notify("Não foi possível salvar o contato", "error");
    }
  }

  return (
    <div className="border border-gray-200 rounded-lg p-4 bg-gray-50 space-y-3">
      <div className="grid grid-cols-2 gap-3">
        <div>
          <Label value="Plataforma:" />
          <Select value={platform} onChange={(e) => setPlatform(e.target.value as Contact["platform"])}>
            {Object.entries(PLATFORM_LABELS).map(([key, label]) => (
              <option key={key} value={key}>{label}</option>
            ))}
          </Select>
        </div>
        <div>
          <Label value="Valor: *" />
          <TextInput value={value} onChange={(e) => setValue(e.target.value)} placeholder="Ex: (98) 99999-9999" />
        </div>
      </div>
      <div>
        <Label value="Rótulo (opcional):" />
        <TextInput value={label} onChange={(e) => setLabel(e.target.value)} placeholder="Ex: Comercial, Pessoal..." />
      </div>
      <Checkbox
        id="primaryContact"
        checked={primaryContact}
        onChange={(e) => setPrimaryContact(e.target.checked)}
      />
      <Label htmlFor="primaryContact" value="Contato principal" className="ml-2" />
      <div className="flex justify-end gap-2 pt-1">
        <Button size="sm" color="light" onClick={onCancel}>Cancelar</Button>
        <Button size="sm" color="dark" onClick={handleSubmit}>Salvar</Button>
      </div>
    </div>
  );
}