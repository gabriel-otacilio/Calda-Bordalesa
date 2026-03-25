import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './pages/Home/Home.jsx';
import Plantas from './pages/Plantas/Plantas.jsx';
import Cadastro from './pages/Cadastro/Cadastro.jsx';
import Calcula from './pages/Calcula/Calcula.jsx';


function App() {

    return (

        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/plantas" element={<Plantas/>}/>
                <Route path="/cadastro" element={<Cadastro/>}/>
                <Route path="/calcula" element={<Calcula/>}/>
            </Routes>
        </BrowserRouter>

    )
}

export default App
