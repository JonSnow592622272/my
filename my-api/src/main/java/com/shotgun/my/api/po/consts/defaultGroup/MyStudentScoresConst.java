    package com.shotgun.my.api.po.consts.defaultGroup;

    import com.shotgun.mycommon.base.base.ViewEnum;
    import java.io.Serializable;
    import java.util.LinkedHashMap;
    import java.util.Map;

    /**
    * <p>
    * 表名：my_student_scores
    * 分数表
    * </p>
    */
    public class MyStudentScoresConst implements Serializable {

                /**
                * 类型
                **/
                public enum  TypeEnum implements ViewEnum{

                            YUWEN(1,"语文"),

                            SHUXUE(2,"数学"),

                            YINGYU(3,"英语"),

                ;
                private  Integer  value;

                private  String  text;

                TypeEnum(Integer value, String text){
                this.value = value;
                this.text = text;
                }

                public Integer getValue() {
                return value;
                }

                public void setValue(Integer value) {
                this.value = value;
                }

                public String getText() {
                return text;
                }

                public void setText(String text) {
                this.text = text;
                }

                public static Map<Integer, String> valueMap = new LinkedHashMap<>();

                public static Map<Integer, TypeEnum> enumMap = new LinkedHashMap<>();

                static {

                TypeEnum[] values = TypeEnum.values();

                for (TypeEnum val : values) {
                valueMap.put(val.value, val.text);
                enumMap.put(val.value, val);
                }

                }

                @Override
                public String text() {
                return this.text;
                }

                @Override
                public String value() {
                return String.valueOf(this.value);
                }}
    }
