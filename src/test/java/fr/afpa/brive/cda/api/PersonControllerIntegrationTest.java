package fr.afpa.brive.cda.api;

// Import statique pour construire une requête HTTP GET dans les tests avec MockMvc
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// Import statique pour vérifier le statut de la réponse HTTP dans les tests (ex : 200 OK)
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Import statique pour vérifier le contenu JSON de la réponse via des expressions JSONPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// Import statique pour matcher des valeurs dans les assertions (ex : égal à une valeur donnée)
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;  // Annotation @Test pour marquer une méthode comme test JUnit 5

import org.springframework.beans.factory.annotation.Autowired;  // Pour injecter automatiquement les dépendances (ici MockMvc)

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;  
// Annotation pour configurer automatiquement MockMvc dans le contexte de test Spring Boot

import org.springframework.boot.test.context.SpringBootTest;  
// Annotation qui lance le contexte complet Spring Boot pour les tests d’intégration

import org.springframework.test.web.servlet.MockMvc;  
// Classe principale permettant d’effectuer des requêtes HTTP simulées (GET, POST, etc.) dans les tests

@SpringBootTest  // Démarre le contexte Spring complet pour effectuer des tests d’intégration
@AutoConfigureMockMvc  // Active la configuration automatique de MockMvc pour simuler les requêtes HTTP
public class PersonControllerIntegrationTest {

    @Autowired  // Injection automatique de l’instance MockMvc par Spring
    private MockMvc mockMvc;

    @Test  // Méthode de test exécutée par JUnit
    public void getPersonTest() throws Exception {
        mockMvc.perform(get("/persons"))  // Effectue une requête GET sur /persons
            .andExpect(status().isOk())  // Vérifie que le code de statut HTTP est 200 (OK)
            .andExpect(jsonPath("$[0].firstname", is("jerome")));  // Vérifie que le premier élément JSON a "firstname" = "jero"
    }

}
