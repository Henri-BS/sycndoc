declare const process: { env: { REACT_APP_BACKEND_URL?: string } };

export const baseUrl = process.env.REACT_APP_BACKEND_URL ?? "http://localhost:8080";