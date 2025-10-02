package fr.afpa.brive.cda.api;

// Importations statiques nécessaires pour simuler les requêtes HTTP et vérifier les réponses
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;                        // Pour écrire les tests avec JUnit 5
import org.springframework.beans.factory.annotation.Autowired; // Pour injecter les dépendances automatiquement
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; // Pour tester uniquement le Controller (MVC)
import org.springframework.test.context.bean.override.mockito.MockitoBean; // Pour créer des mocks des beans Spring dans les tests
import org.springframework.test.web.servlet.MockMvc;         // Pour simuler des appels HTTP sur le controller

import fr.afpa.brive.cda.api.controller.PersonController;    // Controller à tester
import fr.afpa.brive.cda.api.service.PersonService;          // Service utilisé par le controller (mocké ici)


// Annotation pour lancer un test MVC limité au controller PersonController
@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    // Injection automatique de MockMvc, qui simule les requêtes HTTP vers le controller
    @Autowired
    private MockMvc mockMvc;

    // Création d'un mock (factice) du service PersonService,
    // ce qui évite de faire appel à la vraie couche métier / base de données dans ce test
    @MockitoBean
    private PersonService personService;

    // Méthode de test qui vérifie que la requête GET sur "/persons" retourne un statut HTTP 200 (OK)
    @Test
    public void getPersontest() throws Exception {
        mockMvc.perform(get("/persons"))          // Simule un GET HTTP sur "/persons"
               .andExpect(status().isOk());      // Vérifie que la réponse a un statut HTTP 200 OK
    }
}
