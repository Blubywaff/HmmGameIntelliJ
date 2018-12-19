import java.io.*;
import java.util.Arrays;

public class FileManager {
    public static String configFileName = "ConfigData.txt";
    public static String basePath = "ConfigData\\";
    public static void init() {
        try {
            basePath = new File(".").getCanonicalPath();
            boolean contains = basePath.contains("/");
            if(contains) {
                basePath += "/src/ConfigData/";
            } else {
                basePath += "\\src\\ConfigData\\";
            }
            System.out.println("SUCCESS");
        } catch(IOException e) {
            System.out.println("FAILED");
        }
    }
    public static String readConfig() {
        try {
            FileReader reader = new FileReader(configFileName);
            BufferedReader bReader = new BufferedReader(reader);
            String fullFile = "";
            String line = "";
            while((line = bReader.readLine()) != null) {
                fullFile += "line" + "\n";
            }
            bReader.close();
            return fullFile;
        } catch(FileNotFoundException e) {
            return("Missing config file!");
        } catch(IOException e) {
            return("IOException was thrown!");
        }
    }
    
    public static void setAll() {
    }

    public static double basicSlingshot(String info) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(basePath + "BasicSlingshot.txt"));
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

    public static double advancedSlingshot(String info) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(basePath + "AdvancedSlingshot.txt"));
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

    public static double doubleSlingshot(String info) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(basePath + "DoubleSlingshot.txt"));
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

    public static double tripleSlingshot(String info) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(basePath + "TripleSlingshot.txt"));
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
}