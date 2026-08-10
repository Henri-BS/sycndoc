import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Button, TextInput, Badge } from "flowbite-react";
import { FaPlus, FaUser, FaBuilding } from "react-icons/fa6";
import { Person, ROLE_LABELS, usePersonService } from "resources/person";
import { getCurrentOfficeId, setCurrentOfficeId } from "utils/office";
import { useNotification } from "components/shared/Notification";

export default function PersonList() {
  const personService = usePersonService();
  const notification = useNotification();
  const navigate = useNavigate();

  const [officeId, setOfficeId] = useState(getCurrentOfficeId() ?? "e33c3d2d-fffb-476c-bd24-ea61c269aa3c");
  const [persons, setPersons] = useState<Person[]>([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (officeId) loadPersons(officeId);
  }, []);

  async function loadPersons(id: string) {
    setLoading(true);
    try {
      setPersons(await personService.findAllByOffice(id));
    } catch {
      notification.notify("Não foi possível carregar as pessoas", "error");
    } finally {
      setLoading(false);
    }
  }

  function handleSetOffice() {
    if (!officeId.trim()) return;
    setCurrentOfficeId(officeId.trim());
    loadPersons(officeId.trim());
  }

  return (
    <div className="max-w-4xl mx-auto px-4 py-10">
      <div className="flex items-center justify-between mb-8">
        <div>
          <h1 className="text-2xl font-semibold text-gray-900 tracking-tight">Pessoas</h1>
          <p className="text-sm text-gray-500 mt-1">Clientes, testemunhas, representantes e outros vínculos do escritório.</p>
        </div>
        <Button color="dark" onClick={() => navigate("/pessoas/nova")} disabled={!officeId}>
          <FaPlus className="mr-2" /> Nova pessoa
        </Button>
      </div>

      <div className="flex items-end gap-3 mb-8 bg-gray-50 border border-gray-200 rounded-lg p-4">
        <div className="flex-1">
          <label className="block text-xs font-medium text-gray-500 mb-1">
            <FaBuilding className="inline mr-1 mb-0.5" /> ID do escritório ativo
          </label>
          <TextInput value={officeId} onChange={(e) => setOfficeId(e.target.value)} placeholder="Cole o UUID do escritório" />
        </div>
        <Button color="light" onClick={handleSetOffice}>Carregar</Button>
      </div>

      {loading && <p className="text-sm text-gray-400">Carregando...</p>}
      {!loading && officeId && persons.length === 0 && (
        <p className="text-sm text-gray-400">Nenhuma pessoa cadastrada ainda.</p>
      )}

      <div className="flex flex-col gap-2">
        {persons.map((person) => (
          <Link key={person.id} to={`/pessoas/${person.id}`} className="flex items-center justify-between border border-gray-200 rounded-lg px-4 py-3 hover:border-gray-400 hover:shadow-sm transition">
            <div className="flex items-center gap-3">
              <div className="w-9 h-9 rounded-full bg-gray-900 text-white flex items-center justify-center">
                <FaUser size={14} />
              </div>
              <div>
                <p className="text-sm font-medium text-gray-900">{person.name}</p>
                <p className="text-xs text-gray-500">{person.cpf || person.cnpj || "Sem documento"}</p>
              </div>
            </div>
            {person.role && <Badge color="gray">{ROLE_LABELS[person.role]}</Badge>}
          </Link>
        ))}
      </div>
    </div>
  );
}