// Declaracion
int[] numeros = new int[5];
string[] nombres = { "Ana", "Luis", "Pedro" };

numeros[0] = 42;

Console.WriteLine(numeros[0]);

for (int i = 0; i < numeros.Length; i++) {
    Console.WriteLine(numeros[i]);
}
// For-each
foreach (int n in numeros) {
    Console.WriteLine(n);
}