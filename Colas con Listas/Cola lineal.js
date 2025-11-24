// queue_list.js
const readline = require('readline');

function makeInterface() {
  return readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
}

function question(rl, prompt) {
  return new Promise(resolve => rl.question(prompt, ans => resolve(ans.trim())));
}

async function main() {
  const q = []; // usamos arreglo dinámico; push para enqueue, shift para dequeue
  const rl = makeInterface();
  let opcion = "";

  while (opcion !== "4") {
    console.log("\n*************** MENU PRINCIPAL ***************");
    console.log("1. Insertar un elemento");
    console.log("2. Eliminar un elemento");
    console.log("3. Mostrar la cola");
    console.log("4. Salir");
    opcion = await question(rl, "Ingrese su opción: ");

    if (opcion === "1") {
      const elemento = await question(rl, "Ingrese el elemento: ");
      q.push(elemento);
      console.log("Elemento insertado correctamente.");
    } else if (opcion === "2") {
      if (q.length === 0) {
        console.log("SUBDESBORDAMIENTO (UNDERFLOW)");
      } else {
        const elemento = q.shift();
        console.log("Elemento eliminado:", elemento);
      }
    } else if (opcion === "3") {
      if (q.length === 0) {
        console.log("La cola está vacía.");
      } else {
        console.log("Elementos en la cola:");
        q.forEach(el => console.log(el));
      }
    } else if (opcion === "4") {
      console.log("Saliendo del programa...");
    } else {
      console.log("Opción inválida. Intente nuevamente.");
    }
  }

  rl.close();
}

main();
