import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by jaffar on 2017/11/29.
 */
public class Rule {

    //空
    public static PredicateStr notNull(){
        return (v, k) -> v != null ? "" : k +"不能为空,";
    }

    //最小长度
    public static PredicateStr minLength(Integer length){
        return (v, k) -> v.length() >= length ? "" : k + "长度最少为" + length + "位,";
    }

    //属于
    public static PredicateStr in(List<String> platformIn){
        return (v, k) -> platformIn.contains(v) ? "" : k + "不在可选范围内:" + platformIn.toString();
    }

    //长度
    public static PredicateStr length(Integer length){
        return (v, k) -> v.length() == length ? "" : k + "长度最少为" + length + "位";
    }

    //最大长度
    public static PredicateStr maxLength(Integer length){
        return (v, k) -> v.length() <= length ? "" : k + "长度最大为" + length + "位";
    }

    //整数
    public static PredicateStr isNumber(){
        return (v, k) -> Pattern.compile("^[-\\+]?[\\d]*$").matcher(v).matches() ? "" : k + "必须为整数";
    }
}
