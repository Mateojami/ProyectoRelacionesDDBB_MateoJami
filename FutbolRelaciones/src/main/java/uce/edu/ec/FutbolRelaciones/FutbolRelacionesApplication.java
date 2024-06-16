package uce.edu.ec.FutbolRelaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;
import uce.edu.ec.FutbolRelaciones.clases.Game;
import uce.edu.ec.FutbolRelaciones.clases.Manager;
import uce.edu.ec.FutbolRelaciones.clases.Players;
import uce.edu.ec.FutbolRelaciones.clases.Team;
import uce.edu.ec.FutbolRelaciones.repository.GameRepository;
import uce.edu.ec.FutbolRelaciones.repository.ManagerRepository;
import uce.edu.ec.FutbolRelaciones.repository.PlayersRepository;
import uce.edu.ec.FutbolRelaciones.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FutbolRelacionesApplication implements CommandLineRunner {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private PlayersRepository playersRepository;

	@Autowired
	private GameRepository gameRepository;

	public static void main(String[] args) {
		SpringApplication.run(FutbolRelacionesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// Crear y guardar un Manager
		Manager manager1 = new Manager();
		manager1.setNombre("Hansi Flick");
		managerRepository.save(manager1);

		// Crear y guardar un Team
		Team team1 = new Team();
		team1.setNombre("FC Barcelona");
		team1.setManager(manager1);
		manager1.setTeam(team1);
		teamRepository.save(team1);

		// Crear y guardar jugadores para el equipo
		Players player1 = new Players();
		player1.setNombre("Lamine Yamal");
		player1.setTeam(team1);
		playersRepository.save(player1);

		Players player2 = new Players();
		player2.setNombre("Ronald Araujo");
		player2.setTeam(team1);
		playersRepository.save(player2);

		// Asignar jugadores
		List<Players> barcelonaPlayers = new ArrayList<>();
		barcelonaPlayers.add(player1);
		barcelonaPlayers.add(player2);
		team1.setPlayers(barcelonaPlayers);
		teamRepository.save(team1);

		// Crear y guardar otro Manager
		Manager manager2 = new Manager();
		manager2.setNombre("Carlo Anceloti");
		managerRepository.save(manager2);

		// Crear y guardar otro equipo
		Team team2 = new Team();
		team2.setNombre("Real Madrid");
		team2.setManager(manager2);
		manager2.setTeam(team2);
		teamRepository.save(team2);

		// Crear y guardar jugadores
		Players player3 = new Players();
		player3.setNombre("Vinicius Jr");
		player3.setTeam(team2);
		playersRepository.save(player3);

		Players player4 = new Players();
		player4.setNombre("Luka Modric");
		player4.setTeam(team2);
		playersRepository.save(player4);

		// Asignar jugadores
		List<Players> madridPlayers = new ArrayList<>();
		madridPlayers.add(player3);
		madridPlayers.add(player4);
		team2.setPlayers(madridPlayers);
		teamRepository.save(team2);

		// Crear y guardar un Game
		Game game1 = new Game();
		game1.setFecha("2024-06-14");
		List<Team> teams = new ArrayList<>();
		teams.add(team1);
		teams.add(team2);
		game1.setTeams(teams);
		gameRepository.save(game1);


		List<Game> gamesTeam1 = new ArrayList<>();
		gamesTeam1.add(game1);
		team1.setGames(gamesTeam1);
		teamRepository.save(team1);

		List<Game> gamesTeam2 = new ArrayList<>();
		gamesTeam2.add(game1);
		team2.setGames(gamesTeam2);
		teamRepository.save(team2);


		// ----------- Lectura de todo -------------
		List<Team> equipos = teamRepository.findAll();
		for (Team equipo : equipos) {
			System.out.println("Equipo: " + equipo.getNombre());

			// Mostrar manager
			Manager manager = equipo.getManager();
			if (manager != null) {
				System.out.println(" - Manager: " + manager.getNombre());
			}

			// Mostrar jugadores del equipo
			List<Players> jugadores = equipo.getPlayers();
			if (!jugadores.isEmpty()) {
				System.out.println(" - Jugadores:");
				for (Players jugador : jugadores) {
					System.out.println("   - " + jugador.getNombre());
				}
			}

			// Mostrar juegos en los que participa el equipo
			List<Game> juegos = equipo.getGames();
			if (juegos != null && !juegos.isEmpty()) {
				System.out.println(" - Juega en los siguientes dias:");
				for (Game juego : juegos) {
					System.out.println("   - Fecha del juego: " + juego.getFecha());
				}
			} else {
				System.out.println(" - No participa en ningún juego.");
			}

			System.out.println();
		}
	}
}
