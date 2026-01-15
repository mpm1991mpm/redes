import axios from 'axios';

// Creamos la conexión con el servidor de tu amigo (Spring Boot suele usar el puerto 8080)
const apiClient = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json'
  }
});

export default {
  // --- FUNCIONES PARA EL DASHBOARD ---
  
  // Obtener el historial de escaneos
  getHistorial() {
    return apiClient.get('/registros-redes');
  },

  // --- FUNCIONES PARA ADMINISTRACIÓN ---

  // Guardar una nueva red WiFi para auditar
  registrarRed(red) {
    // red tiene que ser un objeto con: { ssid: "...", password: "...", seguridad: "..." }
    return apiClient.post('/configuracion-redes', red);
  },

  // Ver qué redes están configuradas actualmente
  getRedesConfiguradas() {
    return apiClient.get('/configuracion-redes');
  }
};