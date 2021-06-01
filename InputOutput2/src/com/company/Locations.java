package com.company;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static final String locationFilePath = "locations_big.txt";
    private static final String directionFilePath = "directions_big.txt";

    static {

        try (Scanner scanner = new Scanner(new FileReader(locationFilePath))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter()); // skips over the delimiter
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + " | description: " + description);
                Map<String, Integer> tempExit = new LinkedHashMap<>();
                locations.put(loc, new Location(loc, description, (LinkedHashMap<String, Integer>) tempExit));
            }
        } catch (IOException e) {

        }


        try (Scanner scanner = new Scanner(new FileReader(directionFilePath))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {

                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println("Imported loc: " + loc + " | direction: " + direction + " | destination: " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {

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