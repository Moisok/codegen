INTRUCCIONES DE USO
La api recibe parametro tipo clave:valor en formato JSON a traves del metodo "POST", puede recibir hasta 4 datos (de momento), posteriormente devuelve una cadena de texto en Base64 la que cual podras convertir a una imagen PNG 

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
