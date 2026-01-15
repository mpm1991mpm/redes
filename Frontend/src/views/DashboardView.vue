<template>
  <div class="container">
    <h1>📡 Monitorización de Redes</h1>
    
    <div class="controls">
      <button @click="cargarDatos" class="btn-refresh">🔄 Actualizar ahora</button>
      <p>Última actualización: {{ ultimaActualizacion }}</p>
    </div>

    <table class="data-table">
      <thead>
        <tr>
          <th>Red (SSID)</th>
          <th>Estado</th>
          <th>Fecha Reporte</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="registro in historial" :key="registro.id">
          <td><strong>{{ registro.ssid }}</strong></td>
          
          <td :class="getEstadoClass(registro.estado)">
            {{ registro.estado }}
          </td>
          
          <td>{{ formatearFecha(registro.fecha_reporte) }}</td>
        </tr>
        <tr v-if="historial.length === 0">
          <td colspan="3">No hay registros aún.</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import api from '../services/api';

export default {
  data() {
    return {
      historial: [],
      ultimaActualizacion: '-'
    };
  },
  methods: {
    async cargarDatos() {
      try {
        const response = await api.getHistorial();
        this.historial = response.data;
        this.ultimaActualizacion = new Date().toLocaleTimeString();
      } catch (error) {
        console.error("Error cargando historial:", error);
        alert("Error conectando con el Backend. ¿Está encendido?");
      }
    },
    getEstadoClass(estado) {
      // Devuelve la clase CSS según el texto del estado
      if (estado === 'Conectado') return 'status-ok';
      if (estado === 'Fallo de Auth') return 'status-warn';
      return 'status-error';
    },
    formatearFecha(fecha) {
      if (!fecha) return '-';
      return new Date(fecha).toLocaleString();
    }
  },
  mounted() {
    this.cargarDatos();
    // Refresco automático cada 20 segundos
    setInterval(this.cargarDatos, 20000);
  }
};
</script>

<style scoped>
    h1 {
    color: #2c3e50; 
    text-align: center;
    }
    .container { 
      padding: 20px; 
      max-width: 800px; 
      margin: 0 auto; 
    }
    .controls { 
      display: flex; 
      justify-content: space-between; 
      align-items: center; 
      margin-bottom: 20px; 
    }
    .btn-refresh { 
      background-color: #42b983; 
      color: white; 
      border: none; 
      padding: 10px 20px; 
      cursor: pointer; 
      border-radius: 5px;
    }

    /* Estilos de la tabla */
    .data-table { 
      width: 100%; 
      border-collapse: 
      collapse; 
      margin-top: 10px; 
    }
    .data-table th, .data-table td { 
      border: 1px solid #ddd; 
      padding: 12px; 
      text-align: left; }
    .data-table th { 
      background-color: #f2f2f2; 
    }

    /* Colores de estado */
    .status-ok { 
      color: green; 
      font-weight: bold; 
      background-color: #e6fffa; 
    }
    .status-warn { 
      color: orange; 
      font-weight: bold; 
      background-color: #fffaf0; 
    }
    .status-error { 
      color: red; 
      font-weight: bold; 
      background-color: #fff5f5; 
    }
</style>