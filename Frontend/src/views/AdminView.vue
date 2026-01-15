<template>
  <div class="container">
    <h1>⚙️ Administración de Redes</h1>
    
    <div class="card">
      <h2>Añadir Nueva Red Objetivo</h2>
      <form @submit.prevent="guardarRed" class="form-grid">
        <div class="form-group">
          <label>Nombre de Red (SSID):</label>
          <input v-model="nuevaRed.ssid" placeholder="Ej: MiCasa_WiFi" required />
        </div>

        <div class="form-group">
          <label>Contraseña:</label>
          <input v-model="nuevaRed.password" type="text" placeholder="Contraseña de la red" required />
        </div>

        <div class="form-group">
          <label>Seguridad:</label>
          <select v-model="nuevaRed.seguridad">
             <option value="WPA2">WPA2</option>
             <option value="WEP">WEP</option>
             <option value="OPEN">Abierta (Sin clave)</option>
          </select>
        </div>

        <button type="submit" class="btn-save">Guardar Red</button>
      </form>
    </div>

    <div class="list-section">
      <h2>Redes Monitorizadas Actualmente</h2>
      <ul>
        <li v-for="red in redes" :key="red.id">
          <strong>{{ red.ssid }}</strong> <small>({{ red.seguridad }})</small>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import api from '../services/api';

export default {
  data() {
    return {
      redes: [],
      nuevaRed: { ssid: '', password: '', seguridad: 'WPA2' }
    };
  },
  methods: {
    async cargarRedes() {
      try {
        const response = await api.getRedesConfiguradas();
        this.redes = response.data;
      } catch (error) {
        console.error("Error cargando redes:", error);
      }
    },
    async guardarRed() {
      try {
        await api.registrarRed(this.nuevaRed);
        alert('Red guardada correctamente');
        this.nuevaRed = { ssid: '', password: '', seguridad: 'WPA2' }; // Limpiar formulario
        this.cargarRedes(); // Recargar la lista
      } catch (error) {
        console.error(error);
        alert('Error al guardar. Revisa la consola.');
      }
    }
  },
  mounted() {
    this.cargarRedes();
  }
};
</script>

<style scoped>
    h1, h2 {
        color: #2c3e50; 
    }
    .container { 
        padding: 20px; 
        max-width: 600px; 
        margin: 0 auto; 
    }
    .card { 
        background: #f9f9f9; 
        padding: 20px; 
        border-radius: 8px; 
        box-shadow: 0 2px 5px rgba(0,0,0,0.1); 
    }
    .form-group { 
        margin-bottom: 15px; 
    }
    .form-group label { 
        display: block; 
        margin-bottom: 5px; 
        font-weight: bold; 
    }
    .form-group input, .form-group select { 
        width: 100%; 
        padding: 8px; 
        box-sizing: border-box; 
    }
    .btn-save { 
        background-color: #3498db; 
        color: white; border: none; 
        padding: 10px 20px; 
        width: 100%; 
        cursor: pointer; 
        font-size: 16px; 
        border-radius: 5px;
    }
    .btn-save:hover { 
        background-color: #2980b9; 
    }
    .list-section { 
        margin-top: 30px; 
    }
</style>