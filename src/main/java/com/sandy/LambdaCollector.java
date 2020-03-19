package com.sandy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description
 */
public class LambdaCollector {

    private static final String s = "lc_tdealprocess\n" +
            "lc_tdealprocess\n" +
            "lc_ttainfo\n" +
            "lc_tdealprocess\n" +
            "lc_ttainfo\n" +
            "lc_tcapitaldatedetail\n" +
            "lc_tcapitaldatedetail\n" +
            "lc_tcapitaldatedetail\n" +
            "lc_tdealprocess\n" +
            "lc_tdealprocess\n" +
            "lc_ttainfo\n" +
            "lc_tdealprocess\n" +
            "lc_ttainfo\n" +
            "lc_tcompresult\n" +
            "lc_taccorequest\n" +
            "lc_trequest\n" +
            "lc_tproductinfo\n" +
            "lc_tcrsrequest\n" +
            "lc_taccoconfirm\n" +
            "lc_tconfirm\n" +
            "lc_tstaticshare\n" +
            "lc_tstaticshare_liq\n" +
            "lc_tfundacco_liq\n" +
            "lc_tstaticshare\n" +
            "lc_tsharedetail\n" +
            "lc_tstaticshare\n" +
            "lc_vsharecurrent\n" +
            "lc_vconfirm\n" +
            "lc_vsharecurrent\n" +
            "lc_tcustfund\n" +
            "lc_vfundcurrent\n" +
            "lc_vconfirm\n" +
            "lc_vfundcurrent\n" +
            "lc_tfundcurrent\n" +
            "lc_tfundcurrent\n" +
            "lc_tfundcurrent_bak\n" +
            "lc_tfundcurrent\n" +
            "lc_tfundcurrent\n" +
            "lc_trequest\n" +
            "lc_tcustfund\n" +
            "lc_tcustfund_liq_detail\n" +
            "lc_tcustfund_liq\n" +
            "lc_tcustfund_liq\n" +
            "lc_tcustfund\n" +
            "lc_tcustfund_liq_detail\n" +
            "lc_tcustfund\n" +
            "lc_tfundcurrent\n" +
            "lc_taccobank\n" +
            "lc_tbankacco\n" +
            "lc_tproductinfodetail\n" +
            "lc_tfundcurrent\n" +
            "lc_tfundcurrent\n" +
            "lc_tfundcurrent_bak";

    public static void main(String[] args) {
        long count = Arrays.stream(s.split("\\n"))
                .count();
        System.out.println(count);

        Map<String, Long> collect = Arrays.stream(s.split("\\n"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.forEach((k, v) -> {
            System.out.println(k + " \t " + v);
        });

        Arrays.stream(s.split("\n"))
            .map(String::toLowerCase)
            .filter(str -> str.endsWith("_bak"))
            .forEach(System.out::println);
    }
}
