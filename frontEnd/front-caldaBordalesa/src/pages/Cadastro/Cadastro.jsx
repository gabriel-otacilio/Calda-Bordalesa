import {Link} from "react-router-dom";

function Cadastro() {

    return (
        <div>
            <h1>Cadastro</h1>
            <Link to="/">Home</Link>
            <br/>
            <Link to="/calcula">Calcula calda</Link>
            <br/>
            <Link to="/plantas">Planta</Link>
        </div>
    )
}

export default Cadastro