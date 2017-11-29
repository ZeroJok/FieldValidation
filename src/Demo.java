import java.util.*;

/**
 * Created by jaffar on 2017/11/29.
 */
public class Demo {

    public static String filter(Map<String, Object> param, String key, PredicateStr... conditions){
        Optional<PredicateStr> optional = Arrays.stream(conditions)
                .filter((ps) -> ps.rule(String.valueOf(param.get(key)), key).length() != 0)
                .findFirst();
        return optional.isPresent() ? optional.get().rule(String.valueOf(param.get(key)), key) : "";
    }

    public static void main(String[] args){
        Map<String, Object> param = new HashMap<String, Object>(){{
            put("mobile", 110);
            put("password", null);
            put("nickname", new Date());
        }};

        String errorMsg = "";
        errorMsg += filter(param, "mobile", Rule.notNull(), Rule.minLength(11));
        errorMsg += filter(param, "password", Rule.notNull(), Rule.minLength(6));
        errorMsg += filter(param, "nickname", Rule.notNull());
        System.out.println(errorMsg);
    }

}
