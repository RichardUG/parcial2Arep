package edu.escuelaing.arep;

import org.json.JSONObject;

import java.time.LocalDateTime;

import static spark.Spark.*;
public class App {
    public static funciones funciones = new funciones();
    public static void main(String[] args) {
        port(getPort());
        get("/atan", (req, res) -> {
            Double result = funciones.atan(Double.parseDouble(req.queryParams("value")));
            JSONObject jsonObject = new JSONObject("{\"operation\": \"atan\",\"input\": \""+req.queryParams("value")+"\",\"output\": \""+result+"\"}");
            return jsonObject;
        });
        get("/sqrt", (req, res) -> {
            Double result = funciones.sqrt(Double.parseDouble(req.queryParams("value")));
            JSONObject jsonObject = new JSONObject("{\"operation\": \"sqrt\",\"input\": \""+req.queryParams("value")+"\",\"output\": \""+result+"\"}");
            return jsonObject;
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}