import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean s = new ValidParentheses().isValid("()[]{}");
        System.out.print(s);
    }

    public boolean isValid(String s) {
        if (!"".equals(s)) {
            Map<String, String> map = new HashMap<>();
            map.put("(", ")");
            map.put("[", "]");
            map.put("{", "}");

            String stack = "";
            String str = "", last = "";
            for (char chr : s.toCharArray()) {
                str = String.valueOf(chr);
                if ("".equals(stack)) {
                    if (map.get(str) == null) return false;
                    stack += str;
                } else {
                    if (map.get(str) != null) {
                        stack += str;
                    } else {
                        if (map.get(stack.substring(stack.length()-1, stack.length())).equals(str)) {
                            stack = stack.substring(0, stack.length()-1);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return "".equals(stack);
        }

        return true;
    }

    public boolean isValid3ms(String s) {
        if(s.length()==0) return true;
        char[] res = new char[s.length()];
        int head =0;
        for(char c : s.toCharArray()){
            switch(c){
                case('('):
                case('{'):
                case('['):
                    res[head] = c;
                    head++;
                    break;
                case(')'): if(head ==0 || res[--head]!='(')
                    return false;
                    break;
                case('}'):if(head ==0 || res[--head]!='{')
                    return false;
                    break;
                case(']'):if(head ==0 || res[--head]!='[')
                    return false;
                    break;

            }
        }
        return head==0;
    }
}
