package app;

import java.util.Set;

public interface IDAO<T> {
    T getUserId(Integer id);

    Set<T> getAll();

    void create(T t);

    void update(T t);
    void delete(T t);


}
