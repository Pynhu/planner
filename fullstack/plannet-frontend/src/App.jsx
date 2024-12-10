import React from "react";
import ListaZadan from "./komponenty/listaZadan";
import ZadaniaKomponenty from "./komponenty/zadaniaKomponenty";
import HeadKomponent from "./komponenty/headKomponent";
import DodanieZadania from "./komponenty/DodanieZadania";
import { BrowserRouter, Routes, Route } from "react-router-dom";

const App = () => {
  return (
    <BrowserRouter>
      <HeadKomponent />
      <Routes>
        <Route path="/" element={<ListaZadan />} />
        <Route path="/plan" element={<ListaZadan />} />
        <Route path='/dodaj-zadanie' element={<DodanieZadania/>}/>
        <Route path='/edit-zadanie' element={<DodanieZadania/>}/>
      </Routes>
    </BrowserRouter>
  );
};

export default App;
