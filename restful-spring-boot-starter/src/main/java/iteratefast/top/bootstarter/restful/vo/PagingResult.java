package iteratefast.top.bootstarter.restful.vo;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的分页数据包装类
 * Created by cz on 2018-5-11.
 */
public class PagingResult<T> implements Serializable{
    private static final long serialVersionUID = -8540148150591377290L;

    int pageSize;
    int pageNumber;
    long totalElements;
    List<T> list;

    public int getPageSize() {
        return pageSize;
    }

    public PagingResult setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public PagingResult setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public PagingResult setTotalElements(long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public PagingResult setList(List<T> list) {
        this.list = list;
        return this;
    }

    public static <T> PagingResult<T> of(Page<T> page){
        PagingResult<T> result = new PagingResult<T>();
        result.setPageSize(page.getSize());
        result.setPageNumber(page.getNumber());
        result.setTotalElements(page.getTotalElements());
        result.setList(page.getContent());
        return result;
    }
}
