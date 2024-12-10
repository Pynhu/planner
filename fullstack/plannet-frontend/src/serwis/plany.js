import axios from "axios";

const rest_api_base_url = "http://localhost:8080/api/planner";

export const listaZadan = () => axios.get(rest_api_base_url);
export const createZadanie = (zadanie) => axios.post(rest_api_base_url, zadanie); // Poprawione na `rest_api_base_url`

// Pobranie zadania po ID
export const getZadanie = (id) => axios.get(`${rest_api_base_url}/${id}`);

// Aktualizacja zadania
export const updateZadanie = (id, updatedZadanie) => axios.put(`${rest_api_base_url}/${id}`, updatedZadanie);


export const usunZadanie=(id)=>axios.delete(`${rest_api_base_url}/${id}`);


