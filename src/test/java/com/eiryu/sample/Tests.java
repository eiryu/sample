package com.eiryu.sample;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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

    @Test
    public void c_日付計算() {
        Date now = new Date();
        Date twoWeeksAgo = DateUtils.addDays(now, -14);
        System.out.println(twoWeeksAgo);
    }

    @Test
    public void d_タイムゾーン() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(new Date()));
    }

    @Test
    public void e_dom4j_要素を一通り辿ってインデントを入れて出力() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("pom.xml");
        Element rootElement = document.getRootElement();

        display(rootElement.elements(), 0);
    }

    /**
     * 要素を繰り返し出力する
     * 
     * @param elements
     * @param indent
     */
    private void display(@SuppressWarnings("rawtypes") List elements, int indent) {
        if (elements.size() == 0) {
            return;
        }
        for (Object o : elements) {
            printIndent(indent);
            
            Element e = (Element) o;
            System.out.println(e.getName());
            
            display(e.elements(), indent + 1);
        }
    }

    /**
     * インデントを出力する
     * 
     * @param indent
     */
    private void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
    }
}
