package robbers_secret;
/*
Robber's Code
A group of crafty robbers has devised an ingenious way to leave messages while keeping their
communications hidden in plain sight from the police. They use a technique called "Robber's Code,
" where each word follows a specific pattern: the letters within each word are arranged in strictly
increasing alphabetical order. For example, the word "ace" follows this pattern as 'a' comes before
'c' and 'c' comes before 'e.' To make their communication more secure they robbers implement one
more secret operation(computation) on each message they send. Your challenge is to create a
program to generate all the words that adhere to Robber’s Code (including the secret operation)
using a given string as input.
**Note:- You must use recursion to generate all strings. 10 Extra Credits awarded if you also provide
a non-recursive program.
Input Format
The input will consist of a single string made up of letters and numbers. The characters inside the
string will appear in alphabetical order(not necessarily the English Alphabetical order).
Constraints
The string will be no longer than 20 characters long.
Output Format
The Robber’s code received by the police.

Sample Input 0  : abc

sample output
a
ba
cba
ca
b
cb
c

Sample Input 1: edcb

sample output:
e
de
cde
bcde
bde
ce
bce
be
d
cd
bcd
bd
c
bc
b
 */
import java.util.Scanner;

// Recursion solution
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = scanner.nextLine();
        generateStrings(alphabet);
    }

    static void generateStrings(String alphabet){
        helper("", alphabet);
    }

    static void helper(String prefix, String alphabet){
        if(!prefix.isEmpty()){
            System.out.println(new StringBuilder(prefix).reverse());
        }
        for(int i= 0; i < alphabet.length(); i++){
            char ch = alphabet.charAt(i);
            String remaining = alphabet.substring(i + 1);
            helper(prefix + ch, remaining);
        }
    }

}

// None recursive solution using stack

/*
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = scanner.nextLine();
        generateStrings(alphabet);
    }

    static void generateStrings(String alphabet) {
        Stack<State> stack = new Stack<>();
        stack.push(new State("", alphabet));

        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            String prefix = currentState.prefix;
            String remaining = currentState.remaining;

            System.out.println("The prefix: " + prefix);
            System.out.println("The remaining: " + remaining);

            if (!prefix.isEmpty()) {
                System.out.println(new StringBuilder(prefix).reverse());
            }

            // Reverse the order in which states are pushed onto the stack.
            for (int i = remaining.length() - 1; i >= 0; i--) {
                char ch = remaining.charAt(i);
                System.out.println("The ch value: " + ch);
                String nextRemaining = remaining.substring(i + 1);
                stack.push(new State(prefix + ch, nextRemaining));
            }
        }
    }

    static class State {
        String prefix;
        String remaining;

        State(String prefix, String remaining) {
            this.prefix = prefix;
            this.remaining = remaining;
        }
    }
}
 */