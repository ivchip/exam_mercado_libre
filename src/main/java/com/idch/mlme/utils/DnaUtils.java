package com.idch.mlme.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
        Map<String, Integer> foundConcurrence = new HashMap<>();
        int length = vector.length;
        AtomicInteger found = new AtomicInteger(0);
        int size = length - CONCURRENCES;
        int typeFind = 0;
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                if (found.get() > 1)
                    break;
                if (!foundConcurrence.isEmpty()) {
                    if (foundConcurrence.containsKey(row + "," + column)) {
                        typeFind = foundConcurrence.get(row + "," + column);
                    } else {
                        typeFind = 0;
                    }
                }
                if (size >= column && typeFind != 1) {
                    if (isRightHorizontal(vector, row, column))
                        loadMap(row, column, 1, found, foundConcurrence);
                }
                if (size >= column && size >= row && typeFind != 2) {
                    if (isDownRightDiagonal(vector, row, column))
                        loadMap(row, column, 2, found, foundConcurrence);
                }
                if (size >= row && typeFind != 3) {
                    if (isDownVertical(vector, row, column))
                        loadMap(row, column, 3, found, foundConcurrence);
                }
                if (length - size <= column + 1 && size >= row && typeFind != 4) {
                    if (isDownLeftDiagonal(vector, row, column))
                        loadMap(row, column, 4, found, foundConcurrence);
                }
            }
        }
        return found.get() > 1;
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

    /**
     * Helper method for put Map and increment found
     *
     * @param row
     * @param column
     * @param typeFind
     * @param found
     * @param foundConcurrence
     */
    private static void loadMap(final int row, final int column, final int typeFind, AtomicInteger found, Map<String, Integer> foundConcurrence) {
        found.set(found.get() + 1);
        switch (typeFind) {
            case 1 : {
                foundConcurrence.put(row + "," + (column + 1), typeFind);
                foundConcurrence.put(row + "," + (column + 2), typeFind);
                foundConcurrence.put(row + "," + (column + 3), typeFind);
                break;
            }
            case 2 : {
                foundConcurrence.put((row + 1) + "," + (column + 1), typeFind);
                foundConcurrence.put((row + 2) + "," + (column + 2), typeFind);
                foundConcurrence.put((row + 3) + "," + (column + 3), typeFind);
                break;
            }
            case 3 : {
                foundConcurrence.put((row + 1) + "," + column, typeFind);
                foundConcurrence.put((row + 2) + "," + column, typeFind);
                foundConcurrence.put((row + 3) + "," + column, typeFind);
                break;
            }
            case 4 : {
                foundConcurrence.put((row + 1) + "," + (column - 1), typeFind);
                foundConcurrence.put((row + 2) + "," + (column - 2), typeFind);
                foundConcurrence.put((row + 3) + "," + (column - 3), typeFind);
            }
        }
    }

}
