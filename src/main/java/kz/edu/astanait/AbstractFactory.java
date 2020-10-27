package kz.edu.astanait;

public interface AbstractFactory<T> {
    T create(String type);
}
