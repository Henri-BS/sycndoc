import { useFormik } from "formik";
import { useNavigate } from "react-router-dom";
import { Button, Label, Select, TextInput, Textarea } from "flowbite-react";
import * as Yup from "yup";
import { FieldError, useNotification } from "components/shared/Notification";
import { Locality, useLocalityService } from "resources/locality";
import { getCurrentOfficeId } from "utils/office";

const initialValues: Locality = { name: "", country: "Brasil" };
const validationSchema = Yup.object().shape({
  name: Yup.string().trim().required("Nome da localidade é obrigatório!"),
});

export default function LocalityForm() {
  const localityService = useLocalityService();
  const notification = useNotification();
  const navigate = useNavigate();
  const officeId = getCurrentOfficeId();

  const { values, handleChange, handleSubmit, errors } = useFormik<Locality>({
    initialValues, validationSchema, onSubmit,
  });

  async function onSubmit(values: Locality) {
    if (!officeId) {
      notification.notify("Selecione um escritório antes de cadastrar", "error");
      return;
    }
    try {
      await localityService.create(officeId, values);
      notification.notify("Localidade cadastrada com sucesso!", "success");
      navigate(-1);
    } catch {
      notification.notify("Não foi possível cadastrar a localidade", "error");
    }
  }

  return (
    <div className="max-w-2xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-semibold text-gray-900 tracking-tight mb-6">Nova localidade</h1>
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <Label value="Nome da localidade: *" />
          <TextInput id="name" value={values.name} onChange={handleChange} placeholder="Ex: Centro de Caxias" />
          <FieldError error={errors.name} />
        </div>
        <div className="grid grid-cols-2 gap-4">
          <div><Label value="Estado:" /><TextInput id="state" value={values.state} onChange={handleChange} /></div>
          <div><Label value="Cidade:" /><TextInput id="city" value={values.city} onChange={handleChange} /></div>
        </div>
        <div className="grid grid-cols-2 gap-4">
          <div><Label value="Bairro/Distrito:" /><TextInput id="district" value={values.district} onChange={handleChange} /></div>
          <div>
            <Label value="Zona:" />
            <Select id="zoneType" value={values.zoneType ?? ""} onChange={handleChange}>
              <option value="">Selecione...</option>
              <option value="URBAN">Urbana</option>
              <option value="RURAL">Rural</option>
            </Select>
          </div>
        </div>
        <div>
          <Label value="Observações:" />
          <Textarea id="observations" value={values.observations} onChange={handleChange} rows={3} />
        </div>
        <div className="flex justify-end gap-2 pt-2">
          <Button color="light" onClick={() => navigate(-1)}>Cancelar</Button>
          <Button color="dark" type="submit">Salvar</Button>
        </div>
      </form>
    </div>
  );
}