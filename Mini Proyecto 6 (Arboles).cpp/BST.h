#ifndef BST_H
#define BST_H

#include "Node.h"
#include <iostream>
#include <fstream>
using namespace std;

class BST {
private:
    Node* root;

    // Inserción recursiva
    Node* insert(Node* node, int key) {
        if (!node) return new Node(key);
        if (key < node->key) node->left = insert(node->left, key);
        else if (key > node->key) node->right = insert(node->right, key);
        return node;
    }

    // Búsqueda recursiva con impresión de ruta
    bool search(Node* node, int key) {
        if (!node) return false;
        cout << node->key << " ";
        if (node->key == key) return true;
        if (key < node->key) return search(node->left, key);
        return search(node->right, key);
    }

    // Encontrar el menor de un subárbol
    Node* minNode(Node* node) {
        while (node && node->left) node = node->left;
        return node;
    }

    // Eliminación recursiva
    Node* deleteNode(Node* node, int key) {
        if (!node) return nullptr;

        if (key < node->key) node->left = deleteNode(node->left, key);
        else if (key > node->key) node->right = deleteNode(node->right, key);
        else {
            // Caso 1: sin hijos
            if (!node->left && !node->right) {
                delete node;
                return nullptr;
            }
            // Caso 2: un hijo
            else if (!node->left) {
                Node* aux = node->right;
                delete node;
                return aux;
            }
            else if (!node->right) {
                Node* aux = node->left;
                delete node;
                return aux;
            }
            // Caso 3: dos hijos
            else {
                Node* aux = minNode(node->right);
                node->key = aux->key;
                node->right = deleteNode(node->right, aux->key);
            }
        }
        return node;
    }

    // Recorridos
    void inorder(Node* node) {
        if (!node) return;
        inorder(node->left);
        cout << node->key << " ";
        inorder(node->right);
    }

    void preorder(Node* node) {
        if (!node) return;
        cout << node->key << " ";
        preorder(node->left);
        preorder(node->right);
    }

    void postorder(Node* node) {
        if (!node) return;
        postorder(node->left);
        postorder(node->right);
        cout << node->key << " ";
    }

    // Altura
    int height(Node* node) {
        if (!node) return 0;
        return 1 + max(height(node->left), height(node->right));
    }

    // Tamaño
    int size(Node* node) {
        if (!node) return 0;
        return 1 + size(node->left) + size(node->right);
    }

    // Exportar inorder a archivo
    void writeInorder(Node* node, ofstream& file) {
        if (!node) return;
        writeInorder(node->left, file);
        file << node->key << " ";
        writeInorder(node->right, file);
    }

public:
    BST() : root(nullptr) {}

    void insert(int key) {
        root = insert(root, key);
    }

    void search(int key) {
        cout << "Ruta de busqueda: ";
        if (search(root, key))
            cout << "\nEncontrado.\n";
        else
            cout << "\nNo encontrado.\n";
    }

    void deleteKey(int key) {
        root = deleteNode(root, key);
    }

    void inorder() { inorder(root); cout << "\n"; }
    void preorder() { preorder(root); cout << "\n"; }
    void postorder() { postorder(root); cout << "\n"; }

    int height() { return height(root); }
    int size() { return size(root); }

    void exportInorder(string filename) {
        ofstream file(filename);
        writeInorder(root, file);
        file.close();
        cout << "Archivo '" << filename << "' generado.\n";
    }
};

#endif
