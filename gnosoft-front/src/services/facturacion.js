const baseUrl = 'http://localhost:8081/facturacion/'

export const obtenerFacturacion = async () => {
    const response = await fetch(`${baseUrl}list`)
    return await response.json()
}

export const guardarFacturacion = async (facturacion) => {
    const response = await fetch(baseUrl, { body: JSON.stringify(facturacion), method: "POST", headers: { "Content-Type": "application/json" } });
    return await response.json()
  }

export const actualizarFacturacion = async (facturacion) => {
    const response = await fetch(baseUrl, { body: JSON.stringify(facturacion), method: "PUT", headers: { "Content-Type": "application/json" } });
    return await response.json()
   }

export  const eliminarFacturacion = async (idFactura) => {
    const response = await fetch(`${baseUrl}${idFactura}`, { method: "DELETE", headers: { "Content-Type": "application/json" } });
    return await response.text()
  }