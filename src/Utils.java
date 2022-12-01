import java.io.*;

public class Utils {

    public static String getInput(String fileName) {
        String fileInput = null;
        try {
            File file= new File(fileName);
            fileInput = readFromInputStream(new FileInputStream(file));
            return fileInput;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
