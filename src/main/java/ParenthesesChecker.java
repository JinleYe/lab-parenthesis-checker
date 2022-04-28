import java.util.*;
import java.util.zip.CheckedInputStream;

public class ParenthesesChecker {

    /*
    // MVP part, work as pair
    public boolean checkParentheses(String string){
        // special case: ""
        if(string.equals("")) return true;

        // convert the string to ArrayList
        List<String> arr = new ArrayList<String>(Arrays.asList(string.split("")));

//     old version:   if(arr.contains("(") && arr.contains(")")) return true;

        int left_count = 0;
        int right_count = 0;
        for(String ele : arr){
            if(ele.equals("(")){left_count += 1;}
            if(ele.equals(")")){right_count += 1;}
        }
        if(left_count == right_count) return true;

        return false;
    }

     */




    // extension part
    public boolean checkParentheses(String string){
        // special case: ""
        if(string.equals("")) return true;

        // convert the string to ArrayList, initialisation
        List<String> arr = new ArrayList<String >(Arrays.asList(string.split("")));
        List<String> start = new ArrayList<>(List.of("(","{","[","<"));
        List<String> end = new ArrayList<>(List.of(")","}","]",">"));
        HashSet<String> braces_collection = new HashSet<>(List.of(
                "(","{","[","<",")","}","]",">"));
        Stack<String> stack = new Stack<>();


        for(String element : arr){
            if (!braces_collection.contains(element)){
                continue;
            } else if (start.contains(element)){
                stack.push(element);
            }else if (end.contains(element)){
                var idx = end.indexOf(element);
                if(stack.isEmpty()){
                    return false;
                }else if(!start.get(idx).equals(stack.pop())){
                    return false;
                }

            }

        }
        return stack.isEmpty();

    }


//    public static void main(String[] arg){
//        String s = "aa,b,c,d";
//
//        String st[] = s.split(",");
//        System.out.println(s.charAt(0));
//        List<String> arr = new ArrayList<String>(Arrays.asList(s.split("")));
//        System.out.println(arr.get(0));
//
//    }





}
