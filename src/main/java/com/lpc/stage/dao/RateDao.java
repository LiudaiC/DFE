package com.lpc.stage.dao;

import com.lpc.stage.model.Rate;
import com.lpc.stage.util.MybatisProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Stefan on 2018/4/26.
 */
@Mapper
public interface RateDao {

    @Insert("insert into df_rate(rate_level, rate) values(${rateFrom}, ${rate})")
    void saveRate(Rate rate);

    @InsertProvider(type = MybatisProvider.class, method = "saveRates")
    void saveRates(@Param("rates") List<Rate> rates);

    @Update("update df_rate set rate_level=${rateLevel}, rate=${rate} where id=${id}")
    void update(Rate rate);

    @Select("select * from df_rate where id=${id}")
    Rate getRateById(long id);

    @Select("select * from df_rate")
    List<Rate> getRates();
}
