// Cargar el archivo XML usando fetch
fetch('ldmud3caso1.xml')
    .then(response => {
        if (!response.ok) {
            throw new Error(`Error al cargar el XML: ${response.statusText}`);
        }
        return response.text();
    })
    .then(data => {
        console.log("XML cargado con éxito:");
        console.log(data);

        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(data, 'application/xml');

        const pedido = xmlDoc.querySelector('pedido');
        if (!pedido) {
            console.error("No se encontró el elemento <pedido> en el XML.");
            return;
        }

        const nuevoArticulo = xmlDoc.createElement('articulo');
        nuevoArticulo.setAttribute('tipo', 'marcador');
        nuevoArticulo.innerHTML = '<marca>E</marca><cantidad>15</cantidad><color>red</color>'; // Cambié "rojo" por "red"
        pedido.appendChild(nuevoArticulo);

        const articulos = xmlDoc.getElementsByTagName('articulo');
        console.log(`Se encontraron ${articulos.length} artículos.`);

        let html = '<ul>';
        for (let articulo of articulos) {
            const tipo = articulo.getAttribute('tipo') || 'Sin tipo';
            const marca = articulo.getElementsByTagName('marca')[0]?.textContent || 'Sin marca';
            const cantidad = articulo.getElementsByTagName('cantidad')[0]?.textContent || '0';
            let color = articulo.getElementsByTagName('color')[0]?.textContent || 'white';

            // Normalizar nombres de colores para compatibilidad
            const colorMap = {
                'negro': 'black',
                'azul': 'blue',
                'verde': 'green',
                'rojo': 'red'
            };
            color = colorMap[color.toLowerCase()] || color; // Convertir colores en español a inglés para depurar errores

            console.log(`Artículo - Tipo: ${tipo}, Marca: ${marca}, Cantidad: ${cantidad}, Color: ${color}`);

            const textoColor = (color === 'black' || color === 'blue') ? 'white' : 'black';

            html += `<li style="background-color: ${color}; color: ${textoColor}; 
                        padding: 10px; margin: 5px; border: 1px solid black; list-style: none;">
                        <strong>Tipo:</strong> ${tipo} |
                        <strong>Marca:</strong> ${marca} |
                        <strong>Cantidad:</strong> ${cantidad}
                     </li>`;
        }
        html += '</ul>';

        document.getElementById('contenido').innerHTML = html;
    })
    .catch(error => console.error("Error al cargar el XML:", error));

