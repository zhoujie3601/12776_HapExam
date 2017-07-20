package hbi.core.demo.controllers;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.TokenException;
import com.hand.hap.excel.dto.ColumnInfo;
import com.hand.hap.excel.dto.ExportConfig;
import com.hand.hap.excel.service.IExportService;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.demo.dto.OrderHeaders;
import hbi.core.demo.service.IOrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 周洁 on 2017/1/13.
 */
@Controller
public class OrderHeadersController extends BaseController {
    @Autowired
    IOrderHeadersService orderHeadersService;
    @Autowired
    IExportService excelService;
    @Autowired
    ObjectMapper objectMapper;
    

    public OrderHeadersController(){

    }

    /*
    * 查询订单方法
    * */
    @RequestMapping({"/orders/query"})
    @ResponseBody
    public ResponseData getOrders(HttpServletRequest request, OrderHeaders orderHeaders, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pagesize) {
        //
        System.out.println("query Orders");
        IRequest iRequest = this.createRequestContext(request);
        List<OrderHeaders> orders = this.orderHeadersService.queryOrderHeaders(iRequest,orderHeaders,page,pagesize);
        for(OrderHeaders o : orders){
            System.out.println(o.getHeaderId()+o.getCompanyId()+o.getCompanyName()+o.getCustomerId()+o.getCustomerName());
        }
        return new ResponseData( this.orderHeadersService.queryOrderHeaders(iRequest,orderHeaders, page, pagesize));
    }

   /*
    * 添加修改订单方法
    * */
    @RequestMapping(
            value = {"/orders/submit"},
            method = {RequestMethod.POST}
    )
    public ResponseData submitOrders(@RequestBody List<OrderHeaders> orderHeaders, BindingResult result, HttpServletRequest request) throws TokenException {
        //this.checkToken(request, orderHeaders);
        this.getValidator().validate(orderHeaders, result);
        if(result.hasErrors()) {
            ResponseData requestCtx1 = new ResponseData(false);
            requestCtx1.setMessage(this.getErrorMessage(result, request));
            return requestCtx1;
        } else {
            IRequest requestCtx = this.createRequestContext(request);
            return new ResponseData(this.orderHeadersService.batchUpdate(requestCtx, orderHeaders));
        }
    }

    /*
    *
    * 删除订单请求方法
    * */
    @RequestMapping({"/orders/remove"})
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<OrderHeaders> orderHeaders) {
        this.orderHeadersService.batchDelete(orderHeaders);
        return  new ResponseData();
    }
    
    //导出excel
    @RequestMapping(value = "/orders/export")
    public void createXLS(HttpServletRequest request, @RequestParam String config,
                          HttpServletResponse httpServletResponse) {
        IRequest requestContext = createRequestContext(request);
        try {
            JavaType type = objectMapper.getTypeFactory().constructParametrizedType(ExportConfig.class,
                    ExportConfig.class, OrderHeaders.class,       ColumnInfo.class);
            ExportConfig<Function, ColumnInfo> exportConfig = objectMapper.readValue(config, type);
            excelService.exportAndDownloadExcel("hbi.core.demo.mapper.OrderHeadersMapper.queryOrderHeaders",
                    exportConfig, request, httpServletResponse, requestContext);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
