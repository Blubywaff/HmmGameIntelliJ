import java.io.*;

public class FileManager {
    public static String configFileName = "ConfigData.txt";
    public static String basePath = "ConfigData\\";
    
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
    
    /*public static void setBasicSlingshot() {
    *    String fileName = basePath + "BasicSlingshot.txt";
    *    try {
    *        /*FileReader reader = new FileReader(fileName);
    *        BufferedReader bReader = new BufferedReader(reader);
    *        String line = "";
    *        double defaultDamage = 0;
    *        while((line = bReader.readLine()) != null) {
    *            if(line.contains("defaultDamage")) {
    *                defaultDamage = Double.parseDouble(line - "defaultDamage: ");
    *            }
    *        }
    *        bReader.close();
    *        bWriter.close();*/
    /*        /*-------------------------------------------------------*/
    /*        BufferedReader file = new BufferedReader(new FileReader("BasicSlingshot.java"));
    *        String line;
    *        StringBuffer inputBuffer = new StringBuffer();
    *        String ddline = "";
    *        while ((line = file.readLine()) != null) {
    *            inputBuffer.append(line);
    *            inputBuffer.append('\n');
    *            if(line.contains("defaultDamage =")) {
    *                ddline = line;
    *            }
    *        }
    *        String inputStr = inputBuffer.toString();
    *        file.close();
    *        
    *        String ddline2 = "";
    *        BufferedReader file2 = new BufferedReader(new FileReader(basePath + "BasicSlingshot.txt"));
    *        while ((line = file2.readLine()) != null) {
    *            if(line.contains("defaultDamage")) {
    *                ddline2 = line;
    *            }
    *        }
    *        file2.close();
    *        
    *        //System.out.println(inputStr); // check that it's inputted right
    *
    *        // this if structure determines whether or not to replace "0" or "1"
    *        /*if (Integer.parseInt(type) == 0) {
    *            inputStr = inputStr.replace(replaceWith + "1", replaceWith + "0"); 
    *        }
    *        else if (Integer.parseInt(type) == 1) {
    *            inputStr = inputStr.replace(replaceWith + "0", replaceWith + "1");
    *        }*/
    /*        
    *        line = " ";
    *        ddline = ddline.substring(23, ddline.length()-1);
    *        ddline2 = ddline2.substring(15);
    *        inputStr = inputStr.replace(ddline, ddline2);
    *        System.out.println(ddline.toCharArray());
    *        System.out.println(ddline2.toCharArray());
    *        
    *        // check if the new input is right
    *        //System.out.println("----------------------------------\n"  + inputStr);
    *
    *        // write the new String with the replaced line OVER the same file
    *        FileOutputStream fileOut = new FileOutputStream("BasicSlingshot.java");
    *        fileOut.write(inputStr.getBytes());
    *        fileOut.close();
    *        /*----------------------------------------------------------*/
    /*    } catch(FileNotFoundException e) {
    *       System.out.println("Missing config file!");
    *    } catch(IOException e) {
    *        System.out.println("IOException was thrown!");
    *    }
    *}*/
    
    /* */
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
}