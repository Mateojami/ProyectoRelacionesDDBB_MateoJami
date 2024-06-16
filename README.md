FutbolRelaciones
Este proyecto es una aplicación de gestión de equipos de fútbol desarrollada en Java, utilizando Spring Boot y JPA (Jakarta Persistence API). 
Permite gestionar entidades como equipos, managers, jugadores y juegos, manteniendo las relaciones entre ellos.

Descripción del Proyecto
El objetivo principal de esta aplicación es demostrar el uso de relaciones entre entidades en una base de datos relacional mediante JPA. La aplicación gestiona las siguientes entidades:
Game: Representa un juego de fútbol, incluyendo la fecha del juego y una lista de equipos que participan en el mismo.
Manager: Representa el manager de un equipo de fútbol, con una relación uno a uno con el equipo que gestiona.
Player: Representa un jugador de fútbol, con una relación muchos a uno con el equipo al que pertenece.
Team: Representa un equipo de fútbol, con relaciones uno a uno con un manager, uno a muchos con jugadores y muchos a muchos con juegos.

Funcionalidades
Creación y Gestión de Entidades:
Crear y guardar equipos de fútbol junto con sus managers y jugadores.
Crear y guardar juegos de fútbol con la fecha y los equipos participantes.
Relaciones entre Entidades:
Uno a Uno: Cada equipo tiene un manager, y cada manager está asociado a un equipo.
Uno a Muchos: Un equipo puede tener múltiples jugadores.
Muchos a Muchos: Un juego puede involucrar múltiples equipos y cada equipo puede participar en múltiples juegos.
