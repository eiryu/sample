package com.eiryu.sample;

import com.google.common.base.Strings;
import org.junit.Test;

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
    public void a_null空チェック(){
        assertThat(Strings.isNullOrEmpty(null), is(true));
        assertThat(Strings.isNullOrEmpty(""), is(true));
        assertThat(Strings.isNullOrEmpty("a"), is(false));
    }
}
