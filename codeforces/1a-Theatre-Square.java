/*

http://codeforces.com/problemset/problem/1/A

Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters.
On the occasion of the city's anniversary, a decision was taken to pave the Square with square granite flagstones.
Each flagstone is of the size a × a.

What is the least number of flagstones needed to pave the Square?
It's allowed to cover the surface larger than the Theatre Square, but the Square has to be covered.
It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the Square.

Input
The input contains three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 109).

Output
Write the needed number of flagstones.

Examples
input
6 6 4
output
4

*/

import java.util.Scanner;

class TheatreSquare
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        long n = Long.parseLong(inputs[0]);
        long m = Long.parseLong(inputs[1]);
        long a = Long.parseLong(inputs[2]);

        long tilesInN = (long) Math.ceil((double) n / a);
        long tilesInM = (long) Math.ceil((double) m / a);

        System.out.println(tilesInN * tilesInM);
    }
}
