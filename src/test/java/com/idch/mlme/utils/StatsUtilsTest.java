package com.idch.mlme.utils;

import com.idch.mlme.dto.StatisticDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsUtilsTest {

    @Test
    public void validateDivideZero() {
        StatisticDTO statisticDTO;
        statisticDTO = StatsUtils.calculateRatio(1L, 0L);

        assertEquals(statisticDTO.getRatio(), 0);
    }

    @Test
    public void validateRatio() {
        StatisticDTO statisticDTO;
        statisticDTO = StatsUtils.calculateRatio(1L, 4L);

        assertEquals(statisticDTO.getRatio(), 0,0.25);
    }

    @Test
    public void validateStatisticDTO() {
        StatisticDTO statisticDTO;
        statisticDTO = StatsUtils.calculateRatio(1L, 4L);

        assertEquals(statisticDTO.getCountMutantDna(), 0,1);
        assertEquals(statisticDTO.getCountHumanDna(), 0,4);
        assertEquals(statisticDTO.getRatio(), 0,0.25);
    }
}
