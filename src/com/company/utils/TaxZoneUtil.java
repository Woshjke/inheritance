package com.company.utils;

import com.company.model.Region;

import java.util.Arrays;
import java.util.List;

public class TaxZoneUtil {

    static List<Region> preferentialTaxRegionList = Arrays.asList(Region.GRODNO, Region.BREST);

    public static boolean isRegionFromPreferentialTaxZone(Region region){
        if (preferentialTaxRegionList.contains(region)){
            return true;
        } else {
            return false;
        }
    }
}
