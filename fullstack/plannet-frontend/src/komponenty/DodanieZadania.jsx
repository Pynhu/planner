import React, { useState, useEffect } from "react";
import "./DodanieZadania.css"; 
import { createZadanie, updateZadanie } from "../serwis/plany";

const DodanieZadania = ({ zamknijPopup, odswiezZadania, zadanie }) => {
  const [opis, setOpis] = useState("");  
  const [temat, setTemat] = useState("");
  const [dataTerminu, setDataTerminu] = useState("");

  useEffect(() => {
    if (zadanie) {
      setTemat(zadanie.temat);
      setOpis(zadanie.opis);
      setDataTerminu(zadanie.dataTerminu);  
    }
  }, [zadanie]);

  const handleTemat = (e) => setTemat(e.target.value);
  const handleOpis = (e) => setOpis(e.target.value);
  const handleData = (e) => setDataTerminu(e.target.value);

  function saveZadanie(e) {
    e.preventDefault();

    const noweZadanie = { temat, opis, dataTerminu };

    if (zadanie && zadanie.id) {
      // Edytuj istniejące zadanie
      updateZadanie(zadanie.id, noweZadanie)
        .then(() => {
          console.log("Zadanie zaktualizowane:", noweZadanie);
          if (typeof odswiezZadania === "function") {
            odswiezZadania();
          }
          zamknijPopup();
        })
    } else {
      createZadanie(noweZadanie)
        .then(() => {
          console.log("Zadanie zapisane:", noweZadanie);
          if (typeof odswiezZadania === "function") {
            odswiezZadania();
          }
          setTemat("");
          setOpis("");
          setDataTerminu("");
          zamknijPopup();
        })
    }
  }

  return (
    <form onSubmit={saveZadanie}>
      <h2>{zadanie ? "Edytuj zadanie" : "Dodaj nowe zadanie"}</h2>
      <label>
        Temat:
        <input 
          type="text" 
          value={temat}
          onChange={handleTemat}
          required
        />
      </label>
      <label>
        Opis:
        <input 
          type="text" 
          value={opis}
          onChange={handleOpis}
          required
        />
      </label>
      <label>
        Data Terminu:
        <input 
          type="date" 
          value={dataTerminu}
          onChange={handleData}
          required
        />
      </label>
      <button type="submit">{zadanie ? "Zapisz zmiany" : "Zapisz"}</button>
      <button type="button" onClick={zamknijPopup}>
        Anuluj
      </button>
    </form>
  );
};

export default DodanieZadania;
