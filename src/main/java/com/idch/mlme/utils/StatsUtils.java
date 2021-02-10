package com.idch.mlme.utils;

import com.idch.mlme.dto.StatisticDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Stats utils class
 */
public class StatsUtils {

    /**
     * Method implementation for calculate ratio
     *
     * @param numHumans
     * @param numMutants
     * @return
     */
    public static StatisticDTO calculateRatio(Long numHumans, Long numMutants) {
        StatisticDTO statisticDTO;
        if (numHumans != 0) {
            Double ratio = BigDecimal.valueOf(Double.valueOf(numMutants) / Double.valueOf(numHumans)).setScale(4, RoundingMode.HALF_UP).doubleValue();
            statisticDTO = new StatisticDTO(numMutants, numHumans, ratio);
        } else {
            statisticDTO = new StatisticDTO(numMutants, numHumans, 0D);
        }
        return statisticDTO;
    }
}
