// Cargar la ficha del libro seleccionado (?titulo=...) leyendo desde libreria.xml
(async () => {
  const $ = id => document.getElementById(id);

  const params = new URLSearchParams(location.search);
  const tituloBuscado = params.get('titulo') || '';

  if (!tituloBuscado) {
    $('titulo').textContent = 'Sin título en la URL (usa ?titulo=...)';
    return;
  }

  try {
    const textoXML = await fetch('libreria.xml').then(r => {
      if (!r.ok) throw new Error('No se pudo cargar libreria.xml');
      return r.text();
    });

    const xml = new DOMParser().parseFromString(textoXML, 'application/xml');
    if (xml.querySelector('parsererror')) {
      throw new Error('Error al parsear libreria.xml');
    }

    const libros = Array.from(xml.getElementsByTagName('libro'));
    const libro = libros.find(l => (l.getAttribute('titulo') || '') === tituloBuscado);

    if (!libro) {
      $('titulo').textContent = 'Libro no encontrado';
      return;
    }

    // Atributos (con fallback para el typo sinpsis)
    const titulo    = libro.getAttribute('titulo')    || '—';
    const autor     = libro.getAttribute('autor')     || '—';
    const publicado = libro.getAttribute('publicado') || '—';
    const editorial = libro.getAttribute('editorial') || '—';
    const sinopsis  = libro.getAttribute('sinopsis') ?? libro.getAttribute('sinpsis') ?? '—';

    // Imagen: si el XML trae solo el nombre (sin carpeta), prefija img/
    let imagen = (libro.getAttribute('imagen') || '').trim();
    if (imagen && !imagen.includes('/') && !imagen.startsWith('img/')) {
      imagen = `img/${imagen}`;
    }

    // Pintar datos
    $('titulo').textContent      = titulo;
    $('autor').innerHTML         = `<strong>Autor:</strong> ${autor}`;
    $('fecha').innerHTML         = `<strong>Fecha de publicación:</strong> ${publicado}`;
    $('editorial').innerHTML     = `<strong>Editorial:</strong> ${editorial}`;
    $('sinopsis').innerHTML      = `<strong>Sinopsis:</strong> ${sinopsis}`;

    // Cargar portada con pequeño “auto-heal” de extensión
    const imgEl = $('imagen');
    if (imagen) {
      const probarHEAD = async (url) => {
        try { const r = await fetch(url, { method: 'HEAD' }); return r.ok; }
        catch { return false; }
      };

      const abs = new URL(imagen, location.href).href;
      if (await probarHEAD(abs)) {
        imgEl.src = abs;
      } else {
        const base = imagen.replace(/\.(jpg|jpeg|png|webp)$/i, '');
        let encontrada = '';
        for (const ext of ['.jpg', '.jpeg', '.png', '.webp']) {
          const test = new URL(base + ext, location.href).href;
          if (await probarHEAD(test)) { encontrada = test; break; }
        }
        if (encontrada) imgEl.src = encontrada;
        else imgEl.style.display = 'none';
      }
    } else {
      imgEl.style.display = 'none';
    }

  } catch (e) {
    console.error(e);
    $('titulo').textContent = `⚠️ ${e.message}`;
  }
})();
