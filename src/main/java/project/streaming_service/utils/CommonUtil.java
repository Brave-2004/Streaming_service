package project.streaming_service.utils;


public class CommonUtil {

    public static <T> T getOrDefault(T value, T def) {

        return value == null ? def : value;

    }

}
