import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String args[]) {
        HashSet<String> uniqueCategory = new HashSet<>();
        HashSet<String> insertQuerySet = new HashSet<>();
        try {
            File category = new File("/Users/abhisheksingh/Desktop/category.txt");

            Scanner categoryReader = new Scanner(category);
            while (categoryReader.hasNextLine()) {
                String categoryData = categoryReader.nextLine();
                String insertQuery = String.format("set @parentQuesId = (select id from solution_question_mapping where solution_sub_type_id = %s and question_id = (select id from question where alias = 'Brand EMI Details'));\n" +
                        "set @optionId = (select id from option_question where alias = 'Yes' and question_id = (select id from question where alias = 'Brand EMI Details'));\n" +
                        "update solution_question_mapping set parent_id =@parentQuesId ,parent_selected_option_id = @optionId where solution_sub_type_id = %s\n" +
                        "and question_id in ('2220,2221,2222,2223,2224,2225');", categoryData, categoryData);
                insertQuerySet.add(insertQuery);
//                uniqueCategory.add(categoryData);
                System.out.println(insertQuery);
            }
            categoryReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            save(insertQuerySet, "/Users/abhisheksingh/Desktop/insertQuery.sql");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(uniqueCategory);
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
