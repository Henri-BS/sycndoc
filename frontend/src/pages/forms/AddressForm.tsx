import { useEffect, useState } from "react";
import { useFormik } from "formik";
import { useNavigate, useParams } from "react-router-dom";
import { Button, Label, Select, TextInput } from "flowbite-react";
import * as Yup from "yup";
import { FieldError, useNotification } from "components/shared/Notification";
import { Address, useAddressService } from "resources/address";
import { Locality, useLocalityService } from "resources/locality";
import { getCurrentOfficeId } from "utils/office";

const initialValues: Address = { localityId: "", number: "", complement: "" };
const validationSchema = Yup.object().shape({
  localityId: Yup.string().required("Selecione uma localidade!"),
});

export default function AddressForm() {
  const { personId } = useParams();
  const addressService = useAddressService();
  const localityService = useLocalityService();
  const notification = useNotification();
  const navigate = useNavigate();
  const officeId = getCurrentOfficeId();

  const [localities, setLocalities] = useState<Locality[]>([]);

  useEffect(() => {
    if (officeId) {
      localityService.findAllByOffice(officeId).then(setLocalities).catch(() => {
        notification.notify("Não foi possível carregar as localidades", "error");
      });
    }
  }, []);

  const { values, handleChange, handleSubmit, errors } = useFormik<Address>({
    initialValues, validationSchema, onSubmit,
  });

  async function onSubmit(values: Address) {
    if (!personId) return;
    try {
      await addressService.create(personId, values);
      notification.notify("Endereço cadastrado com sucesso!", "success");
      navigate(`/pessoas/${personId}`);
    } catch {
      notification.notify("Não foi possível cadastrar o endereço", "error");
    }
  }

  return (
    <div className="max-w-2xl mx-auto px-4 py-10">
      <h1 className="text-2xl font-semibold text-gray-900 tracking-tight mb-6">Novo endereço</h1>
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <Label value="Localidade: *" />
          <Select id="localityId" value={values.localityId} onChange={handleChange}>
            <option value="">Selecione...</option>
            {localities.map((l) => (
              <option key={l.id} value={l.id}>{l.name} {l.city ? `— ${l.city}/${l.state}` : ""}</option>
            ))}
          </Select>
          <FieldError error={errors.localityId} />
          {localities.length === 0 && (
            <p className="text-xs text-gray-400 mt-1">Nenhuma localidade cadastrada nesse escritório ainda.</p>
          )}
        </div>
        <div className="grid grid-cols-2 gap-4">
          <div><Label value="Número:" /><TextInput id="number" value={values.number} onChange={handleChange} /></div>
          <div><Label value="Complemento:" /><TextInput id="complement" value={values.complement} onChange={handleChange} /></div>
        </div>
        <div className="flex justify-end gap-2 pt-2">
          <Button color="light" onClick={() => navigate(-1)}>Cancelar</Button>
          <Button color="dark" type="submit">Salvar</Button>
        </div>
      </form>
    </div>
  );
}