import {Link} from "react-router-dom";
import {useRef} from "react";
import api from "../../services/api.js"
import './style.css'

// fluxo;
// pego os dados no meu forms e jogo numa variavel
//passo os valores pra minha api pelo o 'current.value'

function Cadastro() {

    const inputName = useRef()
    const inputConcentracaoMax = useRef()
    const inputConcentracaoMin = useRef()
    const inputDescricao = useRef()





    async function cadastroPlanta(e) {
        e.preventDefault();
        try {// o value tem que vir dentro da api
            await api.post("api/cadPlanta", {
                nome: inputName.current.value,
                concentracaoMax: inputConcentracaoMax.current.value,
                concentracaoMin: inputConcentracaoMin.current.value,
                descricao: inputDescricao.current.value,
            });

            console.log("Cadastrado com sucesso!");
            alert(`Planta: '${inputName.current.value}' foi cadastrada`)
            e.target.reset();
        } catch (error) {
            console.error("Erro:", error);
        }
    }


    return (
        <div className='container'>
            <h1>Cadastro</h1>
            <Link to="/">Home</Link>
            <br/>
            <Link to="/calcula">Calcula calda</Link>
            <br/>
            <Link to="/plantas">Planta</Link>


            <div className='formulario'>
                <header color='green'>
                    Formulario de cadastro de plantas
                </header>
                <form onSubmit={cadastroPlanta}>
                    <input type="text" placeholder="Nome da planta" ref={inputName}/>
                    <input type="text" placeholder="Concentração maxima" ref={inputConcentracaoMax}/>
                    <input type="text" placeholder="Concentração minima" ref={inputConcentracaoMin}/>
                    <input type="text" placeholder="Descrição" ref={inputDescricao}/>
                    <button type='submit'>Cadastrar</button>
                </form>
            </div>
        </div>


    )
}

export default Cadastro