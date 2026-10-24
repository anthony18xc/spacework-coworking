import { useEffect, useState } from 'react'

const API = 'http://localhost:8080/api/espacios'

const TIPOS = {
  COWORKING: 'Coworking',
  OFICINA_PRIVADA: 'Oficina privada',
  SALA_REUNIONES: 'Sala de reuniones',
}

export default function App() {
  const [espacios, setEspacios] = useState([])
  const [tipo, setTipo] = useState('')
  const [error, setError] = useState(null)

  useEffect(() => {
    const url = tipo ? `${API}?tipo=${tipo}` : API
    fetch(url)
      .then((r) => r.json())
      .then(setEspacios)
      .catch(() => setError('No se pudo conectar con el backend (puerto 8080).'))
  }, [tipo])

  return (
    <div className="container">
      <header>
        <h1>SpaceWork</h1>
        <p>El futuro del trabajo comienza aquí. Encuentra tu espacio ideal.</p>
      </header>

      <label className="filtro">
        Tipo de espacio:{' '}
        <select value={tipo} onChange={(e) => setTipo(e.target.value)}>
          <option value="">Todos</option>
          {Object.entries(TIPOS).map(([valor, texto]) => (
            <option key={valor} value={valor}>{texto}</option>
          ))}
        </select>
      </label>

      {error && <p className="error">{error}</p>}

      <section className="grid">
        {espacios.map((e) => (
          <article className="card" key={e.idEspacio}>
            <span className="badge">{e.estado}</span>
            <h2>{e.nombre}</h2>
            <p>{TIPOS[e.tipo] ?? e.tipo}</p>
            <p>Capacidad: {e.capacidad} personas</p>
            <p className="precio">S/ {Number(e.precioHora).toFixed(2)} / hora</p>
            <button disabled={e.estado !== 'DISPONIBLE'}>Reservar</button>
          </article>
        ))}
      </section>
    </div>
  )
}
