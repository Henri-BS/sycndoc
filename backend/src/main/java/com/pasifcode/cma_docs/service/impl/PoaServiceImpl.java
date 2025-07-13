package com.pasifcode.cma_docs.service.impl;

import com.pasifcode.cma_docs.domain.dto.PoaDto;
import com.pasifcode.cma_docs.domain.entity.Client;
import com.pasifcode.cma_docs.domain.entity.Poa;
import com.pasifcode.cma_docs.domain.repository.PoaRepository;
import com.pasifcode.cma_docs.service.PoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PoaServiceImpl implements PoaService {

    private final PoaRepository poaRepository;

    @Autowired
    public PoaServiceImpl(PoaRepository poaRepository) {
        this.poaRepository = poaRepository;
    }

    @Override
    public Page<PoaDto> findAll(Long clientId, Pageable pageable) {

        Specification<Poa> spec = Specification.not(null);

        if (clientId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("client").get("id"), clientId));
        }


        return poaRepository.findAll(spec, pageable).map(PoaDto::new);
    }

    @Override
    public PoaDto findById(Long id) {
        Poa find = poaRepository.findById(id).orElseThrow();
        return new PoaDto(find);
    }

    @Override
    public void saveDocumentByClient(Client client) {

        Poa add = new Poa();
        add.setTitle("Procuração - " + client.getClientName() + " (Christian Moura) ");
        add.setGrantor(
                "**" + client.getClientName() + "**, " + client.getClientNationality() + ", " + client.getClientMaritalStatus() + ", " +
                        client.getClientProfession() + ", portadora da carteira de identidade RG: nº " + client.getClientRgNumber() + ", inscrito no CPF: n° " + client.getClientCpf() +
                        ", residente e domiciliado em " + client.getClientAddress() + ", " + client.getClientResidentialNumber() + ", " + client.getClientDistrict() +
                        ", na cidade de " + client.getClientCity() + " - " + client.getClientUf() + ", CEP: " + client.getClientCep()

        );
        add.setGrantee(
                """
                   **Christian Moura de Oliveira**, OAB MA 29.388, endereço: Rua 24 de Dezembro nº 511/A bairro Seriema, Caxias - MA CEP: 65.602-420, endereço eletrônico christian@christianmoura.com.br. \n
                """
        );
        add.setDescription(
                """
                        O **objeto** desta procuração é representar o outorgante em todos os atos processuais ou administrativos, perante qualquer juiz, tribunal ou repartição pública.\s\s
                        **PODERES:** Por este instrumento particular de procuração, constituo meu procurador o Outorgado, concedendo-lhe os poderes especiais para tudo que se fizer necessário para minha defesa, \
                        incluindo a cláusula ad judicia, para podendo propor contra quem de direito as ações complementares e defende-lo nas contrárias, perante qualquer Juízo, Instância ou Tribunal, \
                        seguindo umas e outras, até final decisão, usando dos recursos legais e acompanhando-os, para o foro em geral, **salvo receber citação inicial**, como assim proclama o art. [105](https://www.jusbrasil.com.br/topicos/10729547/artigo-105-da-lei-n-5869-de-11-de-janeiro-de-1973) do (CPC)[https://www.jusbrasil.com.br/legislacao/91735/codigo-processo-civil-lei-5869-73]. \s
                        **PODERES ESPECÍFICOS:** A presente procuração outorga ao Advogado acima descrito, os poderes para pedir à justiça gratuita e assinar declaração de hipossuficiência econômica, \
                        conforme o disposto no art. [105](https://www.jusbrasil.com.br/topicos/10729547/artigo-105-da-lei-n-5869-de-11-de-janeiro-de-1973) do (CPC)[https://www.jusbrasil.com.br/legislacao/91735/codigo-processo-civil-lei-5869-73]; representar-me nas audiências, junto ao Instituto Nacional de Seguro Social – INSS (requerimento de senha, protocolar, cópia de processo, \
                        verificar o andamento do processo, etc.), Ministério do Trabalho e Emprego, Banco Bradesco, Banco do Brasil, Banco Itaú, Caixa Econômica Federal e Banco do Nordeste do Brasil (requerer extrato, \
                        prestar declaração de isenção de imposto de renda ou assinar declaração de isenção e documentos essenciais à sua representação), requerer, confessar, desistir, renunciar, transigir, firmar compromisso e/ou acordos, \
                        receber e dar quitação, inclusive levantamento de alvará e RPV ou qualquer outro pagamento oriundo da presente, falar em nome do Outorgante, podendo agir em conjunto ou separadamente, \
                        podendo ainda substabelecer com ou sem reservas de iguais poderes, dando tudo por bom, firme e valioso, para me representar em juízo.\s
                        """
        );
        add.setLocation("Caxias - MA");
        add.setDate("3 de Junho de 2025.");
        add.setContent(
                "### Outorgante\n\n" + add.getGrantor() + "\n\n ### Outorgado\n\n" + add.getGrantee() + "\n\n" + add.getDescription() + "\n\n" + add.getLocation() + ", " + add.getDate()
        );
        add.setClient(client);
        add.setUser(client.getUser());
        poaRepository.saveAndFlush(add);
    }
}

