# Fonctionnement du mini RPG

Ce programme est un miniRPG dont le but est de battre le boss dans la dernière salle.

Pour ce faire vous pouvez faire des combats afin de gagnez de l'argent.

Vous pourrez dépenser cette argent afin de mieux vous équiper avant d'affronter le boss du jeu.

Je vais vous rappelez les rudiments du jeu mais ces dernières seront rappelés à chaque lancement du jeu.

# Déplacement

Afin de vous déplacez vous devez utilisez les touches :

- z pour aller en haut
- q pour aller à gauche
- s pour aller en bas
- d pour aller à droite

Lorsque vous devrez choisir entre plusieurs actions faites le choix à l'aide des chiffres.

# Système de combat

En combat 4 choix s'offre à vous :

- 1. Attaquer : inflige des dégâts à l'ennemi.\nLes dégâts infligés sont égaux à votre attaque moins la défense de l'ennemi. Acheter des armes pour augmenter votre attaque.
- 2. Esquiver : vous avez une chance d'éviter les dégâts de l'ennemi. Cette chance dépend de la classe choisie. Si vous réussissez, vous infligez des dégats supplémentaires à votre prochain coup.
- 3. Se défendre : Vous avez une chance de réduire les dégâts de l'ennemi de 50%. Cette chance dépend de la classe choisie.
- 4. Fuir : vous avez une de chance de fuir le combat. Cette chance dépend de la classe choisie. Si vous réussissez, vous ne gagnez pas d'argent.

# Commande ant :

- Pour générer la javadoc : `ant javadoc`

- Pour nettoyer les dossiers `build` et `doc` : `ant clean`

- Pour lancer le projet sans fichier en entrée : `ant run` ou `ant`

# Javadoc

Pour générer la javadoc, il faut utiliser la commande `ant javadoc`. Cette
commande génère la javadoc dans le dossier `doc`. Il suffit après de lancer le fichier `index.html` pour naviguer dans la documentation du projet.

# Lancement

La commande `ant run` permet de générer les dossier `build`&`doc` qui contiennet respectivement les classes et la javadoc. Elle permet également de compiler et de lancer le projet. L

# Si ant ne fonctionne pas/ n'est pas installé :

Ces commandes sont celles que j'utilise sur linux et devront peut-être être légeremment changer afin de fonction sur d'autre système d'exploitation.

```
  javac -d build src/miniRPG/*.java src/miniRPG/**/*.java

  java -cp build miniRPG.Game

```
