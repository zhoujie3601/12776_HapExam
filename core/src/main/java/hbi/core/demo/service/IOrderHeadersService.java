package hbi.core.demo.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.demo.dto.OrderHeaders;

import java.io.InputStream;
import java.util.List;

/**
 * Created by 周洁 on 2017/1/13.
 */
public interface IOrderHeadersService extends IBaseService<OrderHeaders>,ProxySelf<IOrderHeadersService> {
    List<OrderHeaders> queryOrderHeaders(IRequest iRequest, OrderHeaders orderHeaders, int page, int pagesize);
    //OrderHeaders queryOrderInfo(IRequest iRequest, long headerId);

}
