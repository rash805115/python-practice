/*

http://codeforces.com/problemset/problem/1/B

In the popular spreadsheets systems (for example, in Excel) the following numeration of columns is used.
The first column has number A, the second — number B, etc. till column 26 that is marked by Z.
Then there are two-letter numbers: column 27 has number AA, 28 — AB, column 52 is marked by AZ.
After ZZ there follow three-letter numbers, etc.

The rows are marked by integer numbers starting with 1.
The cell name is the concatenation of the column and the row numbers.
For example, BC23 is the name for the cell that is in column 55, row 23.

Sometimes another numeration system is used: RXCY, where X and Y are integer numbers, showing the column and the row numbers respectfully.
For instance, R23C55 is the cell from the previous example.

Your task is to write a program that reads the given sequence of cell coordinates and produce each item written according to the rules of another numeration system.

Input
The first line of the input contains integer number n (1 ≤ n ≤ 105), the number of coordinates in the test.
Then there follow n lines, each of them contains coordinates.
All the coordinates are correct, there are no cells with the column and/or the row numbers larger than 106.

Output
Write n lines, each line should contain a cell coordinates in the other numeration system.

Examples
input
2
R23C55
BC23
output
BC23
R23C55

*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Spreadsheets
{
    public static void main(String args[])
    {
        Pattern rcPattern = Pattern.compile("R(\\d+)C(\\d+)");
        Pattern crPattern = Pattern.compile("([A-Z]+)(\\d+)");

        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < tests; i++)
        {
            String input = scanner.nextLine();
            Matcher rcMatcher = rcPattern.matcher(input);
            Matcher crMatcher = crPattern.matcher(input);

            if(rcMatcher.matches())
            {
                int row = Integer.parseInt(rcMatcher.group(1));
                int col = Integer.parseInt(rcMatcher.group(2));

                System.out.println(numToCell(col) + row);
            }
            else if(crMatcher.matches())
            {
                int row = Integer.parseInt(crMatcher.group(2));
                String col = crMatcher.group(1);

                System.out.println("R" + row + "C" + cellToNum(col));
            }
        }
    }

    public static String numToCell(int num)
    {
        String cell = "";
        while(num > 0)
        {
            int rem = (num - 1) % 26;

            char c = (char) (rem + 65);
            cell = c + cell;

            num = (num - rem) / 26;
        }

        return cell;
    }

    public static int cellToNum(String cell)
    {
        cell = cell.toUpperCase();

        int num = 0;
        int cellLen = cell.length();

        for(int i = 0; i < cellLen; i++)
        {
            int ord = ((int) cell.charAt(i)) - 65 + 1;
            int pos = cellLen - 1 - i;

            num += Math.pow(26, pos) * ord;
        }

        return num;
    }
}
