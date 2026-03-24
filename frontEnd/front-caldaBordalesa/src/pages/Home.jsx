import { Link } from "react-router-dom";

export default function Home() {
    return (
        <div>
            <h1>Página Inicial</h1>
            <Link to="/plantas">Plantas</Link>
            <br/>
            <Link to="/calcula">calcula calda</Link>
            <br/>
            <Link to="/cadastro">Cadastrar planta</Link>

        </div>
    );
}
