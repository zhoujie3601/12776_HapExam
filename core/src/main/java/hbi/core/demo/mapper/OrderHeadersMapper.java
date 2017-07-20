package hbi.core.demo.mapper;

import com.hand.hap.core.IRequest;
import com.hand.hap.mybatis.common.Mapper;
import hbi.core.demo.dto.OrderHeaders;

import java.util.List;

/**
 * Created by 周洁 on 2017/1/13.
 */
public interface OrderHeadersMapper extends Mapper<OrderHeaders>{
    List<OrderHeaders> queryOrderHeaders(OrderHeaders orderHeaderst );
    //OrderHeaders queryOrderInfo(IRequest iRequest, long headerId);
}
