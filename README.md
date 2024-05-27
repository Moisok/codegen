INTRUCCIONES DE USO
La api recibe parametros tipo clave:valor en formato JSON a traves del metodo "POST", puede recibir hasta 4 datos (de momento), posteriormente devuelve una cadena de texto en Base64 la que cual podras convertir a una imagen PNG 

A continuacion se mostrara un ejemplo sencillo de como debe de quedar a la hora de enviar los datos

```
  {dato1: "ejemplo",
   dato2: "ejemplo2",
   dato3: "ejemplo2,
   dato4: "ejemplo4" }
```

Actualmente la api se encuentra alojada en la siguiente direccion:
https://codegen-vmyx.onrender.com

Las llamadas son las siguientes:

1: Codigo QR
``
https://codegen-vmyx.onrender.com/generarcodigo/qr
``

2: Codigo de barras
``
https://codegen-vmyx.onrender.com/generarcodigo/barcode
``


3: Codigo aztec
``
https://codegen-vmyx.onrender.com/generarcodigo/aztec
``


4: Codigo CODE_MATRIX
``
https://codegen-vmyx.onrender.com/generarcodigo/matrix
``

A continuacion, un ejemplo sencillo para una vista HTML con javascript
````
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QR Code Generator</title>
</head>
<body>
    <h1>Generar Código QR</h1>
    <form id="qrForm">
        <label for="dato1">Dato 1:</label>
        <input type="text" id="dato1" name="dato1" required><br><br>
        <label for="dato2">Dato 2:</label>
        <input type="text" id="dato2" name="dato2"><br><br>
        <label for="dato3">Dato 3:</label>
        <input type="text" id="dato3" name="dato3"><br><br>
        <label for="dato4">Dato 4:</label>
        <input type="text" id="dato4" name="dato4"><br><br>
        <button type="submit">Generar QR</button>
    </form>

    <div id="qrCodeContainer"></div>

    <script>
        document.getElementById('qrForm').addEventListener('submit', function(event) {
            event.preventDefault();

            const dato1 = document.getElementById('dato1').value;
            const dato2 = document.getElementById('dato2').value;
            const dato3 = document.getElementById('dato3').value;
            const dato4 = document.getElementById('dato4').value;

            fetch('https://codegen-vmyx.onrender.com/generarcodigo/qr', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    dato1: dato1,
                    dato2: dato2,
                    dato3: dato3,
                    dato4: dato4
                })
            })
            .then(response => response.text())
            .then(data => {
                console.log(data);
                if (data.startsWith('data:image/png;base64,')) {
                    document.getElementById('qrCodeContainer').innerHTML = `<img src="${data}" alt="QR Code">`;
                } else {
                    console.error('La respuesta no contiene una imagen válida');
                    document.getElementById('qrCodeContainer').innerText = 'La respuesta no contiene una imagen válida';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('qrCodeContainer').innerText = 'Error fetching QR code';
            });
        });
    </script>
</body>
</html>
````
