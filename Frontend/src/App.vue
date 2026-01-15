<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">📊 Dashboard</RouterLink>
        <RouterLink to="/admin">⚙️ Administración</RouterLink>
      </nav>
    </div>
  </header>

  <main>
    <RouterView />
  </main>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<style>
/* Estilos globales básicos */
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f9;
  color: #2c3e50;
}

header {
  background-color: #2c3e50;
  padding: 1rem;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

nav {
  display: flex;
  gap: 20px;
  justify-content: center;
}

nav a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  font-size: 1.1rem;
  padding: 5px 10px;
  border-radius: 4px;
}

nav a:hover {
  background-color: #3e5871;
}

/* Clase automática que pone Vue al enlace activo */
nav a.router-link-active {
  background-color: #42b983;
  color: white;
}

main {
  padding: 20px;
}
</style>