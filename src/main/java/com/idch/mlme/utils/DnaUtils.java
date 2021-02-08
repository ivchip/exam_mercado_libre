package com.idch.mlme.utils;

public class DnaUtils {

    private static final int CONCURRENCES = 4;
    private static String[][] matrix;

    /**
     * @param rowLength The DNA array length
     * @return boolean
     */
    public static boolean isMinlengthMatrix(int rowLength) {
        return rowLength < CONCURRENCES;
    }

    /**
     * @param vector The person DNA
     * @return boolean
     */
    public static boolean isValidateSquareMatrixAndValues(String[] vector) {
        int length = vector.length;
        for (String s : vector) {
            if (s.length() != length)
                return false;
            if (isValidateRegxChars(s))
                return false;
        }
        return true;
    }

    /**
     * @param vector The person DNA
     * @return boolean
     */
    public static boolean isMutant(String[] vector) {
        int length = vector.length;
        matrix = new String[length][length];
        createMatrix(vector);
        int found = 0;
        int size = length - CONCURRENCES;
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                if (found > 1)
                    break;
                if (size >= column) {
                    if (isRightHorizontal(row, column))
                        found++;
                }
                if (size >= column && size >= row) {
                    if (isDownRightDiagonal(row, column))
                        found++;
                }
                if (size >= row) {
                    if (isDownVertical(row, column))
                        found++;
                }
                if (length - size <= column + 1 && size >= row) {
                    if (isDownLeftDiagonal(row, column))
                        found++;
                }
            }
        }
        return found > 1;
    }

    private static boolean isRightHorizontal(int x, int y) {
        return matrix[x][y].equals(matrix[x][y + 1]) && matrix[x][y].equals(matrix[x][y + 2])
                && matrix[x][y].equals(matrix[x][y + 3]);
    }

    private static boolean isDownRightDiagonal(int x, int y) {
        return matrix[x][y].equals(matrix[x + 1][y + 1]) && matrix[x][y].equals(matrix[x + 2][y + 2])
                && matrix[x][y].equals(matrix[x + 3][y + 3]);
    }

    private static boolean isDownVertical(int x, int y) {
        return matrix[x][y].equals(matrix[x + 1][y]) && matrix[x][y].equals(matrix[x + 2][y])
                && matrix[x][y].equals(matrix[x + 3][y]);
    }

    private static boolean isDownLeftDiagonal(int x, int y) {
        return matrix[x][y].equals(matrix[x + 1][y - 1]) && matrix[x][y].equals(matrix[x + 2][y - 2])
                && matrix[x][y].equals(matrix[x + 3][y - 3]);
    }

    private static boolean isValidateRegxChars(String s) {
        return !s.matches("[ACGT]+");
    }

    private static void createMatrix(final String[] values) {
        int i = 0;
        for (String s : values) {
            createVectorToMatrix(i, s);
            i++;
        }
    }

    private static void createVectorToMatrix(int row, final String value) {
        for (int i = 0; i < value.length(); i++) {
            matrix[row][i] = String.valueOf(value.charAt(i));
        }
    }
}
