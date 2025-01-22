package hello.core;

import hello.core.common.FootballTeam;
import hello.core.common.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerApp {

  @GetMapping("/player")
  public Player getOnePlayer() {
    return new Player("chan", 28);
  }

  @GetMapping("/players")
  public ResponseEntity<List<Player>> getAllPlayer() {
    Player player1 = new Player("chan", 28);
    Player player2 = new Player("kim", 27);
    Player player3 = new Player("young", 26);

    ArrayList<Player> list = new ArrayList<>();
    list.add(player1);
    list.add(player2);
    list.add(player3);

    boolean isCreated = list.contains(player3);

    return ResponseEntity.status(isCreated ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(list);
  }

  @GetMapping("/team")
  public ResponseEntity<FootballTeam> getOneTeam() {
    Player player1 = new Player("Son Heungmin", 7 );
    Player player2 = new Player("Harry Kane", 10);
    Player player3 = new Player("Hugo Lloris", 1);

    ArrayList<Player> players = new ArrayList<>();
    players.add(player1);
    players.add(player2);
    players.add(player3);

    FootballTeam team = new FootballTeam("Tottenham", "Premier League", 5, players);

    return ResponseEntity.ok(team);
  }

  @WebServlet(urlPatterns = "/hello")
  public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
  }

}

//@Controller
//public class PlayerApp {
//
//  @GetMapping("/player")
//  @ResponseBody
//  public Player getOnePlayer() {
//    return new Player("chan", 28);
//  }
//
//  @GetMapping("/players")
//  @ResponseBody
//  public List<Player> getAllPlayer() {
//    Player player1 = new Player("chan", 28);
//    Player player2 = new Player("kim", 27);
//    Player player3 = new Player("young", 26);
//
//    ArrayList<Player> list = new ArrayList<>();
//    list.add(player1);
//    list.add(player2);
//    list.add(player3);
//
//    return list;
//  }
//
//  @GetMapping("/team")
//  @ResponseBody
//  public FootballTeam getOneTeam() {
//    Player player1 = new Player("Son Heungmin", 7 );
//    Player player2 = new Player("Harry Kane", 10);
//    Player player3 = new Player("Hugo Lloris", 1);
//
//    ArrayList<Player> players = new ArrayList<>();
//    players.add(player1);
//    players.add(player2);
//    players.add(player3);
//
//    return new FootballTeam("Tottenham", "Premier League", 5, players);
//  }
//
//}
