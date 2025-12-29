package project.streaming_service.mapper.template;

public interface BaseMapper<D,T> {
    D toDto(T t);
    T toEntity(D d);
}
