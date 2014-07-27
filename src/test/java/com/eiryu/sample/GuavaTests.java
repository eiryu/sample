package com.eiryu.sample;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/07/12
 * Time: 13:14
 * To change this template use File | Settings | File Templates.
 */
public class GuavaTests {

    @Test
    public void a_null空チェック() {
        assertThat(Strings.isNullOrEmpty(null), is(true));
        assertThat(Strings.isNullOrEmpty(""), is(true));
        assertThat(Strings.isNullOrEmpty("a"), is(false));
    }

    @Test
    public void b_プリミティブ配列からコレクションに変換() {
        int[] intArray = {1, 2, 3};
        List<Integer> integerList = Ints.asList(intArray);

        assertThat(integerList.get(0), is(1));
        assertThat(integerList.get(1), is(2));
        assertThat(integerList.get(2), is(3));
    }

}
