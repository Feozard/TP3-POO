# TP3-POO  

## Étape 5

### Spring Web  
Spring Web est utilisé pour gérer les requêtes web.  
  
  
### Spring Data JPA  
Spring Data JPA est utilisé pour faciliter l'utilisation de différents système de stockage de données.  
  
  
### Validation  
Validation s'utilise pour valider des objets, en retournant des erreurs s'il y en a.  
  
  
### H2 Database  
H2 Database permet d'avoir un système de stockage dans le projet.  
  
  
### Spring Boot DevTools  
Spring Boot DevTools est là pour faciliter le processus de programmation.  
  
  
### Thymeleaf  
Thymeleaf permet de générer de l'HTML avec un projet Java.

## Étape 13 - Questions

1. Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?
2. Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
3. Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?

```Java
@Controller
public class HelloWorldController {
    @GetMapping("/greeting") // Paramétrage de l'url d'appel (Q1)
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String 
                                   name, Model model) {  // On utilise @RequestParam pour envoyer le nom (Q3)
        model.addAttribute("nomTemplate", name); // Sélection du fichier HTML à afficher (Q2)
        return "greeting";
    }
}
```

## Étape 17

Après avoir rajouté la classe *Address*, on la voit apparaitre en tant que table dans notre base de données  
avec ces attributs comme éléments de la table.

## Étape 18

Hibernate est un framework qui permet de transformer des classes Java en des tables de bases de données. 
La dépendance Hibernate de Spring de notre projet a donc permis la transformation de la classe *Address*
en table dans notre base de données.

## Étape 20
Après avoir relancé l'application avec *data.sql* de rajouter, on peut voir les informations saisies dans la table.
