const OFFICE_KEY = "_currentOfficeId";
export function getCurrentOfficeId(): string | null {
  return localStorage.getItem(OFFICE_KEY);
}
export function setCurrentOfficeId(id: string): void {
  localStorage.setItem(OFFICE_KEY, id);
}