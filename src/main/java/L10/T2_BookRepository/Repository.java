package L10.T2_BookRepository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(String id) throws ItemNotFoundException;
    void save(T item);
    boolean delete(String id) throws ItemNotFoundException;

}
