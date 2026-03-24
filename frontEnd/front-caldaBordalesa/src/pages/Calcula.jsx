import {Link} from "react-router-dom";

function Calcula() {

    return (
        <div>
            <h1>Calcula</h1>
            <Link to="/home">Home</Link>
            <br/>
            <Link to="/plantas">Plantas</Link>
            <br/>
            <Link to="/cadastro">Cadastrar planta</Link>
        </div>
    )

}

export default Calcula;