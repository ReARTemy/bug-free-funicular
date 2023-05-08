package domain;

import java.io.Serializable;

public interface PrintedType extends Serializable{
    default void print() {
        System.out.println(toString());
    }
}
