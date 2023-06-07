package com.tfr.yieldbook;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * Created by Erik on 9/28/2017.
 */
public class TestCumRetCalculator {

    @Test
    public void test1() {
        Date base = getDate(2015,2,1);
        Date asOf = getDate(2015,1,31);
        runTest(asOf, base, null);
    }

    @Test
    public void test2() {
        Date base = getDate(2015,2,1);
        Date asOf = getDate(2015,2,28);
        runTest(asOf, base, 0.05);
    }

    @Test
    public void test3() {
        Date base = getDate(2015,2,1);
        Date asOf = getDate(2015,3,13);
        runTest(asOf, base, 0.05);
    }

    @Test
    public void test4() {
        Date base = getDate(2015,2,1);
        Date asOf = getDate(2015,4,30);
        runTest(asOf, base, 0.08675);
    }

    @Test
    public void test5() {
        Date base = getDate(2015,2,1);
        Date asOf = getDate(2015,5,8);
        runTest(asOf, base, 0.08675);
    }

    @Test
    public void test6() {
        Date base = getDate(2015,2,1);
        Date asOf = getDate(2015,6,30);
        runTest(asOf, base, -0.04366);
    }

    private void runTest(Date asOfDate, Date baseDate, Double expectedResult) {
        CumRetCalculator calculator = new CumRetCalculator(getTestMap());
        Double actualResult = calculator.findCumReturn(asOfDate, baseDate);

        if(expectedResult == null) {
            assertNull(actualResult);
        } else {
            assertEquals(expectedResult, actualResult, 0.01);
        }
    }

    private Map<Date, Double> getTestMap() {
        return new HashMap<Date, Double>() {{
            put(getDate(2015, 1, 10), 0.1);
            put(getDate(2015, 2, 10), 0.05);
            put(getDate(2015, 4, 10), 0.15);
            put(getDate(2015, 4, 15), -0.10);
            put(getDate(2015, 6, 10), -0.12);
        }};
    }

    private Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day-1);
        return cal.getTime();
    }

    @Test
    public void bigTest() {
        Date base = getDate(2000,1,1);
        Date asOf = getDate(2030,1,1);

        CumRetCalculator calculator = new CumRetCalculator(getBigMap());

        Double actualResult = calculator.findCumReturn(asOf, base);
        System.out.println("Result: " + actualResult);

        assertEquals(1.99111, actualResult, 0.01);
    }

    private Map<Date, Double> getBigMap() {
        Map<Date, Double> map = new HashMap<>();
        Date current = getDate(2000,1,1);
        Date end = getDate(2030,1,2);

        while(current.before(end)) {
            map.put(current, 0.0001);
            current = incrementDate(current);
        }

        return map;
    }

    private Date incrementDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

}
