import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './pages/Home';
import Plantas from './pages/Plantas';
import Cadastro from './pages/Cadastro';
import Calcula from './pages/Calcula';


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
