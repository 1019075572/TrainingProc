package com.ruoyi.generator.util;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 类PinyinTest.java的实现描述：TODO 类实现描述
 * @author riqi 2013-6-28 下午5:24:57
 */
public class PinyinUtils {

    public static void main(String[] args) {
        String input = "标题、类型、内容、任务启动时间、任务结束时间、接单数、赏金、等级、扩1、扩2、扩3、扩4、扩5、扩6";
        StringBuilder pinyin = new StringBuilder();
    String table = "yw_reward_task";
        for (int i = 0; i < input.length(); i++) {
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
            char c = input.charAt(i);
            String[] pinyinArray = null;
            try {
                pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            if (pinyinArray != null) {
                pinyin.append(pinyinArray[0]);
            } else if (c != ' ') {
                pinyin.append(input.charAt(i));
            }
        }

//        System.out.println(pinyin.toString().trim().toLowerCase());
String sp = "\t";
 sp = "、";
        String[] ch = input.split(sp);
        String[] en = pinyin.toString().trim().toLowerCase().split(sp);

        StringBuilder content = new StringBuilder();

        for (int i= 0;i<ch.length ;i++){
            content.append("`"+en[i]+"` varchar(255) NULL COMMENT '"+ch[i]+"',\n");
        }


        String sql = "CREATE TABLE `ry`.`"+table+"`  (\n" +
                "  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '编号',\n" +
                content.toString()+

                "  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者',\n" +
                "  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',\n" +
                "  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新者',\n" +
                "  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',\n" +
                "  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注信息',\n" +
                "  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',\n" +
                "  PRIMARY KEY (`id`)\n" +
                ");";

String ss ="ALTER TABLE `ry`.`"+table+"` COMMENT = '赏金任务';";
        System.out.println(sql);

        System.out.println(ss);

    }

}

