export type Poa = {
  id: number;
  title: string;
  grantee: string;
  grantor: string;
  description: string;
  date: string; 
  location: string;
  content: string;
  createdDate: string; 
  userId: number;
  username: string;
  clientName: string;
};

export type PoaPage = {
  content: Poa[];
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

export type PoaProps = {
    poa: Poa;
}