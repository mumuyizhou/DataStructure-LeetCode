package leetcode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhouPan
 * @date 2019/10/14 22:05.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) throws ScriptException {
        String expression = "2-1";
        List<Integer> list = new LinkedList<Integer>();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(expression);
        System.out.println(result);
        return list;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses diff = new DifferentWaysToAddParentheses();
        try {
            diff.diffWaysToCompute("12");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}

