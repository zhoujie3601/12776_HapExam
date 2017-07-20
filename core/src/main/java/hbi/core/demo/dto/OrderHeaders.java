package hbi.core.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.core.annotation.MultiLanguageField;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by 周洁 on 2017/1/11.
 */
@Table(name = "hap_om_order_headers")
public class OrderHeaders{
        @Id
        @GeneratedValue
        private long headerId;//头id
        private String orderNumber;//订单编号
        private long companyId;//公司id
        @Transient
        private String companyName;
        private Date orderDate;//创建时间
        @MultiLanguageField
        private String orderStatus;//订单状态
        private long customerId;//客户id
        @Transient
        private String customerName;
        @Transient
        private Double totalMoney;
        @Transient
        private Companys companys;
        @Transient
        private Customers customers;
        @Transient
        private List<OrderLines> orderLinesList;
        @Transient
        private Integer page = Integer.valueOf(1);
        @Transient
        private Integer pagesize = Integer.valueOf(10);
        @Transient
        @JsonFormat(
                pattern = "yyyy-MM-dd HH:mm:ss"
        )
        private Date startDate;
        @Transient
        @JsonFormat(
                pattern = "yyyy-MM-dd HH:mm:ss"
        )
        private Date endDate;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public Double getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(Double totalMoney) {
            this.totalMoney = totalMoney;
        }


        public List<OrderLines> getOrderLinesList() {
            return orderLinesList;
        }

        public void setOrderLinesList(List<OrderLines> orderLinesList) {
            this.orderLinesList = orderLinesList;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPagesize() {
            return pagesize;
        }

        public void setPagesize(Integer pagesize) {
            this.pagesize = pagesize;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public Companys getCompanys() {
            return companys;
        }

        public void setCompanys(Companys companys) {
            this.companys = companys;
        }

        public Customers getCustomers() {
            return customers;
        }

        public void setCustomers(Customers customers) {
            this.customers = customers;
        }

        public Long getHeaderId() {
            return headerId;
        }

        public void setHeaderId(Long headerId) {
            this.headerId = headerId;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public Long getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Long companyId) {
            this.companyId = companyId;
        }

        public Date getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }

}
