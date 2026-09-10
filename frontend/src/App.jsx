import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import Home from './assets/pages/Home';
import Login from './assets/pages/Login';
import Perfil from './assets/pages/Perfil';



function App(){
  return (
    <BrowserRouter>
      <div> 
        <nav style={{ padding: '10px', backgroundColor: '#f0f0f0', marginBottom: '20px' }}>
          <h1>Sports Manager </h1>
          <ul style={{ display: 'flex', gap: '15px', listStyle: 'none', padding: 0 }}>
            {/* O <Link> substitui a tag <a> normal para evitar que a página recarregue */}
            <li><Link to="/">Página Principal</Link></li>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/perfil">O Meu Perfil</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/perfil" element={<Perfil />} />
          
          {/* Rota para apanhar links que não existem (Erro 404) */}
          <Route path="*" element={<h2>404 - Página não encontrada 🕵️‍♂️</h2>} />
        </Routes>
      </div>

      </BrowserRouter>
  );
}

export default App;
