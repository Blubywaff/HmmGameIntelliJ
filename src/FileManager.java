import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class FileManager {
    public static String configBasePath = "ConfigData\\";
    public static String listBasePath = "Assets\\";

    public static void init() {
        try {
            configBasePath = new File(".").getCanonicalPath();
            boolean contains = configBasePath.contains("/");
            boolean contains2 = configBasePath.contains("src");
            if (contains && contains2) {
                configBasePath += "/ConfigData/";
            } else if (contains) {
                configBasePath += "/src/ConfigData/";
            } else if (contains2) {
                configBasePath += "\\ConfigData\\";
            } else  {
                configBasePath += "\\src\\ConfigData\\";
            }

            listBasePath = new File(".").getCanonicalPath();
            contains = listBasePath.contains("/");
            contains2 = listBasePath.contains("src");
            if (contains && contains2) {
                listBasePath += "/Assets/";
            } else if (contains) {
                listBasePath += "/src/Assets/";
            } else if (contains2) {
                listBasePath += "\\Assets\\";
            } else  {
                listBasePath += "\\src\\Assets\\";
            }

            //System.out.println("SUCCESS");
        } catch(IOException e) {
            System.out.println("FAILED");
        }
    }

    public static double dDo(String name, String info) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configBasePath + name + ".txt"));
            String line = "";
            double result = 0;
            while((line = reader.readLine()) != null) {
                if(line.contains(info)) {
                    result = Double.parseDouble(line.substring(info.length()+2));
                }
            }
            reader.close();
            return result;
        } catch(FileNotFoundException e) {
            System.out.println("Missing config file!");
            return 0;
        } catch(IOException e) {
            System.out.println("IOException was thrown!");
            return 0;
        }
    }

    public static String sDo(String name, String info) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configBasePath + name + ".txt"));
            String line = "";
            String result = "";
            while((line = reader.readLine()) != null) {
                if(line.contains(info)) {
                    result = line.substring(info.length()+2);
                }
            }
            reader.close();
            return result;
        } catch(FileNotFoundException e) {
            System.out.println("Missing config file!");
            return "";
        } catch(IOException e) {
            System.out.println("IOException was thrown!");
            return "";
        }
    }


    public static ArrayList<String> listWeapons() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(listBasePath + "WeaponsList.txt"));
            String line = "";
            ArrayList<String> result = new ArrayList<>();
            while((line = reader.readLine()) != null) {
                result.add(line.substring(0, line.indexOf(' ')));
            }
            reader.close();
            return result;
        } catch(FileNotFoundException e) {
            System.out.println("Missing config file!");
            return null;
        } catch(IOException e) {
            System.out.println("IOException was thrown!");
            return null;
        }
    }

    public static boolean weaponIsDiscovered(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(listBasePath + "WeaponsList.txt"));
            String line = "";
            boolean result = false;
            while((line = reader.readLine()) != null) {
                if(line.contains(name)) {
                    result = (line.substring(name.length()+1)).equals("discovered");
                    //System.out.println(line.substring(name.length()+1));
                }
            }
            reader.close();
            return result;
        } catch(FileNotFoundException e) {
            System.out.println("Missing config file!");
            return false;
        } catch(IOException e) {
            System.out.println("IOException was thrown!");
            return false;
        }
    }
}