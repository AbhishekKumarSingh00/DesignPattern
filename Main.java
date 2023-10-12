import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        HashSet<String> updateQuerySet = new HashSet<>();
        HashSet<String> uniqueKeys = new HashSet<>();
        List<String> edcRemoved = new ArrayList<>();
        try {
            File edc_Included = new File("/Users/abhisheksingh/Desktop/edc_Included.txt");

            Scanner edc_IncludedReader = new Scanner(edc_Included);
// remove edc_
            while (edc_IncludedReader.hasNextLine()) {
                String edc_IncludedData = edc_IncludedReader.nextLine();
                StringBuilder stringBuilder = new StringBuilder(edc_IncludedData);
                stringBuilder.delete(0, 4);
                edcRemoved.add(stringBuilder.toString());
            }
            edc_IncludedReader.close();
            try {
                save(edcRemoved, "/Users/abhisheksingh/Desktop/edc_Removed.txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
// create update query
            File edc_Removed = new File("/Users/abhisheksingh/Desktop/edc_Removed.txt");
            Scanner edc_RemovedReader = new Scanner(edc_Removed);
            edc_IncludedReader = new Scanner(edc_Included);
            while (edc_RemovedReader.hasNextLine() && edc_IncludedReader.hasNextLine()) {
                String edc_RemovedData = edc_RemovedReader.nextLine();
                String edc_IncludedData = edc_IncludedReader.nextLine();

//                String option = "insert into option_question values(null, (select id from question where alias = 'Brand Name'), 0, null, now(), now(), 0, 'Kelvinator');\n" +
//                        "insert into option_text_mapping values(null, now(), 'Kelvinator', now(), (select id from language where language_iso_code = 'en'), (select id from option_question where alias = 'Kelvinator' and question_id = (select id from question where alias = 'Brand Name')));\n";

//                String replaceString = option.replace("'Kelvinator'", "'" + data + "'");
//                System.out.println(replaceString);

                String updateQuery = String.format("update solution_question_mapping set solution_sub_type_id = \"%s\" where solution_sub_type_id = \"%s\";", edc_RemovedData, edc_IncludedData);
                updateQuerySet.add(updateQuery);
                uniqueKeys.add(edc_RemovedData);
//                System.out.println(updateQuery);
//                System.out.println(data);
            }
            edc_RemovedReader.close();
            edc_IncludedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            save(updateQuerySet, "/Users/abhisheksingh/Desktop/UpdateQuery.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            save(uniqueKeys, "/Users/abhisheksingh/Desktop/UniqueKeys.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void save(Set<String> obj, String path) throws Exception {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
            for (String s : obj) {
                pw.println(s);
            }
            pw.flush();
        } finally {
            pw.close();
        }
    }

    public static void save(List<String> obj, String path) throws Exception {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
            for (String s : obj) {
                pw.println(s);
            }
            pw.flush();
        } finally {
            pw.close();
        }
    }



}
