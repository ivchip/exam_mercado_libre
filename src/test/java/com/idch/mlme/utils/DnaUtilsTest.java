package com.idch.mlme.utils;

import com.idch.mlme.dto.DnaDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DnaUtilsTest {

    @Test
    public void validateMinimumMatrixSuccess() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CTAG";
        dna[2] = "TGCA";
        dna[3] = "AACC";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMinlengthMatrix(dnaDTO.getDna().length);
        assertEquals(result, true);
    }

    @Test
    public void validateMinimumMatrixFail() {
        String[] dna = new String[3];
        dna[0] = "ACG";
        dna[1] = "CTA";
        dna[2] = "TGC";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMinlengthMatrix(dnaDTO.getDna().length);
        assertEquals(result, false);
    }

    @Test
    public void validateSquareMatrix() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CTAG";
        dna[2] = "TGCA";
        dna[3] = "AACT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isValidMatrix(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateNotSquareMatrix() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CTAG";
        dna[2] = "TGC";
        dna[3] = "AACT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isValidMatrix(dnaDTO.getDna());
        assertEquals(result, false);
    }

    @Test
    public void validateCharsSuccess() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CTAG";
        dna[2] = "TGCA";
        dna[3] = "AACT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isValidMatrix(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateCharsFail() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CTAG";
        dna[2] = "TGFA";
        dna[3] = "AACT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isValidMatrix(dnaDTO.getDna());
        assertEquals(result, false);
    }

    @Test
    public void validateRightHorizontalSearch() {
        String[] dna = new String[6];
        dna[0] = "TAAAAT";
        dna[1] = "CTAGTG";
        dna[2] = "CCCCGT";
        dna[3] = "AACTCG";
        dna[4] = "CGCTAC";
        dna[5] = "AACTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateRightHorizontalSearchNextTo() {
        String[] dna = new String[6];
        dna[0] = "AAAAAT";
        dna[1] = "CTAGTG";
        dna[2] = "CCGCGT";
        dna[3] = "AACTCG";
        dna[4] = "CGCTAC";
        dna[5] = "AACTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, false);
    }

    @Test
    public void validateRightHorizontalSearchNextToSuccess() {
        String[] dna = new String[8];
        dna[0] = "ACATAGAA";
        dna[1] = "CTAGTGCT";
        dna[2] = "CCGCGTAC";
        dna[3] = "AACACGAA";
        dna[4] = "CGCTACCG";
        dna[5] = "AACTCTGC";
        dna[6] = "AACTCTAA";
        dna[7] = "AAAAAAAA";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateVerticalSearch() {
        String[] dna = new String[6];
        dna[0] = "TACAAT";
        dna[1] = "CTACTG";
        dna[2] = "CCAGGT";
        dna[3] = "CACGCG";
        dna[4] = "CGCGAC";
        dna[5] = "AACGCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateVerticalSearchNextTo() {
        String[] dna = new String[6];
        dna[0] = "AATAAT";
        dna[1] = "CAGGTG";
        dna[2] = "CAGCGT";
        dna[3] = "AACTCG";
        dna[4] = "CACTAC";
        dna[5] = "AACTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, false);
    }

    @Test
    public void validateVerticalSearchNextToSuccess() {
        String[] dna = new String[8];
        dna[0] = "ACATAGAA";
        dna[1] = "ATAGTGCT";
        dna[2] = "ACGCGTAC";
        dna[3] = "AACACGAA";
        dna[4] = "AGCTACCG";
        dna[5] = "AACTCTGC";
        dna[6] = "AACTCTAA";
        dna[7] = "ACAGATAA";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateDownRightDiagonalSearch() {
        String[] dna = new String[6];
        dna[0] = "TAACAT";
        dna[1] = "CTAGTG";
        dna[2] = "CCTCGT";
        dna[3] = "ACCTCG";
        dna[4] = "CGCTAC";
        dna[5] = "AACCCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateDownRightDiagonalSearchNextTo() {
        String[] dna = new String[6];
        dna[0] = "ATTAAT";
        dna[1] = "CATGTG";
        dna[2] = "CGGTGT";
        dna[3] = "TACATG";
        dna[4] = "CGCTAT";
        dna[5] = "AACTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, false);
    }

    @Test
    public void validateDownRightDiagonalSearchNextToSuccess() {
        String[] dna = new String[8];
        dna[0] = "GCATAGAA";
        dna[1] = "AGAGTGAT";
        dna[2] = "ACGCCTAC";
        dna[3] = "AACGCGAA";
        dna[4] = "AGCTGCCG";
        dna[5] = "AACTCGGC";
        dna[6] = "AACTCTGA";
        dna[7] = "ACAGATAG";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateDownLeftDiagonalSearch() {
        String[] dna = new String[6];
        dna[0] = "TAAGAT";
        dna[1] = "CTAATG";
        dna[2] = "CCACGT";
        dna[3] = "AACTTG";
        dna[4] = "CGCTAC";
        dna[5] = "AATTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void validateDownLeftDiagonalSearchNextTo() {
        String[] dna = new String[6];
        dna[0] = "AATAAT";
        dna[1] = "CGGATG";
        dna[2] = "CAACGT";
        dna[3] = "AACTCG";
        dna[4] = "AGCTAC";
        dna[5] = "AACTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, false);
    }

    @Test
    public void validateDownLeftDiagonalSearchNextToSuccess() {
        String[] dna = new String[8];
        dna[0] = "ACATAGAT";
        dna[1] = "ATAGTGTT";
        dna[2] = "ACGCGTAC";
        dna[3] = "AACATGAA";
        dna[4] = "AGCTACCG";
        dna[5] = "AATTCTGC";
        dna[6] = "ATCTCTAA";
        dna[7] = "TCAGATAA";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void isMutant() {
        String[] dna = new String[6];
        dna[0] = "TAAGAT";
        dna[1] = "CTAATG";
        dna[2] = "CCATGA";
        dna[3] = "AACTTG";
        dna[4] = "CGCTAC";
        dna[5] = "AATTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, true);
    }

    @Test
    public void isHuman() {
        String[] dna = new String[6];
        dna[0] = "TAAGCT";
        dna[1] = "CTAATG";
        dna[2] = "CCACGT";
        dna[3] = "AACTTG";
        dna[4] = "CGCTAC";
        dna[5] = "AATTCT";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);

        Boolean result = DnaUtils.isMutant(dnaDTO.getDna());
        assertEquals(result, false);
    }
}
