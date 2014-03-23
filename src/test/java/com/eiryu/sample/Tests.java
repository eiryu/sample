package com.eiryu.sample;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * @author eiryu
 * 
 */
public class Tests {

    @Test
    public void a_プリミティブ配列からコレクションに変換() {
        long[] primitiveArray = { 1L, 2L };
        Long[] wrapperArray = ArrayUtils.toObject(primitiveArray);
        List<Long> list = Arrays.asList(wrapperArray);
        for (Long long1 : list) {
            System.out.println(long1);
        }
    }

    @Test
    public void b_コレクションからプリミティブ配列に変換() {
        List<Long> list = Arrays.asList(1L, 2L);
        Long[] wrapperArray = (Long[]) list.toArray();
        long[] primitiveArray = ArrayUtils.toPrimitive(wrapperArray);
        for (long long1 : primitiveArray) {
            System.out.println(long1);
        }
    }
}
