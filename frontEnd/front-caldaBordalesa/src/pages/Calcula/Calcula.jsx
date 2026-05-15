import {Link} from "react-router-dom";
import {useEffect, useRef, useState} from "react";
import api from "../../services/api.js";
import './style.css';

function Calcula() {
    /**
     * FLUXO DA APLICAÇÃO:
     * 1. Captura os dados do formulário através de refs e states
     * 2. Envia esses dados para a API através do método current.value do useRef
     * 3. Retorna o resultado do cálculo da calda bordalesa
     */

        // Referência ao input de volume - useRef permite acessar diretamente o valor do input DOM
        // sem precisar re-renderizar o componente a cada mudança
    const volumeRef = useRef(null);

    // Estado para armazenar o tipo de concentração selecionado (0 = mínima, 1 = máxima)
    // useState permite que essa variável seja reativa e cause re-render quando alterada
    const [tipo, setTipo] = useState(null);

    // Estado que armazena todas as plantas disponíveis vindas da API
    const [plantas, setPlantas] = useState([]);

    // Estado que armazena o ID da planta selecionada pelo usuário no select
    const [plantaSelect, setplantaSelect] = useState('');

    //estado que vai guardar a resposta do calculo da API
    const [resposta, setResposta] = useState(null);

    /**
     * useEffect - Hook de efeito colateral do React
     * Executa código quando o componente é montado ou quando dependências mudam
     *
     * Neste caso:
     * - Array de dependências vazio [] = executa apenas uma vez quando o componente monta
     * - Busca todas as plantas disponíveis da API
     * - Armazena as plantas no estado para popular o select do formulário
     */
    useEffect(() => {
        async function carregaPlantas() {
            const plantasnew = await api.get('api/allPlantas');
            setPlantas(plantasnew.data);
        }

        carregaPlantas();
    }, []);


    /**
     * Função assíncrona que processa o cálculo da calda bordalesa
     *
     * @param {Event} e - Evento de submit do formulário
     *
     * Passos:
     * 1. Previne o comportamento padrão do form (recarregar a página)
     * 2. Coleta os dados do formulário (volume, tipo de concentração e planta)
     * 3. Envia uma requisição POST para a API com os dados
     * 4. volumeRef.current.value - acessa o valor atual do input através da ref
     * 5. Converte os valores para Number para garantir tipo correto na API
     */
    async function calculaCalda(e) {
        e.preventDefault();
        //console.log({ volumeRef, tipo, plantaSelect });

        const response = await api.post('api/calcularCalda', {
            tipoConcentracao: tipo,
            volumeTotal: Number(volumeRef.current.value),
            idPlanta: Number(plantaSelect)
        });

        const resposta = response.data;
        // preciso acessar a 'data' dentro do meu dom para ter acesso a minha classe DTO


        // agora eu crio um estado pra arazenar o resultado do calculo,
        console.log(resposta);
        setResposta(resposta);


    }

    return (
        <div className='container'>
            <div>
                <h1>Calcula</h1>
                <Link to="/">Home</Link>
                <br/>
                <Link to="/plantas">Plantas</Link>
                <br/>
                <Link to="/cadastro">Cadastrar planta</Link>
            </div>

            <div className='formulario'>
                <form onSubmit={calculaCalda}>
                    <input
                        type='text'
                        placeholder='volumo desejato a ser feito'
                        ref={volumeRef}
                    />

                    <fieldset>
                        <legend>Tipo de concentração</legend>
                        <button
                            type='button'
                            onClick={() => setTipo(1)}
                            style={{background: tipo === 1 ? '#ccc' : ''}}
                        >
                            Concentração máxima
                        </button>

                        <button
                            type='button'
                            onClick={() => setTipo(0)}
                            style={{background: tipo === 0 ? '#ccc' : ''}}
                        >
                            Concentração mínima
                        </button>
                    </fieldset>

                    <select
                        value={plantaSelect}
                        onChange={(e) => setplantaSelect(e.target.value)}
                    >
                        <option value=''>selecione uma planta</option>
                        {plantas.map((planta) => (
                            <option key={planta.id} value={planta.id}>
                                {planta.nome}
                            </option>
                        ))}
                    </select>

                    <button type='submit' id='butao-submit'>Calcular calda</button>
                </form>
            </div>
            {/*so vai renderizar se a resposta for diferente de null*/}
            {resposta && (
                <div className='resposta'>
                    <h2>resposta do Cálculo</h2>

                    <div className='resposta-item'>
                        <span className='label'>Volume de agua:</span>
                        <span className='valor'>{resposta.agua} ml</span>
                    </div>

                    <div className='resposta-item'>
                        <span className='label'>volume de reagente:</span>
                        <span className='valor'>{resposta.reagente} ml</span>
                    </div>
                </div>
            )}

        </div>
    );
}

export default Calcula;