package Models;

import java.util.List;

public interface Loader {
    public void save(List<Produto> produtos);
    public List<Produto> load();
}
