import { useFormik } from "formik";
import { useNavigate } from "react-router-dom";
import { Button, Label, Select, TextInput } from "flowbite-react";
import * as Yup from "yup";
import { FieldError, useNotification } from "components/shared/Notification";
import { Person, ROLE_LABELS, usePersonService } from "resources/person";
import { getCurrentOfficeId } from "utils/office";

const initialValues: Person = { name: "", cpf: "", cnpj: "", profession: "" };
const validationSchema = Yup.object().shape({
  name: Yup.string().trim().required("Nome é obrigatório!"),
});

export default function PersonForm() {
  const personService = usePersonService();
  const notification = useNotification();
  const navigate = useNavigate();
  const officeId = getCurrentOfficeId();

  const { values, handleChange, handleSubmit, errors } = useFormik<Person>({
    initialValues, validationSchema, onSubmit,
  });

  async function onSubmit(values: Person) {
    if (!officeId) {
      notification.notify("Selecione um escritório antes de cadastrar", "error");
      return;
    }
    try {
      await personService.create(officeId, values);
      notification.notify("Pessoa cadastrada com sucesso!", "success");
      navigate("/pessoas");
    } catch {
      notification.notify("Não foi possível cadastrar a pessoa", "error");
    }
  }

  return (
    <div className="max-w-2xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-semibold text-gray-900 tracking-tight mb-6">Nova pessoa</h1>
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <Label value="Nome completo / Razão social: *" />
          <TextInput id="name" value={values.name} onChange={handleChange} />
          <FieldError error={errors.name} />
        </div>
        <div className="grid grid-cols-2 gap-4">
          <div><Label value="CPF:" /><TextInput id="cpf" value={values.cpf} onChange={handleChange} /></div>
          <div><Label value="CNPJ:" /><TextInput id="cnpj" value={values.cnpj} onChange={handleChange} /></div>
        </div>
        <div className="grid grid-cols-2 gap-4">
          <div>
            <Label value="Papel:" />
            <Select id="role" value={values.role ?? ""} onChange={handleChange}>
              <option value="">Selecione...</option>
              {Object.entries(ROLE_LABELS).map(([key, label]) => (
                <option key={key} value={key}>{label}</option>
              ))}
            </Select>
          </div>
          <div><Label value="Profissão:" /><TextInput id="profession" value={values.profession} onChange={handleChange} /></div>
        </div>
        <div className="flex justify-end gap-2 pt-2">
          <Button color="light" onClick={() => navigate("/pessoas")}>Cancelar</Button>
          <Button color="dark" type="submit">Salvar</Button>
        </div>
      </form>
    </div>
  );
}