# API Spring Boot

Ce projet est une API REST développée en **Spring Boot**.

## Table des matières

- [Fonctionnalités](#fonctionnalités)  
- [Technologies utilisées](#technologies-utilisées)  
- [Installation et configuration](#installation-et-configuration)  
- [Usage / Exécution](#usage--exécution)  
- [Endpoints](#endpoints)  
- [Tests](#tests)  
- [Contribuer](#contribuer)  
- [Licence](#licence)  

---

## Fonctionnalités

Voici les principales fonctionnalités offertes par cette API :

- CRUD (Create, Read, Update, Delete) sur les entités métiers  
- Validation des entrées (ex. via `@Valid`)  
- Gestion des erreurs centralisée  
- Possibilité d’extension (ajout de nouveaux endpoints, filtres, sécurité, etc.)  
- Configuration via profiles (par exemple `application-dev.yml`, `application-prod.yml`)  

> **Note** : ajoute ici les spécificités de ton API (authentification, pagination, tri, filtres, etc.)

---

## Technologies utilisées

- Java 11+ (ou version que tu utilises)  
- Spring Boot  
- Spring Web (Spring MVC / REST)  
- Spring Data JPA  
- Base de données (MySQL)  
- Maven 
- Autres librairies : (Lister les dépendances importantes que tu utilises)  

---

## Installation et configuration

1. Clone le dépôt  
   ```bash
   git clone https://github.com/stephane-pontonnier/api.git
   cd api
2. Configuration de la base de données
   - Modifier le fichier src/main/resources/application.yml ou application.properties avec tes paramètres (url, utilisateur, mot de passe)
   - Optionnel : utiliser un profile dev ou prod
3. (Facultatif) Générer la base de données si tu utilises des scripts SQL ou des migrations (Flyway, Liquibase, etc.)
4. Compilation
 ```bash
   mvn clean install
