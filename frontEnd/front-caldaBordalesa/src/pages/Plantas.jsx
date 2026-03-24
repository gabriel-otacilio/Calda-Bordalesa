import {Link} from "react-router-dom";

function Plantas() {
    return (
        <div>
            <h1>Plantas</h1>
            <Link to="/home">Home</Link>
            <br/>
            <Link to="/calcula">Calcula calda</Link>
            <br/>
            <Link to="/cadastro">Cadastrar planta</Link>
        </div>
    )


}

export default Plantas