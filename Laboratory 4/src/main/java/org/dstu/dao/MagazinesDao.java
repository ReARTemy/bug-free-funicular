package org.dstu.dao;

import org.dstu.domain.Magazines;

public class MagazinesDao extends BaseDaoImpl <Magazines, Integer> {
    public MagazinesDao() {
        super(Magazines.class);
    }
}
