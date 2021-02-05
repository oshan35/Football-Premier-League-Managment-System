package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result clubData() {
        JsonNode clubDataJsonNode=Json.toJson(Console.premierLeagueManager.sportsClubArrayList);
        return ok(clubDataJsonNode).as("application/json");
    }

    public Result matchData(){
        JsonNode matchDataJsonNode=Json.toJson(Console.premierLeagueManager.footballMatchArrayList);
        return ok(matchDataJsonNode).as("application/json");
    }

    public Result getRandomMatch(){
        JsonNode RandomMatchJsonNode=Json.toJson(Console.premierLeagueManager.randomMatch());
        return ok(RandomMatchJsonNode).as("application/json");
    }

}
