package com.idch.mlme.utils;

/**
 * Dna utils class
 */
public class DnaUtils {

    private static final int CONCURRENCES = 4;

    /**
     * Method implementation for minimum length matrix
     *
     * @param rowLength
     * @return
     */
    public static boolean isMinlengthMatrix(int rowLength) {
        return rowLength >= CONCURRENCES;
    }

    /**
     * Method implementation for validate values and validate square matrix N*N
     *
     * @param vector
     * @return boolean
     */
    public static boolean isValidMatrix(String[] vector) {
        int length = vector.length;
        for (String s : vector) {
            if (s.length() != length || isValidateRegxRowChars(s))
                return false;
        }
        return true;
    }

    /**
     * Method implementation for validate is mutant
     *
     * @param vector
     * @return boolean
     */
    public static boolean isMutant(final String[] vector) {
        int length = vector.length;
        int found = 0;
        int size = length - CONCURRENCES;
        int columnRightHorizontal = 0;
        for (int row = 0; row < length; row++) {
            columnRightHorizontal = 0;
            for (int column = 0; column < length; column++) {
                if (found > 1)
                    break;
                if (size >= column && columnRightHorizontal <= column) {
                    if (isRightHorizontal(vector, row, column)) {
                        found++;
                        columnRightHorizontal = column + CONCURRENCES;
                    }
                }
                if (size >= column && size >= row) {
                    if (isDownRightDiagonal(vector, row, column))
                        found++;
                }
                if (size >= row) {
                    if (isDownVertical(vector, row, column))
                        found++;
                }
                if (length - size <= column + 1 && size >= row) {
                    if (isDownLeftDiagonal(vector, row, column))
                        found++;
                }
            }
        }
        return found > 1;
    }

    /**
     * Helper method for validate concurrences in right horizontal
     *
     * @param vector
     * @param row
     * @param column
     * @return
     */
    private static boolean isRightHorizontal(final String[] vector, int row, int column) {
        return vector[row].charAt(column) == vector[row].charAt(column + 1) && vector[row].charAt(column) == vector[row].charAt(column + 2)
                && vector[row].charAt(column) == vector[row].charAt(column + 3);
    }

    /**
     * Helper method for validate concurrences in down right diagonal
     *
     * @param vector
     * @param row
     * @param column
     * @return
     */
    private static boolean isDownRightDiagonal(final String[] vector, int row, int column) {
        return vector[row].charAt(column) == vector[row + 1].charAt(column + 1) && vector[row].charAt(column) == vector[row + 2].charAt(column + 2)
                && vector[row].charAt(column) == vector[row + 3].charAt(column + 3);
    }

    /**
     * Helper method for validate concurrences in down vertical
     *
     * @param vector
     * @param row
     * @param column
     * @return
     */
    private static boolean isDownVertical(final String[] vector, int row, int column) {
        return vector[row].charAt(column) == vector[row + 1].charAt(column) && vector[row].charAt(column) == vector[row + 2].charAt(column)
                && vector[row].charAt(column) == vector[row + 3].charAt(column);
    }

    /**
     * Helper method for validate concurrences in down left diagonal
     *
     * @param vector
     * @param row
     * @param column
     * @return
     */
    private static boolean isDownLeftDiagonal(final String[] vector, int row, int column) {
        return vector[row].charAt(column) == vector[row + 1].charAt(column - 1) && vector[row].charAt(column) == vector[row + 2].charAt(column - 2)
                && vector[row].charAt(column) == vector[row + 3].charAt(column - 3);
    }

    /**
     * Helper method for validate characters
     *
     * @param s
     * @return
     */
    private static boolean isValidateRegxRowChars(String s) {
        return !s.matches("[ACGT]+");
    }

}
