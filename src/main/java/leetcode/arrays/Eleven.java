package leetcode.arrays;

import java.util.HashSet;

/*
// valid sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */
public class Eleven {

// looping through rows is the outer for loop and looping through
    // columns is the inner for loop.
    // when we are going with unique values Hashset is the perfect DS to go
     // also, HashSet has constant time lookups and we can store unique values in no time


    public boolean isValidSudoku(char[][] board) {
        HashSet<String> alreadySeen = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char character_value = board[i][j];
                if (character_value != '.') {
              if (
               (!alreadySeen.add(character_value + " found in row" + i)) ||
               (!alreadySeen.add(character_value + " found in column" + j)) ||
               (!alreadySeen.add(character_value + " found in small grid " + i/3 + "" + j/3)) ) {
                  return false;
              }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char testBoards[][] = new char[9][9];


        Eleven eleven = new Eleven();
//        eleven.isValidSudoku();

    }
}
