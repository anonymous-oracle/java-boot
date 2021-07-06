package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str = "ncuuivniounqcueacrsdweactdtcwfbdewatwityrbjmutdhrdtgurpnukyonjukmu" +
                "rnvuefnvufneu vinef iuniefjnv ijew jf FDM FMFMMO,SPCFKV OGSD,CAOVFEO,FD" +
                " KMC SAODMVOFM V KFDNUERBFYQEFWQPIFRI je" +
                " ijdsnicmw0idv54984988951951919884CMVIFDIVIEF";
        System.out.println(str.replaceAll(".", "~")); // the '.' character in regex literature is actually a wildcard for any character; this particular replacement replaces all characters
        System.out.println(str.replaceAll("^....", "")); // delete the starting 4 characters
        System.out.println(str);
        System.out.println(str.matches("ncu"));
        System.out.println(str.matches("ncu.i")); // for the matches method the entire regular expression should match
        System.out.println(str.replaceAll("^", "beginning"));
        System.out.println(str.replaceAll("$", "end"));
        System.out.println(str.replaceAll("[aeiou]", "~")); // replaces string and substrings of 'aeiou' with ~
        System.out.println(str.replaceAll("[aeiou]", "I HAVE BEEN REPLACED"));
        System.out.println(str.replaceAll("[ae][ou]", "I HAVE BEEN REPLACED")); // replaces a or e or ae followed by o or u or ou with the replacement text

//        IF WE WANT TO REPLACE EVERYTHING WITH A REPLACEMENT STRING EXCEPT A SUBSTRING
        System.out.println(str.replaceAll("[^aeiou]", "*")); // the ^ symbol within square brackets negates the patter that is followed
        System.out.println("JIREN THE GRAY".replaceAll("[Jj]IREN", "Jiren: "));
        System.out.println(str.replaceAll("[a-d2-8]", "~")); // ranges need not be separated, instead can be just mentioned in a continuous manner
        System.out.println(str.replaceAll("[a-dA-D2-8]", "~")); // makes the above regex match capital case as well
        System.out.println(str.replaceAll("(?i)[a-d2-8]", "~")); // (?i) makes the entire regex case insensitive
        System.out.println(str.replaceAll("\\d", "~")); // replace digits with ~
        System.out.println(str.replaceAll("\\D", "~")); // replace non-digits with ~
        String whiteSpaceString = "This string has spaces, tabs\t and\t a newline\n";
        System.out.println(whiteSpaceString.replaceAll("\\s", "[SPACE]")); // matches all space characters
        System.out.println(whiteSpaceString.replaceAll("\t", "[TAB]"));
        System.out.println(whiteSpaceString.replaceAll("\\S", "[NON-SPACE]")); // matches all non-space characters
        System.out.println(whiteSpaceString.replaceAll("\\b", "[BOUNDARY]")); // matches all word boundaries
        System.out.println(whiteSpaceString.replaceAll("\\w", "[ALNUM]")); // matches all alphanumerics
        System.out.println(whiteSpaceString.replaceAll("\\W", "[NON-ALNUM]")); // matches all non-alphanumerics
// QUANTIFIERS
        System.out.println(str.replaceAll("a{1}", "[A]")); // match exactly 1 'a'
        System.out.println(str.replaceAll("(?i)[a]{1}", "[A]"));
        System.out.println(str.replaceAll("a+", "[A]")); // one or more 'a'
        System.out.println(str.replaceAll("a*", "[A]")); // zero or more a
        System.out.println(str.replaceAll("ncu*", "[NCU...]")); // replace nc and 0 or more subsequent u's with [NCU...]

//        PATTERN CLASS
        StringBuilder htmlText = new StringBuilder("<h1>My Main Heading</h1>");
        htmlText.append("<h2>My sub-heading 1</h2>");
        htmlText.append("<p>My paragraph</p>");
        htmlText.append("<p>Another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Some summary paragraph</p>");
        String h2Pattern = "<h2>"; // but this pattern will match only if entire string is '<h2>'
        Pattern pattern = Pattern.compile(h2Pattern);
//        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); //case insensitive and unicode strings
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
        h2Pattern = ".*<h2>.*";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        int count = 0;
        matcher.reset(); // resets the matcher to the beginning of text
//        THE find() CALL UNLIKE THE matches() CALL DOES NOT NEED TO MATCH THE ENTIRE TEXT, SO JUST MENTIONING THE REQUIRED PATTERN IS ENOUGH
        h2Pattern = "<h2>";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        while (matcher.find()) { // every find() call returns a match if found and runs till it either fails to find a match or gets reset or reaches the end of the match text
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

//        EASIER WAY TO FIND MULTIPLE OCCURENCES OF A PATTERN
        h2Pattern = "(<h2>)"; // use parenthesis for a group pattern
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        while (matcher.find()) { // every find() call returns a match if found and runs till it either fails to find a match or gets reset or reaches the end of the match text
            System.out.println("Occurence " + matcher.group(1));
        }
        h2Pattern = "(<h2>.*</h2>)"; // greedy quantifier
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        while (matcher.find()) {
            System.out.println("Occurence " + matcher.group(1));
        }

        h2Pattern = "(<h2>.*?</h2>)"; // lazy quantifier
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        while (matcher.find()) {
            System.out.println("Occurence " + matcher.group(1));
        }

        h2Pattern = "(<h2>)(.+?)(</h2>)"; // lazy quantifier
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        while (matcher.find()) {
            System.out.println("Occurence: " + matcher.group(2)); // extracts the middle parenthesis group
        }

//        REGEX WITH LOGICAL OPERATORS
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));

        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]"; // matches all occurences of 't' followed by any single character or no character 'v', but won't match the last 't' in the text string
//        String tNotVRegExp = "t(?!v)"; // matches all occurences of 't' followed by any single character or no character except 'v'; this is a lookahead matcher
        String tNotVRegExp = "t(?=v)"; // matches all occurences of 't' followed by 'v' but will not include 'v' in the match
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count=0;
        while (tNotVMatcher.find()){
            count++;
            System.out.println("Occurence "+count+" : "+tNotVMatcher.start() + " to "+tNotVMatcher.end());
        }
    }
}
