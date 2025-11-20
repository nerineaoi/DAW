    alert("JS loaded");
    const botonCarrito = document.getElementById("iniciar-carrito");
    const resultadoDiv = document.getElementById("resultado-carrito");

    function exeCart() {

        let numProd = parseInt(
            prompt("How many products do you want to add to your purchase?")
        );

        if (isNaN(numProd) || numProd <= 0) {
            alert("Please enter a valid number.");
            return;
        }

        let carrito = [];

        for (let i = 0; i < numProd; i++) {

            let nombre = prompt(`Name of product ${i + 1}:`);
            let precio = parseFloat(prompt(`Unit price of "${nombre}":`));
            let cantidad = parseInt(prompt(`Units of "${nombre}":`));

            if (isNaN(precio) || precio < 0) precio = 0;
            if (isNaN(cantidad) || cantidad < 0) cantidad = 0;

            let subtotal = precio * cantidad;

            carrito.push({ nombre, precio, cantidad, subtotal });
        }

        console.log("=== PURCHASE SUMMARY ===");

        let salida = "<h3>Purchase Summary</h3><ul>";
        let totalGeneral = 0;

        for (let p of carrito) {
            console.log(
                `Product: ${p.nombre} | Price: ${p.precio}€ | Quantity: ${p.cantidad} | Subtotal: ${p.subtotal}€`
            );

            salida += `
                <li>
                    <strong>${p.nombre}</strong> — 
                    Price: ${p.precio.toFixed(2)}€ |
                    Quantity: ${p.cantidad} |
                    Subtotal: ${p.subtotal.toFixed(2)}€
                </li>
            `;

            totalGeneral += p.subtotal;
        }

        salida += `</ul>
        <p><strong>Final Total: ${totalGeneral.toFixed(2)}€</strong></p>`;

        resultadoDiv.innerHTML = salida;

        console.log("---------------------------");
        console.log(`FINAL TOTAL: ${totalGeneral}€`);
        console.log("===========================");
    }

    botonCarrito.addEventListener("click", exeCart);