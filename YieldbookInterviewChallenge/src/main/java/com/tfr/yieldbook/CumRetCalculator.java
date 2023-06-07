package com.tfr.yieldbook;

import java.util.*;
import java.util.stream.Stream;

/**
 * Assumptions:
 *      - The answer will be rounded to 5 decimal places (as per the example on the problem statement)
 *      - For the return type of findCumReturn I used the object Double instead of the primitive double,
 *      as one test case from the problem statement returns a null. If you wanted to use the primitive
 *      form you could return a 0 instead.
 *      - Working on a multicore processor so that a parallel stream is effective.
 *
 * Design Decisions:
 *      - Since the order doesn't matter for the computation (multiplication can be done in any order
 *        with the same result) we don't need to worry about the order of the daily returns.
 *      - A stream is useful here as we can easily filter out the dates in the dailyReturns that are not
 *        needed for each call, map to the value of the dailyReturn, and accumulate the results. It also
 *        allows us to do the computation in parallel (for larger data sets) thanks to the associative
 *        property of multiplication.
 *
 * Created by Erik on 9/28/2017.
 */
class CumRetCalculator {

    private final Map<Date, Double> dailyReturns;

    /**
     * I didn't do extensive testing to determine this number, but you could do some benchmarking for different
     * sizes of dailyReturns to see where you get the best benefit for the parallel stream
     */
    private static final int PARALLEL_CUTOFF = 100;

    /**
     * A Map is already a good choice of data structure, because you can retrieve data in O(1) time. Also getting
     * the keySet is an O(1) operation, because it returns a reference to the keySet object in the Map object.
     * No new collections need to be created.
     */
    public CumRetCalculator(Map<Date, Double> dailyReturns)  {
        this.dailyReturns = dailyReturns;
    }

    /**
     * Because of the associative property of multiplication, we can use parallel reduction. However, for small
     * numbers of dailyReturns initializing a parallel stream takes more time then it saves. So we can use the
     * size of the dailyReturns map to determine whether to use a parallel stream or not.
     *
     * The stream itself consists of
     *  2 filters -> to exclude dates after the as of date and before the base date
     *  map -> mapping from the date key to the dailyReturn value in the dailyReturns plus 1
     *  reduce -> an accumulator is used to multiply all of the dailyReturns together
     *
     * Lastly we subtract 1 from the accumulated value as per the formula, and round it to 5 decimal places
     *
     * @param asOf - Date for which to calculate the cumulative return
     * @param base - Date of start of cumulative return calculation
     * @return Double - The Cumulative Return from the base date to the asof date
     */
    Double findCumReturn(final Date asOf, Date base) {
        if(asOf.before(base)) {
            return null; //or return 0 if you want to use primitive double as the return type
        }

        Stream<Date> dateStream;

        if(dailyReturns.size() > PARALLEL_CUTOFF) {
            dateStream = dailyReturns.keySet().parallelStream();
        } else {
            dateStream = dailyReturns.keySet().stream();
        }

        double cumReturn = dateStream
                .filter(currentDate -> currentDate.after(base))
                .filter(currentDate -> currentDate.before(asOf))
                .map(currentDate -> dailyReturns.get(currentDate) + 1)
                .reduce(1.0D, (acc, dailyReturn) -> acc * (dailyReturn));

        return Math.floor((cumReturn-1) * 1e5) / 1e5;
    }

}
