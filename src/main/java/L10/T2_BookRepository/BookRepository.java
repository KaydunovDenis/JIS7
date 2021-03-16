package L10.T2_BookRepository;

import java.util.*;

public class BookRepository implements Repository<Book> {
    public static Map<String, Book> map = new HashMap<>();

    @Override
    public List<Book> findAll() {
        List<Book> listBook = new ArrayList<>();
        for (Map.Entry<String, Book> entry : map.entrySet()) {
            listBook.add(entry.getValue());
        }
        return listBook;
    }

    @Override
    public Book findById(String id) throws ItemNotFoundException {
        if (!id.isEmpty()) {
            for (Map.Entry<String, Book> entry : map.entrySet()) {
                if (entry.getKey().equals(id)) {
                    return entry.getValue();
                }
            }
        }
        throw new ItemNotFoundException("Элемент " + id + " не найден.");
    }

    @Override
    public void save(Book item) {
        map.put(item.getId(), item);
    }

    @Override
    public boolean delete(String id) throws ItemNotFoundException {
        if (!id.isEmpty()) {
            for (Iterator<Map.Entry<String, Book>> it = map.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Book> entry = it.next();
                if (entry.getKey().equals(id)) {
                    System.out.println(it.toString() + " удален.");
                    it.remove();
                    return true;
                }
            }
            throw new ItemNotFoundException("Элемент " + id + " для удаления не найден.");
        }
        throw new ItemNotFoundException("Некорректный id");
    }

    public Map<String, Book> getMap() {
        return map;
    }


}
