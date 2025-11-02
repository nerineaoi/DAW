const $search = document.getElementById('search');
const $buscar = document.getElementById('buscar');
const $ul = document.getElementById('listado');
const $estado = document.getElementById('estado');

async function buscar() {
  $estado.textContent = 'Buscando...';
  $ul.innerHTML = '';
  const term = encodeURIComponent(($search.value || '').trim());
  try {
    const res = await fetch(`../negocio/api.php?search=${term}`);
    if (!res.ok) throw new Error('Error en la API');
    const data = await res.json();
    if (!Array.isArray(data) || data.length === 0) {
      $estado.textContent = 'Sin resultados.';
      return;
    }
    data.forEach(p => {
      const li = document.createElement('li');
      const price = typeof p.price === 'number' ? p.price.toFixed(2) : p.price;
      li.textContent = `${p.name} — ${p.category} — ${price} €`;
      $ul.appendChild(li);
    });
    $estado.textContent = `${data.length} resultado(s).`;
  } catch (e) {
    console.error(e);
    $estado.textContent = 'Ha ocurrido un error consultando la API.';
  }
}

$buscar.addEventListener('click', buscar);
$search.addEventListener('keydown', (e) => { if (e.key === 'Enter') buscar(); });
