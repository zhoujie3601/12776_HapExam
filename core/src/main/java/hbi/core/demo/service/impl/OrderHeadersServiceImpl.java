package hbi.core.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.message.IMessagePublisher;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.demo.dto.OrderHeaders;
import hbi.core.demo.mapper.OrderHeadersMapper;
import hbi.core.demo.service.IOrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 周洁 on 2017/1/13.
 */
@Service
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderHeadersService {
    @Autowired
    OrderHeadersMapper orderHeadersMapper;
    /*@Autowired
    OrderLinesMapper orderLinesMapper;*/
    @Autowired
    private IMessagePublisher messagePublisher;

    @Override
    public List<OrderHeaders> queryOrderHeaders(IRequest iRequestContext, OrderHeaders orderHeaders, int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        return this.orderHeadersMapper.queryOrderHeaders(orderHeaders);
    }


    protected boolean useSelectiveUpdate() {
        return false ;  }
    //批量保存
    public List<OrderHeaders> batchUpdate(IRequest request, List<OrderHeaders> list) {
        super.batchUpdate(request, list);
        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            OrderHeaders position = (OrderHeaders) var3.next();
            this.messagePublisher.publish("position.change", position);
        }

        return list;
    }

}
