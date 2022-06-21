import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static int days = 30;
    private static String[] data,params;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\1.txt"));
             PrintWriter out = new PrintWriter("data.csv");) { //,Charset.forName("windows-1251")
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains(".  2")) {
                    for (int i=0; i<6; i++){
                        line = br.readLine();
                    }
                    for (int j=0; j<days; j++){
                        line = br.readLine();
                        data = line.split("                                                ");
                        params = data[1].split("  ");
                        boolean flag = true;
                        out.print(j+";");
                        for (int k=0; k<params.length; k++){
                            if(params[k].trim().length()>0) {
                                out.print(params[k].trim());
                                if (flag) {
                                    flag = false;
                                    out.print(";");
                                }
                            }
                        }
                        out.println();
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
