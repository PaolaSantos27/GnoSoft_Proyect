const baseUrl = 'http://localhost:8081/facturaDatos/'

export const obtenerFacturaDatos = async () => {
    const response = await fetch(`${baseUrl}list`)
    return await response.json()
}

export const guardarFacturaDatos = async (facturaDatos) => {
    const response = await fetch(baseUrl, { body: JSON.stringify(facturaDatos), method: "POST", headers: { "Content-Type": "application/json" } });
    return await response.json()
  }

export const actualizarFacturaDatos = async (facturaDatos) => {
    const response = await fetch(baseUrl, { body: JSON.stringify(facturaDatos), method: "PUT", headers: { "Content-Type": "application/json" } });
    return await response.json()
   }

export  const eliminarFacturaDatos = async (idDato) => {
    const response = await fetch(`${baseUrl}${idDato}`, { method: "DELETE", headers: { "Content-Type": "application/json" } });
    return await response.text()
  }