package com.company;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static final String locationFilePath = "locations.txt";
    private static final String directionFilePath = "directions.txt";

    ////    COMMENT THIS OUT WHEN WE ARE HAVING THE LOCATION DATA STORED ON DISK
    static { // the same data is used across all instance of the class instead of separate copies
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(locationFilePath));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter()); // skips over the delimiter
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + " | description: " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close(); // scanner also closes the file reader streams that it was using
            }
        }

        //        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
//        locations.put(2, new Location(2, "You are at the top of a hill"));
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
//        locations.put(4, new Location(4, "You are in a valley beside a stream"));
//        locations.put(5, new Location(5, "You are in the forest"));
//
//        locations.get(1).addExit("W", 2);
//        locations.get(1).addExit("E", 3);
//        locations.get(1).addExit("S", 4);
//        locations.get(1).addExit("N", 5);
//
//        locations.get(2).addExit("N", 5);
//
//        locations.get(3).addExit("W", 1);
//
//        locations.get(4).addExit("N", 1);
//        locations.get(4).addExit("W", 2);
//
//        locations.get(5).addExit("S", 1);
//        locations.get(5).addExit("W", 2);
    }

    public static void main(String[] args) throws IOException {
//        // the IOexception is needed compulsorily to ensure that the FileWriter is compulsorily closed after the operation
//        FileWriter locFile = null; // declare locFile here and not in the try block so that locFile scope is applicable to all error handling blocks
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        }
//////    if we are throwing the IOexception, then we don't need the catch block
////        catch (IOException e) {
////            System.out.println("In catch block");
////            e.printStackTrace();
////        }
//        finally {
//            System.out.println("In finally block");
////            try {
//            if (locFile != null) {
//                System.out.println("Attempting to close file writer");
//                locFile.close();
//                System.out.println("Successfully closed file writer");
//            }
////            }
////            catch (IOException e) {
////                e.printStackTrace();
////            }
//        }

//        TRYING WITH RESOURCES - ALSO ADDING MULTIPLE RESOURCES WITH SEMICOLON
        try (FileWriter locFile = new FileWriter(locationFilePath);
             FileWriter dirFile = new FileWriter(directionFilePath)) { // this method of error throwing does not require a finally block and the error is thrown using the resources
            String line;
            for (Location location : locations.values()) {
                line = location.getLocationID() + "," + location.getDescription() + "\n";
                locFile.write(line);
                for (String direction : location.getExits().keySet()) {
                    line = location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n";
                    dirFile.write(line);
                }
            }
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}