# MediaService

MediaService est une application permettant la gestion d'une médiathèque contenant des films, des musiques et des séries 
avec gestion des emprunts.  
Le projet est composé d'une API REST pour les films et séries et d'une API SOAP pour les musiques.

## Lancement du projet

### Base de données

Une base de données mysql est nécessaire dont la configuration est modifiable dans le fichier _hibernate.cfg.xml_.  
Par défaut, le port utilisé est 3306, l'utilisateur est _root_ et le mot de passe _toor_.  

La base mediaservice doit ensuite être créée d'après la requête présente dans le fichier _mediaservice.sql_.

### L'application

Une fois compilée, le jar de l'application doit être lancé à l'aide de java ("_java -jar mediaservice.jar_").  
Les requêtes modifiant des données nécessitent un jeton d'authentification dans le paramètre "token" pour être autorisées. 
Par défaut, celui-ci est "_petitkoala_".

#### REST
Un swagger est visible sur l'adresse _http://localhost:8080/swagger-ui.html_ et présente les différentes requêtes pour interagir avec les films et les séries.  
Les ressources peuvent être utilisées sur les endpoints _http://localhost:8080/movie_ et _http://localhost:8080/tvshow_.

#### SOAP

Les services Soap sont accessibles à l'adresse _http://localhost:8080/ws_. Pour les consommer, vous pouvez utiliser un **client 
Http** ou utiliser **Curl** via la console. Des exemples  **xml** de corps de requête sont disponibles dans le dossier **soapRequest/**.   
_Exemple de requete :_  
```curl --header "content-type: text/xml" -d @getMusics.xml http://localhost:8080/ws```

