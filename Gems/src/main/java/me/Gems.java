package me;

public class Gems {

    public Gems() {}

    public static int numMoves(String[] board) {
        int moves = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (i + 1 < board.length &&
                    ((j - 2 >= 0 &&
                     board[i].charAt(j-2) == board[i].charAt(j-1) &&
                     board[i].charAt(j-1) == board[i+1].charAt(j)) ||
                    (j - 1 >= 0 && j + 1 < board[0].length() &&
                     board[i].charAt(j-1) == board[i+1].charAt(j) &&
                     board[i+1].charAt(j) == board[i].charAt(j+1)) ||
                    (j + 2 < board[0].length() &&
                     board[i+1].charAt(j) == board[i].charAt(j+1) &&
                     board[i].charAt(j+1) == board[i].charAt(j+2)) ||
                    (j - 2 >= 0 &&
                     board[i+1].charAt(j-2) == board[i+1].charAt(j-1) &&
                     board[i+1].charAt(j-1) == board[i].charAt(j)) ||
                    (j - 1 >= 0 && j + 1 < board[0].length() &&
                     board[i+1].charAt(j-1) == board[i].charAt(j) &&
                     board[i].charAt(j) == board[i+1].charAt(j+1)) ||
                    (j + 2 < board[0].length() &&
                     board[i].charAt(j) == board[i+1].charAt(j+1) &&
                     board[i+1].charAt(j+1) == board[i+1].charAt(j+2)))) {
                    System.out.println("" + board[i].charAt(j));
                    moves++;
                }
                if (j + 1 < board[0].length() &&
                    ((i - 2 >= 0 &&
                     board[i-2].charAt(j) == board[i-1].charAt(j) &&
                     board[i-1].charAt(j) == board[i].charAt(j+1)) ||
                    (i - 1 >= 0 && i + 1 < board.length &&
                     board[i-1].charAt(j) == board[i].charAt(j+1) &&
                     board[i].charAt(j+1) == board[i+1].charAt(j)) ||
                    (i + 2 < board.length &&
                     board[i].charAt(j+1) == board[i+1].charAt(j) &&
                     board[i+1].charAt(j) == board[i+2].charAt(j)) ||
                    (i - 2 >= 0 &&
                     board[i-2].charAt(j+1) == board[i-1].charAt(j+1) &&
                     board[i-1].charAt(j+1) == board[i].charAt(j)) ||
                    (i - 1 >= 0 && i + 1 < board.length &&
                     board[i-1].charAt(j+1) == board[i].charAt(j) &&
                     board[i].charAt(j) == board[i+1].charAt(j+1)) ||
                    (i + 2 < board.length &&
                     board[i].charAt(j) == board[i+1].charAt(j+1) &&
                     board[i+1].charAt(j+1) == board[i+2].charAt(j+1)))) {
                    System.out.println("" + board[i].charAt(j));
                    moves++;
                }
            }
        }
        return moves;
    }
}
