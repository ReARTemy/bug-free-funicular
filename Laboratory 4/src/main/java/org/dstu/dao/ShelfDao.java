package org.dstu.dao;

import org.dstu.domain.Shelf;

public class ShelfDao extends BaseDaoImpl<Shelf, Integer> {
    public ShelfDao() {
        super(Shelf.class);
    }
}
