package iteratefast.top.bootstarter.restful.vo;

import java.io.Serializable;

/**
 * 分页请求
 * Created by cz on 2018-3-16.
 */
public class Pagination implements Serializable{
    private static final long serialVersionUID = 8168131594377060502L;

    int page = 1;
    int size = 10;

    public int getPage() {
        return page;
    }

    public Pagination setPage(int page) {
        this.page = page;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Pagination setSize(int size) {
        this.size = size;
        return this;
    }
}
