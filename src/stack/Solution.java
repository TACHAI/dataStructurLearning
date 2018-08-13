package stack;

import java.util.*;
import java.util.Stack;

/**
 * Created by @Author tachai
 * date 2018/8/8 22:45
 *
 * @Email 1206966083@qq.com
 */
public class Solution {
    public static boolean isValid(String str){
        java.util.Stack stacks = new Stack();
        String[] strings =str.split("");
        for(int i=0;i<strings.length;i++){
            if(strings[i].equals("(")||strings[i].equals("{")||strings[i].equals("[")){
                stacks.push(strings[i]);
            }else {
                if(stacks.isEmpty()){
                    if(str.equals("")){
                        return true;
                    }else {
                        return false;
                    }
                }
                if(strings[i].equals(")")){
                    if(!stacks.pop().equals("(")){
                        return false;
                    }
                }else if(strings[i].equals("}")) {
                    if (!stacks.pop().equals("{"))
                        return false;
                }else if(strings[i].equals("]")) {
                    if (!stacks.pop().equals("["))
                        return false;
                }
            }
        }
        return stacks.empty();
    }

    public static void main(String[] args) {
        boolean is = isValid("");
        System.out.println(is);
    }
}
