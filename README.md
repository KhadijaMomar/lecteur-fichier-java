# 📂 Projet File Reader (Java)

## 🌟 Introduction

Ce projet implémente un système de lecture de fichiers orienté objet en Java, basé sur le design pattern **Interface/Classe Abstraite/Héritage**. Il permet de lire différents types de fichiers et d'effectuer des manipulations spécifiques sur les fichiers texte.

## 🚀 Fonctionnalités Clés

Le projet respecte les spécifications suivantes :

- **Interface Modulaire (`IFileReader`)** : Définit le contrat pour tout lecteur de fichiers.
- **Classe Abstraite (`AbstractFileReader`)** : Centralise les fonctionnalités génériques (lecture standard, affichage simple, comparaison de fichiers).
- **Extensibilité** : Utilisation de sous-classes pour différents formats (`TextFileReader`, `CsvFileReader`, `JsonFileReader`).
- **Manipulations de Texte Uniques (`TextFileReader`)** :
    1. Affichage du contenu à l'endroit (Ligne par Ligne).
    2. Affichage des lignes à l'envers.
    3. Affichage du contenu sous forme **palindromique** (caractère par caractère inversé).
- **Comparaison de Fichiers** : Méthode permettant de comparer le contenu textuel de deux fichiers.

## 📐 Structure du Projet (Orientée Objet)

Le code est structuré en plusieurs classes pour garantir la modularité et la séparation des responsabilités.

| Élément | Description | Rôle Principal |
| :--- | :--- | :--- |
| `IFileReader` | **Interface** | Contrat de base (méthodes `readFileContent()`, `displayContent()`, `processFile()`). |
| `AbstractFileReader` | **Classe Abstraite** | Implémente la lecture de base (`readFileContent`), l'affichage standard (`displayContent`) et la comparaison (`compareFiles`). |
| `TextFileReader` | **Sous-classe** | Implémente les méthodes d'affichage spécialisées (inversé par ligne, palindromique). |
| `CsvFileReader` | **Sous-classe** | Exemple d'extension pour les fichiers CSV  |
| `JsonFileReader` | **Sous-classe** | Exemple d'extension pour les fichiers JSON  |
| `FileReaderApp` | **Classe Main** | Point d'entrée du programme, contient la méthode `main` pour la démonstration. |
