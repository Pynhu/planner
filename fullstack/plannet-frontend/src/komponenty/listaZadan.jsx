import React, { useEffect, useState } from "react";
import { listaZadan, usunZadanie } from "../serwis/plany";
import DodanieZadania from "./DodanieZadania";
import "./Popup.css";

const ListaZadan = () => {
  const [zadanie, ustawZadanie] = useState([]);
  const [isPopupOpen, setIsPopupOpen] = useState(false);
  const [aktualneZadanie, ustawAktualneZadanie] = useState(null);

  const pobierzZadania = () => {
    listaZadan()
      .then((response) => {
        ustawZadanie(response.data); 
      })
  };

  useEffect(() => {
    pobierzZadania();
  }, []);

  const otworzPopup = (zadanie = null) => {
    ustawAktualneZadanie(zadanie);
    setIsPopupOpen(true);
  };

  const zamknijPopup = () => {
    ustawAktualneZadanie(null);
    setIsPopupOpen(false);
  };
  const usunZad=(id)=>{
    usunZadanie(id).then(()=>{
      pobierzZadania();
    }) 
  }

  return (
    <div>
      <button onClick={() => otworzPopup(null)}>Dodaj zadanie</button>
      <table>
        <thead>
          <tr>
            
            <th>Temat</th>
            <th>Opis</th>
            <th>Data Terminu</th>
            
          </tr>
        </thead>
        <tbody>
          {zadanie.length > 0 ? (
            zadanie.map((z) => (
              <tr key={z.id}>
              
                <td>{z.temat}</td>
                <td>{z.opis}</td>
                <td>{z.dataTerminu}</td>
                <td>
                  <button onClick={() => otworzPopup(z)}>Edytuj</button>
                  <button onClick={()=>usunZad(z.id)}>x</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5">Brak zadań do wyświetlenia</td>
            </tr>
          )}
        </tbody>
      </table>
      {isPopupOpen && (
        <div className="popup">
          <div className="popup-inner">
            <DodanieZadania zamknijPopup={zamknijPopup} odswiezZadania={pobierzZadania} zadanie={aktualneZadanie} />
          </div>
        </div>
      )}
    </div>
  );
};

export default ListaZadan;
