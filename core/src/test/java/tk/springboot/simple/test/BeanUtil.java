package tk.springboot.simple.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/9 10:37
 * @jdk v1.8
 */
public class BeanUtil {
    /**
     * @param args
     */
    public static void main(String[] args) {


        System.out.println(genCreateTableSql("tk.springboot.simple.model.Account"));

    }

    public static String getBeanName(String bean){
        try {
            Class clz = Class.forName(bean);
            String clzStr = clz.toString();
            //得到类名
            String beanName = clzStr.substring(clzStr.lastIndexOf(".")+1);
            return beanName.substring(0,1).toLowerCase()+beanName.substring(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<String> getBeanPropertyList(String bean){
        try {
            Class clz = Class.forName(bean);
            Field[] strs = clz.getDeclaredFields();
            List<String> propertyList = new ArrayList<String>();
            propertyList.add("int`id");
            for (int i = 0; i < strs.length; i++) {
                String protype = strs[i].getType().toString();
                propertyList.add(protype.substring(protype.lastIndexOf(".")+1)+"`"+strs[i].getName());
            }
            return propertyList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getBeanFilesList(String bean){
        try {
            Class clz = Class.forName(bean);
            Field[] strs = clz.getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strs.length; i++) {
                String protype = strs[i].getType().toString();
                if (!strs[i].getName().equals("tableName")&&!strs[i].getType().equals("List")) {
                    sb.append(strs[i].getName()+",");
                }
            }
            sb.deleteCharAt(sb.toString().lastIndexOf(","));
            return sb.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成建表語句
     * @param bean
     * @return
     */
    public static String genCreateTableSql(String bean){
        List<String> beanPropertyList =  getBeanPropertyList(bean);
        StringBuffer sb = new StringBuffer("create table "+camel2Underline(getBeanName(bean))+"(\n");
        for (String string : beanPropertyList) {
            String[] propertys = string.split("`");
            String field=camel2Underline(propertys[1]);
            if (!field.equals("tableName")&&!field.equals("param")&&!propertys[0].equals("List")) {
                if (field.equals("id")) {
                    sb.append("   id int(11) primary key auto_increment,\n");
                } else {
                    if (propertys[0].equals("int")) {
                        sb.append("   " + field + " int(11) '',\n");
                    } else if (propertys[0].equals("String")) {
                        sb.append("   " + field + " varchar(200) ,\n");
                    } else if (propertys[0].equals("double")) {
                        sb.append("   " + field + " double(10,2) ,\n");
                    } else if (propertys[0].equals("Date")) {
                        sb.append("   " + field + " datetime ,\n");
                    }else{
                        sb.append("   " + field + " tinyint(2) ,\n");
                    }
                }
            }
        }
        sb.append(")");
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }

    public static String camel2Underline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    /**
     * 生成查询语句
     * @param bean
     * @return
     */
    public static String genSelectAllSql(String bean){
        String filesList =  getBeanFilesList(bean);
        return "select \n "+filesList+" \n from \n wnk_pdt_"+getBeanName(bean)+"";
    }

}
