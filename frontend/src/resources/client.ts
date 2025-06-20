export type Client = {
  id: number;
  clientName: string;
  clientNationality: string;
  clientMaritalStatus: string;
  clientProfession: string;
  clientRgNumber: string;
  clientRgIssueDate: string;
  clientCpf: string;
  clientBirthDate: string;
  clientRelatives: string;
  clientAddress: string;
  clientResidentialNumber: string;
  clientDistrict: string;
  clientCity: string;
  clientUf: string;
  clientCep: string;

  proxyName: string;
  proxyCpf: string;
  proxyRg: string;
  proxyRelatives: string;
  proxyAddress: string;
  proxyDistrict: string;
  proxyCity: string;
  proxyUf: string;
  proxyCep: string;

  witness1Name: string;
  witness1Rg: string;
  witness1Cpf: string;

  witness2Name: string;
  witness2Rg: string;
  witness2Cpf: string;

  createdDate: string;
  userId: number;
  username: string;
};

export type ClientPage = {
  content: Client[];
  number: 0;
  totalPages: 0;
  size: 0;
  totalElements: 0;
  first?: true;
  last?: true;
  numberOfElements?: 0;
  sort?: [
    {
      direction: string;
      nullHandling: string;
      ascending: true;
      property: string;
      ignoreCase: true;
    }
  ];
  pageable?: {
    offset: 0;
    sort: [
      {
        direction: string;
        nullHandling: string;
        ascending: true;
        property: string;
        ignoreCase: true;
      }
    ];
    paged: true;
    pageSize: 0;
    pageNumber: 0;
    unpaged: true;
  };
  empty?: true;
};

export type ClientProps = {
  client: Client;
};
