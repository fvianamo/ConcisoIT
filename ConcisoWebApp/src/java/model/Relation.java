/*
Class that implements the object Relation:
relationID: Integer
routeID: Integer --Refers to table Routes
stopID: Integer --Refers to table Stops
 */
package model;

public class Relation {

    public static int relationID;
    public static int routeID;
    public static int stopID;

    public Relation(int _relationID, int _routeID, int _stopID) {
        relationID = _relationID;
        routeID = _routeID;
        stopID = _stopID;
    }

    public static int getRelationID() {
        return relationID;
    }

    public static void setRelationID(int relationID) {
        Relation.relationID = relationID;
    }

    public static int getRouteID() {
        return routeID;
    }

    public static void setRouteID(int routeID) {
        Relation.routeID = routeID;
    }

    public static int getStopID() {
        return stopID;
    }

    public static void setStopID(int stopID) {
        Relation.stopID = stopID;
    }
    
    
    
}
