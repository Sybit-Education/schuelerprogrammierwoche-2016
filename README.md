# Sybit Schülerprogrammierwoche 2016

[![Apache License](http://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](LICENSE)
[![Build Status](https://travis-ci.org/Sybit-Education/schuelerprogrammierwoche-2016.svg?branch=develop)](https://travis-ci.org/Sybit-Education/schuelerprogrammierwoche-2016)

**Schülerprogrammierwoche der Firma Sybit im Rahmen des Sommerferienprogramms der Stadt Radolfzell.**

Innerhalb einer Woche programmieren 12 Schüler zusammen mit den Auszubildenden der Firma Sybit eine Taschengeldbörse!


# Taschengeldbörse

Das Projekt umfasst die "Taschengeldbörse". 

Die Taschengeldbörse vermittelt kleine Jobs von Erwachsenen, die im Haus und Garten eine Hilfe möchten.
Wenn ein Schüler Interesse hast und  ab und zu sein Taschengeld aufbessern will, kann er über diese Börse einen job suchen.

# Projekt-Setup

## Notwendige Software
- Datenbank: [MySQL](https://www.mysql.de/)
- Entwicklungsumgebung: [Netbeans](https://netbeans.org/) oder andere IDE mit
  - Java ab JDK 7
  - Maven 3

## Datenbank initial einrichten
Bevor man das Projekt starten kann, muss die Datenbank eingerichtet werden.
Dazu das Script [create-database.sql](src/main/resources/db/migration/create_database.sql) auf der MySQL-Datenbank initial ausführen. Wie das geht, ist in folgendem [Video](https://www.youtube.com/watch?v=eHDz7uWjCyU) beschrieben.
Falls das Projekt bereits schon mal installiert war, muss man beachten, dass die User gelöscht werden bevor man die Datenbank intitial ausführen kann, da es sonst Fehler gibt. 

## Projekt kompilieren
Entweder mit dem Maven-Kommando:
``mvn install``

Oder in Netbeans direkt mit "Run/Build Project" ausführen.

# Taschengeldbörse starten
Wenn es beim Kompilieren zu keinen Fehlern kam, dann kann nun in Netbeans mit "Run/Run Project" die Taschengeldbörse gestartet werden. 
Nach einigen Augenblicken sollte sich der Browser mit folgender URL öffen: [http://localhost:8080/taschengeldboerse](http://localhost:8080/taschengeldboerse)

Initial sind Standard-Benutzer für folgende Benutzergruppen angelegt:

- Benutzer Schüler: schueler/schueler
- Benutzer Anbieter: anbieter/anbieter
- Benutzer Admin: admin/admin

