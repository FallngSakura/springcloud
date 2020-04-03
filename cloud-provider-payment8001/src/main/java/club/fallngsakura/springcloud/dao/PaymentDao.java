package club.fallngsakura.springcloud.dao;

import club.fallngsakura.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author MISAKI RINNE
 */
@Mapper
public interface PaymentDao
{
    /**
     * 新增Payment
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 根据Id获取Payment
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id")Long id);
}
