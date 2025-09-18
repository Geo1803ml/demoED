
const readline = require("readline");

const COLS = 7, ROWS = 6;
let grid = Array.from({ length: ROWS }, () => Array(COLS).fill(0));
let current = 1; // 1 = jugador rojo, 2 = jugador amarillo

// Crear interfaz de entrada
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Mostrar tablero
function printBoard() {
  console.clear();
  console.log("Conecta 4 — Jugador 1 = X (Rojo), Jugador 2 = O (Amarillo)\n");
  for (let r = 0; r < ROWS; r++) {
    let row = "|";
    for (let c = 0; c < COLS; c++) {
      row += grid[r][c] === 0 ? "   |" : (grid[r][c] === 1 ? " X |" : " O |");
    }
    console.log(row);
  }
  console.log("  1   2   3   4   5   6   7"); // números de columnas
}

// Colocar ficha en columna
function dropInColumn(col) {
  for (let r = ROWS - 1; r >= 0; r--) {
    if (grid[r][col] === 0) {
      grid[r][col] = current;
      return r; // fila donde cayó
    }
  }
  return -1; // columna llena
}

// Verificar victoria
function checkWin(r0, c0, player) {
  const dirs = [[0,1],[1,0],[1,1],[1,-1]];
  for (const [dr,dc] of dirs) {
    let count = 1;
    let r = r0+dr, c = c0+dc;
    while (inBounds(r,c) && grid[r][c]===player) { count++; r+=dr; c+=dc; }
    r = r0-dr; c = c0-dc;
    while (inBounds(r,c) && grid[r][c]===player) { count++; r-=dr; c-=dc; }
    if (count >= 4) return true;
  }
  return false;
}

function inBounds(r,c){ return r>=0 && r<ROWS && c>=0 && c<COLS; }

function isFull() {
  return grid.every(row => row.every(cell => cell !== 0));
}

// Bucle de juego
function turn() {
  printBoard();
  rl.question(`Jugador ${current} (${current===1?'X':'O'}), elige columna (1-7): `, input => {
    const col = parseInt(input)-1;
    if (isNaN(col) || col < 0 || col >= COLS) {
      console.log("Columna inválida.");
      return turn();
    }
    const row = dropInColumn(col);
    if (row === -1) {
      console.log("Columna llena, elige otra.");
      return turn();
    }
    if (checkWin(row,col,current)) {
      printBoard();
      console.log(`¡¡Jugador ${current} gana!!`);
      return rl.close();
    }
    if (isFull()) {
      printBoard();
      console.log("Empate");
      return rl.close();
    }
    current = current===1 ? 2 : 1;
    turn();
  });
}

// Iniciar
turn();