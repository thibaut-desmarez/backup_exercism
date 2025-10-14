import java.util.List;
import java.util.Stack;

class BracketChecker {

    String expression;
    List<String> openingBracketeer = List.of("{","[","(");
    List<String> closingBracketeer = List.of("}","]",")");
    Stack<String> bracketeerStack = new Stack<>();

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        for (char c : expression.toCharArray()) {
            if(openingBracketeer.contains(String.valueOf(c))){
                bracketeerStack.push(String.valueOf(c));
            }
            else if(closingBracketeer.contains(String.valueOf(c))){
                if(bracketeerStack.isEmpty()) {
                    return false;
                }
                else{
                    String bracketeer =  bracketeerStack.pop();
                    if(openingBracketeer.indexOf(bracketeer) != closingBracketeer.indexOf(String.valueOf(c))){
                        return false;
                    }
                }
            }
        }
        return bracketeerStack.isEmpty();
    }

}