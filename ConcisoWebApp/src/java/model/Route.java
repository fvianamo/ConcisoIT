/*
Class that implements the object Route:
routeID: integer
name: String
 */
package model;

/**
 *
 * @author fvianamo
 */
public class Route {
    public static int routeID;
    public static String name;

    public Route(int _routeID, String _name) {
        routeID = _routeID;
        name = _name;
    }

    public static int getRouteID() {
        return routeID;
    }

    public static void setRouteID(int routeID) {
        Route.routeID = routeID;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Route.name = name;
    }
    
}
