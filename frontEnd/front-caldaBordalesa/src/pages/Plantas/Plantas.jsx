import {Link} from "react-router-dom";
import { useState, useEffect } from "react";
import api from "../../services/api";
import "./style.css"

function Plantas() {
    const [plantas, setPlantas] = useState([])

    async function getPlantas() {
        let response = await api.get("/api/allPlantas")
        setPlantas(response.data)// atualizo as minhas plantas com a lista que eu trouxe com o meu get
        // usando o axios a resposta da API vem como um objeto completo ai pra pegar os dados eu uso o .data
    }

    useEffect(()=>// isso executa a chamada quando a pagina recarregar, idela pra gets
    {
        getPlantas();
    },[])

    return (

        <div className="container">

            <h1>Plantas</h1>
            <Link to="/">Home</Link>
            <br/>
            <Link to="/calcula">Calcula calda</Link>
            <br/>
            <Link to="/cadastro">Cadastrar planta</Link>
            <div className="lista-planta">
                {plantas.map((planta) =>
                    (
                        <div key={planta.id}>

                            <p>Nome: {planta.nome}</p>
                            <p>categoria: {planta.descricao}</p>
                            <br/>
                        </div>
//todo colocar icone de lixeira pra apagar a planta
                ))

                }
            </div>
        </div>


    )


}

export default Plantas