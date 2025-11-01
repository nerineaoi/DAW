// Cargar libreria.xml y pintar categorías + libros como enlaces a libro.html?titulo=...
(async () => {
  const contenedor = document.getElementById('contenido');

  try {
    const textoXML = await fetch('libreria.xml').then(r => {
      if (!r.ok) throw new Error('No se pudo cargar libreria.xml');
      return r.text();
    });

    const xml = new DOMParser().parseFromString(textoXML, 'application/xml');
    if (xml.querySelector('parsererror')) {
      throw new Error('Error al parsear libreria.xml');
    }

    contenedor.innerHTML = '';
    const categorias = Array.from(xml.getElementsByTagName('categoria'));

    categorias.forEach(cat => {
      const nombre = cat.getAttribute('nombre') || 'Sin categoría';

      const bloque = document.createElement('div');
      bloque.className = 'categoria';
      bloque.innerHTML = `<h2>${nombre}</h2>`;

      const grid = document.createElement('div');
      grid.className = 'grid';

      const libros = Array.from(cat.getElementsByTagName('libro'));
      libros.forEach(libro => {
        const titulo = libro.getAttribute('titulo') || 'Título desconocido';
        const enlace = `libro.html?titulo=${encodeURIComponent(titulo)}`;

        const tarjeta = document.createElement('div');
        tarjeta.className = 'card';
        tarjeta.innerHTML = `<a href="${enlace}">${titulo}</a>`;

        grid.appendChild(tarjeta);
      });

      bloque.appendChild(grid);
      contenedor.appendChild(bloque);
    });

  } catch (e) {
    console.error(e);
    contenedor.innerHTML = `<p style="color:#b00">⚠️ ${e.message}</p>`;
  }
})();
