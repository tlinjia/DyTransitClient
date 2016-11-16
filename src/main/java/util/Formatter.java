package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lin on 2016/11/14.
 */
public class Formatter {
    public static int toIntLE(byte[] bytes) {   //小端--->整数
        int result = 0;
        result = ((bytes[0] & 0xFF)
                | ((bytes[1] & 0xFF) << 8)
                | ((bytes[2] & 0xFF) << 16)
                | ((bytes[3] & 0xFF) << 24));
        return result;
    }

    public static Map<String, Object> decodeMessage(String data) {
        Map<String, Object> map = new HashMap<String, Object>();
        data = data.substring(0, data.length() - 1);  //去除末尾'/0'
        String[] buffer = data.split("/");  //分隔
        for (String temp : buffer) {
            String key = temp.split("@=")[0];
            Object value = temp.split("@=").length >1?temp.split("@=")[1] : "";
            if (((String) value).contains("@A")) {  //子序列化,递归分析
                value = ((String) value).replaceAll("@S", "/").replaceAll("@A", "@");
                value = decodeMessage((String) value);
            }
            map.put(key, value);
        }


        return map;
    }

    public static String getText(Map map) {
        String text = null;
        if (map.get("type").equals("chatmsg")) {
            text = map.get("nn") + ":" + map.get("txt");
        } else if (map.get("type").equals("dgb")) {
            if (!map.containsKey("gfcnt")) {
                switch (Integer.valueOf((String)map.get("gfid"))) {
                    case 191:
                        text = map.get("nn") + "赠送了鱼丸";
                        break;
                    case 192:
                        text = map.get("nn") + "赠送了赞";
                        break;
                    case 193:
                        text = map.get("nn") + "赠送了弱鸡";
                        break;
                    case 194:
                        text = map.get("nn") + "赠送了666";
                        break;
                    case 195:
                        text = map.get("nn") + "赠送了飞机";
                        break;
                    case 196:
                        text = map.get("nn") + "赠送了火箭";
                        break;
                    default:
                        text = map.get("nn") + "赠送了不知道什么鬼，新礼物吗0_0?";
                }
            } else {
                switch ((Integer) map.get("gfid")) {
                    case 191:
                        text = map.get("nn") + "赠送了" + map.get("cnt") + "个鱼丸";
                        break;
                    case 192:
                        text = map.get("nn") + "赠送了" + map.get("cnt") + "个赞";
                        break;
                    case 193:
                        text = map.get("nn") + "赠送了" + map.get("cnt") + "个弱鸡";
                        break;
                    case 194:
                        text = map.get("nn") + "赠送了" + map.get("cnt") + "个666";
                        break;
                    case 195:
                        text = map.get("nn") + "赠送了" + map.get("cnt") + "个飞机";
                        break;
                    case 196:
                        text = map.get("nn") + "赠送了" + map.get("cnt") + "个火箭";
                        break;
                    default:
                        text = map.get("nn") + "赠送了不知道什么鬼，新礼物吗0_0?";
                }
            }
            if (map.containsKey("hits")) {
                text = text + " * " + map.get("hits");
            }
        } else if (map.get("type").equals("uenter")) {
            text = map.get("nn") + "进入了房间,等级" + map.get("level");
        } else if (map.get("type").equals("bc_buy_deserve")) {
            switch ((Integer) map.get("lev")) {
                case 1:
                    text = ((Map) map.get("sui")).get("nick") + "赠送了初级酬勤";
                    break;
                case 2:
                    text = ((Map) map.get("sui")).get("nick") + "赠送了中级酬勤";
                    break;
                case 3:
                    text = ((Map) map.get("sui")).get("nick") + "赠送了高级酬勤";
                    break;
                default:
                    text = map.get("sui") + "赠送了不知道什么鬼但是是酬勤……";
                    break;
            }
            if (map.containsKey("hits")) {
                text = text + " * " + map.get("hits");
            }
        } else if (map.get("type").equals("ssd")) {
            text = "------超级弹幕------\n" + map.get("content");
        } else if (map.get("type").equals("spbc")) {
            text = map.get("sn") + "送给" + map.get("dn") + map.get("gc") + "个" + map.get("gn");
        }


        return text;
    }
}